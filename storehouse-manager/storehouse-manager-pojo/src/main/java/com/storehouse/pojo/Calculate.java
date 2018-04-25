package com.storehouse.pojo;

import java.sql.Timestamp;



/**
 * Calculate entity. @author MyEclipse Persistence Tools
 */

public class Calculate implements java.io.Serializable {

	// Fields

	private String id;
	private String mon;
	private Timestamp createdatetime;
	private Timestamp modifydatetime;
	private String name;
	//@JsonIgnore
	//private Set storeses = new HashSet(0);

	// Constructors

	/** default constructor */
	public Calculate() {
	}

	/** minimal constructor */
	public Calculate(String id, String mon, Timestamp createdatetime,
			Timestamp modifydatetime, String name) {
		this.id = id;
		this.mon = mon;
		this.createdatetime = createdatetime;
		this.modifydatetime = modifydatetime;
		this.name = name;
	}

	/** full constructor */
//	public Calculate(String id, String mon, Timestamp createdatetime,
//			Timestamp modifydatetime, String name, Set storeses) {
//		this.id = id;
//		this.mon = mon;
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

	public String getMon() {
		return this.mon;
	}

	public void setMon(String mon) {
		this.mon = mon;
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