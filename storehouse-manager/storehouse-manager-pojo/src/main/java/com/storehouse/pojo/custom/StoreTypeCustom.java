package com.storehouse.pojo.custom;

import java.sql.Timestamp;



public class StoreTypeCustom implements java.io.Serializable{
	private String id;
	private String name;
	private String description;
	private Timestamp createdatetime;
	private Timestamp modifydatetime;
	public String getId() {
		return id;
	}
	public void setId(String id) {
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
	
	public Timestamp getCreatedatetime() {
		return createdatetime;
	}
	public void setCreatedatetime(Timestamp createdatetime) {
		this.createdatetime = createdatetime;
	}
	public Timestamp getModifydatetime() {
		return modifydatetime;
	}
	public void setModifydatetime(Timestamp modifydatetime) {
		this.modifydatetime = modifydatetime;
	}
	
}
