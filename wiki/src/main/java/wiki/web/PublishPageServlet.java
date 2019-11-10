package wiki.web;

import java.io.IOException;

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

public class PublishPageServlet extends HttpServlet {
	private Logger logger = Logger.getLogger(this.getClass());
	private RequestDispatcher jsp;
	public void init(ServletConfig config) throws ServletException 
	{
		ServletContext context = config.getServletContext();
		jsp = context.getRequestDispatcher("/WEB-INF/jsp/publish-page.jsp");
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		logger.debug("doGet()");
		String pathInfo = req.getPathInfo();
		String name = pathInfo.substring(1);
		logger.debug("Page requested: " + name);
		Page page = new PageDAO().find(name);
		if (page == null) 
		{
			logger.debug("page doesn't exist; creating empty page");
			page = new Page();
			page.setName(name);
			page.setContent("");
			page.setPublished(false);
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
			resp.sendRedirect("../view/" + pageName);
			return;
		}
		PageDAO pageDAO = new PageDAO();
		Page page = pageDAO.find(pageName);
		
		// Don't do anything if page doesn't exist or is already published.
		if (page == null || page.isPublished())
		{
			resp.sendRedirect("../view/" + pageName);
			return;
		}
		
		// Invoke remote web service to publish page.
		logger.debug("invoking web service");
		try
		{
			String publishedId = publish(page);
			page.setPublishedId(publishedId);
			page.setPublished(true);
		}
		catch (Exception e)
		{
			logger.error(e);
			throw new RuntimeException(e);
		}
		
		// Update page.
		pageDAO.update(page);
		resp.sendRedirect("../view/" + page.getName());
	}
	
	private String publish(Page page) throws IOException
	{
		return "3"; // Pretend that publish service returned an id of 3.
	}
}