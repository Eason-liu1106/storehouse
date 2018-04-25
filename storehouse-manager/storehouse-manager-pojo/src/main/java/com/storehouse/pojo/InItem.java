package com.storehouse.pojo;

import java.sql.Timestamp;

/**
 * InItem entity. @author MyEclipse Persistence Tools
 */

public class InItem implements java.io.Serializable {

	// Fields

	private String id;
	private String name;
	private String storeName;
	private String itemCatName;
	private String supplierName;
	private String inUserName;
	private Integer num;
	private String brand;
	private Integer rental;
	private Timestamp createdatetime;
	private Timestamp modifydatetime;

	// Constructors
	
	/** default constructor */
	public InItem() {
	}

	public Integer getRental() {
		return rental;
	}

	public void setRental(Integer rental) {
		this.rental = rental;
	}

	/** minimal constructor */
	public InItem(String id, String storeName, String itemCatName,
			String supplierName, String inUserName, Integer num,Integer rental) {
		this.id = id;
		this.storeName = storeName;
		this.itemCatName = itemCatName;
		this.supplierName = supplierName;
		this.inUserName = inUserName;
		this.num = num;
		this.rental=rental;
	}

	/** full constructor */
	public InItem(String id, String name, String storeName, String itemCatName, String supplierName, String inUserName,
			Integer num, String brand,Integer rental, Timestamp createdatetime, Timestamp modifydatetime) {
		super();
		this.id = id;
		this.name = name;
		this.storeName = storeName;
		this.itemCatName = itemCatName;
		this.supplierName = supplierName;
		this.inUserName = inUserName;
		this.num = num;
		this.brand = brand;
		this.rental=rental;
		this.createdatetime = createdatetime;
		this.modifydatetime = modifydatetime;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStoreName() {
		return this.storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getItemCatName() {
		return this.itemCatName;
	}

	public void setItemCatName(String itemCatName) {
		this.itemCatName = itemCatName;
	}

	public String getSupplierName() {
		return this.supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public String getInUserName() {
		return this.inUserName;
	}

	public void setInUserName(String inUserName) {
		this.inUserName = inUserName;
	}

	public Integer getNum() {
		return this.num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public String getBrand() {
		return this.brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
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