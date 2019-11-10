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

public class EditPageServlet extends HttpServlet {
	private Logger logger = Logger.getLogger(this.getClass());
	private RequestDispatcher jsp;
	
	public void init(ServletConfig config) throws ServletException 
	{
		ServletContext context = config.getServletContext();
		jsp = context.getRequestDispatcher("/WEB-INF/jsp/edit-page.jsp");
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
		// Extract form data.
		String pageName = req.getParameter("name");
		String content = req.getParameter("content");
		String publishedString = req.getParameter("published");
		Boolean publishedBoolean = Boolean.valueOf(publishedString);
		boolean published = publishedBoolean.booleanValue();
		// Check for cancel button.
		String cancelButton = req.getParameter("cancel-button");
		if (cancelButton != null) 
		{
			resp.sendRedirect("../view/" + pageName);
			return;
		}
		// Prepare a page object.
		PageDAO pageDAO = new PageDAO();
		Page page = new Page();
		page.setName(pageName);
		page.setContent(content);
		page.setPublished(published);
		// Check to see if user is setting page content to nothing (or all
		// spaces).
		if (content.trim().length() == 0) 
		{
			pageDAO.delete(page);
			resp.sendRedirect("../view/" + page.getName());
			return;
		}
		// Create or update page as appropriate.
		if (pageDAO.find(pageName) == null) 
		{
			// Page doesn't exist; insert into database.
			pageDAO.create(page);
		}
		else 
		{
			// Page exists; update database.
			pageDAO.update(page);
		}
		resp.sendRedirect("../view/" + page.getName());
	}
}
