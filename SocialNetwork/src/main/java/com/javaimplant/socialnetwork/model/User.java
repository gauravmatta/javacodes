package com.javaimplant.socialnetwork.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="users")
public class User implements Serializable {

	private static final long serialVersionUID = 3796026304550040415L;

	@Id
	@Column(name="Id")
	@GenericGenerator(name="inc",strategy = "increment")
	@GeneratedValue(generator = "inc")
	private Integer id;
	
	@Column(name="name")
	private String userName;
	
	@Column(name="password")
	private String password;
	
	public User() {
		super();
	}

//	@OneToMany(fetch=FetchType.EAGER)
//	private Set<User> friends;

	public User(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

//	public Set<User> getFriends() {
//		return friends;
//	}
//
//	public void setFriends(Set<User> friends) {
//		this.friends = friends;
//	}

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
