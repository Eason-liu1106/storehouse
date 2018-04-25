package com.storehouse.pojo;

import java.sql.Timestamp;

/**
 * Measureunits entity. @author MyEclipse Persistence Tools
 */

public class Measureunits implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String remark;
	private Timestamp createdatetime;
	private Timestamp modifydatetime;

	// Constructors

	/** default constructor */
	public Measureunits() {
	}

	/** full constructor */
	public Measureunits(String name, String remark, Timestamp createdatetime,
			Timestamp modifydatetime) {
		this.name = name;
		this.remark = remark;
		this.createdatetime = createdatetime;
		this.modifydatetime = modifydatetime;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Timestamp getCreatedatetime() {
		return this.createdatetime;
	}

	public void setCreatedatetime(Timestamp createdatetime) {
		this.createdatetime = createdatetime;
	}

	public Timestamp getModifydatetime() {
		return this.modifydatetime;
	}

	public void setModifydatetime(Timestamp modifydatetime) {
		this.modifydatetime = modifydatetime;
	}

}