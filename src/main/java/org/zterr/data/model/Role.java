package org.zterr.data.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents the Role
 * 
 * @author Sergio
 *
 */
public class Role {
	private Integer id;
	private String name;
	private String description;
	private List<Role> roles = new ArrayList<Role>();
	
	public Role(){
		
	}
	
	/**
	 * @param id
	 * @param name
	 * @param description
	 */
	public Role(Integer id, String name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;
	}
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}


	
}
