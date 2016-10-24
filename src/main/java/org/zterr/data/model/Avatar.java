package org.zterr.data.model;

public class Avatar {
	private Integer id;
	private String description;
	private String image;
	private User user;

	public Avatar() {

	}

	public Avatar(Integer id, String description, String image) {
		this.id = id;
		this.description = description;
		this.image = image;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
