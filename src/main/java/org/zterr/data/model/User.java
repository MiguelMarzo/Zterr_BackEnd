package org.zterr.data.model;

import java.util.ArrayList;
import java.util.List;

public class User {
	private Integer id;
	private String username;
	private String password;
	private String email;
	private Avatar avatar;
	private List<Event> events = new ArrayList<Event>();
	private List<Role> roles = new ArrayList<Role>();

	/**
	 * Default constructor
	 */
	public User() {

	}

	/**
	 * Constructor with all attributes
	 * 
	 * @param id
	 * @param username
	 * @param password
	 * @param email
	 */
	public User(String username, String password, String email) {
		this.username = username;
		this.password = password;
		this.email = email;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Avatar getAvatar() {
		return avatar;
	}

	public void setAvatar(Avatar avatar) {
		this.avatar = avatar;
	}

	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> roles) {
		this.events = events;
	}
	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}


}
