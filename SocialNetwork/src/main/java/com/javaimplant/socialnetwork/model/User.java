package com.javaimplant.socialnetwork.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="users")
public class User {

	@Id
	@Column(name="Id")
	@GenericGenerator(name="inc",strategy = "increment")
	@GeneratedValue(generator = "inc")
	private Integer id;
	
	@Column(name="name")
	private String userName;
	
	@Column(name="password")
	private String password;
	
	@OneToMany(fetch=FetchType.EAGER)
	private List<User> friends= new ArrayList<>();

	public List<User> getFriends() {
		return friends;
	}

	public void setFriends(List<User> friends) {
		this.friends = friends;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
