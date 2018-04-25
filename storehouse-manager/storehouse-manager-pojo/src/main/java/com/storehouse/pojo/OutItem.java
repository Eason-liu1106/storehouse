package com.storehouse.pojo;

import java.sql.Timestamp;

/**
 * OutItem entity. @author MyEclipse Persistence Tools
 */

public class OutItem implements java.io.Serializable {

	// Fields

	private String id;
	private String outStoreName;
	private String itemCatName;
	private String customerName;
	private String outUserName;
	private Integer num;
	private String brand;
	private String name;
	private Timestamp createdatetime;
	private Timestamp modifydatetime;

	// Constructors

	/** default constructor */
	public OutItem() {
	}

	public OutItem(String id, String outStoreName, String itemCatName, String customerName, String outUserName,
			Integer num, String brand, String name, Timestamp createdatetime, Timestamp modifydatetime) {
		super();
		this.id = id;
		this.outStoreName = outStoreName;
		this.itemCatName = itemCatName;
		this.customerName = customerName;
		this.outUserName = outUserName;
		this.num = num;
		this.brand = brand;
		this.name = name;
		this.createdatetime = createdatetime;
		this.modifydatetime = modifydatetime;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOutStoreName() {
		return outStoreName;
	}

	public void setOutStoreName(String outStoreName) {
		this.outStoreName = outStoreName;
	}

	public String getItemCatName() {
		return itemCatName;
	}

	public void setItemCatName(String itemCatName) {
		this.itemCatName = itemCatName;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getOutUserName() {
		return outUserName;
	}

	public void setOutUserName(String outUserName) {
		this.outUserName = outUserName;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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