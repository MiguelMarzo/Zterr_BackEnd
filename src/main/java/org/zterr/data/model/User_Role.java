package org.zterr.data.model;

public class User_Role {
	private Integer idUser;
	private Integer idRole;
	
	
	public User_Role() {

	}


	public User_Role(Integer idUser, Integer idRole) {
		super();
		this.idUser = idUser;
		this.idRole = idRole;
	}


	public Integer getIdUser() {
		return idUser;
	}


	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}


	public Integer getIdRole() {
		return idRole;
	}


	public void setIdRole(Integer idRole) {
		this.idRole = idRole;
	}
	
	
}
