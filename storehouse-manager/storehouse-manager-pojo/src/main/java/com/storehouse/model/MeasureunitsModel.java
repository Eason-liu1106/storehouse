package com.storehouse.model;

import java.sql.Timestamp;

public class MeasureunitsModel {
	private Integer id;
	private Timestamp createdatetime;
	private Timestamp modifydatetime;
	public MeasureunitsModel(Integer id, Timestamp createdatetime, Timestamp modifydatetime) {
		super();
		this.id = id;
		this.createdatetime = createdatetime;
		this.modifydatetime = modifydatetime;
	}
	public MeasureunitsModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
