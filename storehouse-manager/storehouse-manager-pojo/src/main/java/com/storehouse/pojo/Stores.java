package com.storehouse.pojo;

import java.sql.Timestamp;
import java.util.Set;



/**
 * Stores entity. @author MyEclipse Persistence Tools
 */

public class Stores implements java.io.Serializable {

	// Fields

	private String id;

	private StoreType storeType;
	
	private Rack rack;

	private Calculate calculate;
	private String name;
	private String description;
	private Timestamp createdatetime;
	private Timestamp modifydatetime;
	private String stock;
	private String bigstock;
	private String smallstock;
	private Integer iffull;
	

	/** default constructor */
	public Stores() {
	}

	/** full constructor */
	public Stores(String id, StoreType storeType, Rack rack,
			Calculate calculate, String name, String description,
			Timestamp createdatetime, Timestamp modifydatetime, String stock,
			String bigstock, String smallstock, Integer iffull) {
		this.id = id;
		this.storeType = storeType;
		this.rack = rack;
		this.calculate = calculate;
		this.name = name;
		this.description = description;
		this.createdatetime = createdatetime;
		this.modifydatetime = modifydatetime;
		this.stock = stock;
		this.bigstock = bigstock;
		this.smallstock = smallstock;
		this.iffull = iffull;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public StoreType getStoreType() {
		return this.storeType;
	}

	public void setStoreType(StoreType storeType) {
		this.storeType = storeType;
	}

	public Rack getRack() {
		return this.rack;
	}

	public void setRack(Rack rack) {
		this.rack = rack;
	}

	public Calculate getCalculate() {
		return this.calculate;
	}

	public void setCalculate(Calculate calculate) {
		this.calculate = calculate;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getStock() {
		return this.stock;
	}

	public void setStock(String stock) {
		this.stock = stock;
	}

	public String getBigstock() {
		return this.bigstock;
	}

	public void setBigstock(String bigstock) {
		this.bigstock = bigstock;
	}

	public String getSmallstock() {
		return this.smallstock;
	}

	public void setSmallstock(String smallstock) {
		this.smallstock = smallstock;
	}

	public Integer getIffull() {
		return this.iffull;
	}

	public void setIffull(Integer iffull) {
		this.iffull = iffull;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}