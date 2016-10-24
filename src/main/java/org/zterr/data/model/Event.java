package org.zterr.data.model;

import java.sql.Date;

public class Event {
	private Integer id;
	private String name;
	private String description;
	private Date event_date;
	private float latitude;
	private float longitude;
	private User user;

	public Event() {

	}

	public Event(Integer id, String name, String description, Date event_date, float latitude, float longitude,
			User user) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.event_date = event_date;
		this.latitude = latitude;
		this.longitude = longitude;
		this.user = user;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getEvent_date() {
		return event_date;
	}

	public void setEvent_date(Date event_date) {
		this.event_date = event_date;
	}

	public float getLatitude() {
		return latitude;
	}

	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}

	public float getLongitude() {
		return longitude;
	}

	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}



}
