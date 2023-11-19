package com.springimplant.jobportal.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.springimplant.jobportal.entity.JobPosting;

import lombok.Data;

@Data
public class JobPostingDAO {
	
	private  Connection conn;
	
	public JobPostingDAO() {
		final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
		final String Database_URL = "jdbc:mysql://localhost:3306/JobPortal";
		final String Database_USER = "root";
		final String Database_PASS = "root@04G";
		try {
			Class.forName(JDBC_DRIVER);
			this.conn = DriverManager.getConnection(Database_URL,Database_USER,Database_PASS);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public JobPosting getJobPostingById(int id) {
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from JobPostings where id = "+id);
			if(rs.next()) {
				JobPosting jobPostToReturn = new JobPosting();
				jobPostToReturn.setContactPhone(rs.getString("contactPhone"));
				jobPostToReturn.setJobName(rs.getString("jobName"));
				jobPostToReturn.setPosterName(rs.getString("posterName"));
				jobPostToReturn.setMessageBody(rs.getString("messageBody"));
				jobPostToReturn.setId(rs.getInt("id"));
				jobPostToReturn.setJobPostingPassword(rs.getString("jobPostingPassword"));
				return jobPostToReturn;
			}
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void insertJobPosting(JobPosting posting) {
		String sep = "','";
		try {
			Statement st = conn.createStatement();
			String sqlQuery="INSERT INTO JobPostings (messageBody,jobName,posterName,contactPhone,jobPostingPassword) VALUES('"+
					posting.getMessageBody()+sep+posting.getJobName()+sep+posting.getPosterName()+sep+posting.getContactPhone()+sep+posting.getJobPostingPassword()+"')";
			System.out.println(sqlQuery);
			st.executeUpdate(sqlQuery);
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void removeJobPosting(int jobPostId) {
		try {
			Statement st = conn.createStatement();
			st.executeUpdate("DELETE FROM JobPostings WHERE id="+jobPostId);
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<JobPosting> getAllJobPostings() {
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("SELECT id, messageBody, posterName, jobName, contactPhone, jobPostingPassword FROM JobPostings limit 200");
			List<JobPosting> jobs = new ArrayList<JobPosting>();
			while(rs.next()) {
				JobPosting jobPostToReturn = new JobPosting();
				jobPostToReturn.setContactPhone(rs.getString("contactPhone"));
				jobPostToReturn.setJobName(rs.getString("jobName"));
				jobPostToReturn.setPosterName(rs.getString("posterName"));
				jobPostToReturn.setMessageBody(rs.getString("messageBody"));
				jobPostToReturn.setId(rs.getInt("id"));
				jobs.add(jobPostToReturn);
			}
			st.close();
			rs.close();
			return jobs;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Collections.emptyList();
	}
	
	public void close() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
