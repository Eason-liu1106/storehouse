package com.storehouse.pojo;

import java.sql.Timestamp;



/**
 * StoreType entity. @author MyEclipse Persistence Tools
 */

public class StoreType implements java.io.Serializable {

	// Fields

	private String id;
	private String name;
	private String description ;
	private Timestamp createdatetime;
	private Timestamp modifydatetime;

	//private Set storeses = new HashSet(0);

	// Constructors

	/** default constructor */
	public StoreType() {
	}

	/** minimal constructor */
	public StoreType(String id, String name, String description,
			Timestamp createdatetime, Timestamp modifydatetime) {
		this.id = id;
		this.name = name;
		this.description= description;
		this.createdatetime = createdatetime;
		this.modifydatetime = modifydatetime;
	}

	/** full constructor */
//	public StoreType(String id, String name, String description,
//			Timestamp createdatetime, Timestamp modifydatetime, Set storeses) {
//		this.id = id;
//		this.name = name;
//		this.description = description;
//		this.createdatetime = createdatetime;
//		this.modifydatetime = modifydatetime;
//		this.storeses = storeses;
//	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
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

//	public Set getStoreses() {
//		return this.storeses;
//	}
//
//	public void setStoreses(Set storeses) {
//		this.storeses = storeses;
//	}

}