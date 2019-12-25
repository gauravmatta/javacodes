package wiki.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

import javax.net.SocketFactory;
import javax.net.ssl.SSLSocketFactory;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import wiki.data.Page;
import wiki.data.PageDAO;

public class UnpublishPageServlet extends HttpServlet {
	private Logger logger = Logger.getLogger(this.getClass());
	private RequestDispatcher jsp;
	
	public void init(ServletConfig config) throws ServletException 
	{
		ServletContext context = config.getServletContext();
		jsp = context.getRequestDispatcher("/WEB-INF/jsp/unpublish-page.jsp");
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		logger.debug("doGet()");
		String pathInfo = req.getPathInfo();
		String name = pathInfo.substring(1);
		Page page = new PageDAO().find(name);
		
		// Don't allow users to publish empty pages.
		if (page == null) 
		{
			resp.sendRedirect("../view/" + name);
			return;
		}
		req.setAttribute("wikipage", page);
		jsp.forward(req, resp);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		logger.debug("doPost()");
		// extract form data
		String pageName = req.getParameter("name");
		// Check for cancel button.
		String cancelButton = req.getParameter("cancel-button");
		if (cancelButton != null) 
		{
			String msg="You cancelled the operation";
			req.getSession().setAttribute("msg",msg);
			resp.sendRedirect("../view/" + pageName);
			return;
		}
		PageDAO pageDAO = new PageDAO();
		Page page = pageDAO.find(pageName);
		// Don't do anything if page doesn't exist or is already unpublished.
		if (page == null || !page.isPublished()) 
		{
			resp.sendRedirect("../view/" + pageName);
			return;
		}
		// Invoke remote web service to unpublish page.
		logger.debug("invoking web service");
		unpublish(page);
		// Update page.
		page.setPublished(false);
		pageDAO.update(page);
		resp.sendRedirect("../view/" + page.getName());
	}
	
	private void unpublish(Page page) throws IOException
	{
		logger.debug("unpublish()");
		// Construct HTTP headers.
		String requestLine = "GET /newsfeed/unpublish?id=" + page.getPublishedId() + " HTTP/1.1\r\n";
		String hostHeader = "Host: localhost\r\n";
		String connectionHeader = "Connection: close\r\n";
		// Send HTTP headers.
//		Socket socket = new Socket("localhost", 8080);
		SocketFactory socketFactory = SSLSocketFactory.getDefault();
		Socket socket = socketFactory.createSocket("localhost", 8443);
		OutputStream os = socket.getOutputStream();
		os.write(requestLine.getBytes("US-ASCII"));
		os.write(hostHeader.getBytes("US-ASCII"));
		os.write(connectionHeader.getBytes("US-ASCII"));
		os.write("\r\n".getBytes("US-ASCII"));
		os.flush();
		// Read HTTP response.
		InputStream is = socket.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		while (true)
		{
			String headerLine = br.readLine();
			if (headerLine.length() == 0) break;
		}
	}
}
