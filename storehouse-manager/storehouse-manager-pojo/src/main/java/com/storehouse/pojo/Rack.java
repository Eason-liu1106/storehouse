package com.storehouse.pojo;

import java.sql.Timestamp;



/**
 * Rack entity. @author MyEclipse Persistence Tools
 */

public class Rack implements java.io.Serializable {

	// Fields

	private String id;
	private String parm;
	private Timestamp createdatetime;
	private Timestamp modifydatetime;
	private String name;

	//private Set storeses = new HashSet(0);

	// Constructors

	/** default constructor */
	public Rack() {
	}

	/** minimal constructor */
	public Rack(String id, String parm, Timestamp createdatetime,
			Timestamp modifydatetime, String name) {
		this.id = id;
		this.parm = parm;
		this.createdatetime = createdatetime;
		this.modifydatetime = modifydatetime;
		this.name = name;
	}

	/** full constructor */
//	public Rack(String id, String parm, Timestamp createdatetime,
//			Timestamp modifydatetime, String name, Set storeses) {
//		this.id = id;
//		this.parm = parm;
//		this.createdatetime = createdatetime;
//		this.modifydatetime = modifydatetime;
//		this.name = name;
//		this.storeses = storeses;
//	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getParm() {
		return this.parm;
	}

	public void setParm(String parm) {
		this.parm = parm;
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

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

//	public Set getStoreses() {
//		return this.storeses;
//	}
//
//	public void setStoreses(Set storeses) {
//		this.storeses = storeses;
//	}

}