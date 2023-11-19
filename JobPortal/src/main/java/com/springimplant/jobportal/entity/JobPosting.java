package com.springimplant.jobportal.entity;

import lombok.Data;

@Data
public class JobPosting {
	private int id;
	private String messageBody;
	private String jobName;
	private String posterName;
	private String contactPhone;
	private String jobPostingPassword;
}
