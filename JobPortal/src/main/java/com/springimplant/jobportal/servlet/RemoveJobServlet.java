package com.springimplant.jobportal.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.springimplant.jobportal.dao.JobPostingDAO;
import com.springimplant.jobportal.entity.JobPosting;

@WebServlet(urlPatterns = {"/RemoveJob","/JobRemove"})
public class RemoveJobServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RemoveJobServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/removeJob.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JobPostingDAO dao = new JobPostingDAO();
		int jobPostingId = Integer.parseInt(request.getParameter("id"));
		JobPosting post = dao.getJobPostingById(jobPostingId);
		
		if(post == (null)) {
			request.setAttribute("error", true);
			RequestDispatcher rd = request.getRequestDispatcher("/removeJob.jsp");
			rd.forward(request, response);
		} else {
			if (post.getJobPostingPassword().equals(request.getParameter("password"))) {
				dao.removeJobPosting(jobPostingId);
				RequestDispatcher rd = request.getRequestDispatcher("/removeJobSuccess.jsp");
				rd.forward(request, response);
			} else {
				request.setAttribute("error", true);
				RequestDispatcher rd = request.getRequestDispatcher("/removeJob.jsp");
				rd.forward(request, response);
			}
		}
	}

}
