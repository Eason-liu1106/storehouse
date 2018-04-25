package com.storehouse.pojo;

import java.sql.Timestamp;

/**
 * OutItemDetail entity. @author MyEclipse Persistence Tools
 */

public class OutItemDetail implements java.io.Serializable {

	// Fields

	private String id;
	private InItem inItem;
	private ItemCat itemCat;
	private Stores stores;
	private OutItem outItem;
	private Customers customer;
	private String description;
	private Integer flag;
	private Timestamp createdatetime;
	private Timestamp modifydatetime;
	
	private String outUserId;

	// Constructors

	/** default constructor */
	public OutItemDetail() {
	}

	/** minimal constructor */

	/** full constructor */
	public OutItemDetail(String id, InItem inItem, ItemCat itemCat, Stores stores, OutItem outItem, Customers customer,
			String description, Integer flag, Timestamp createdatetime, Timestamp modifydatetime, String outUserId) {
		super();
		this.id = id;
		this.inItem = inItem;
		this.itemCat = itemCat;
		this.stores = stores;
		this.outItem = outItem;
		this.customer = customer;
		this.description = description;
		this.flag = flag;
		this.createdatetime = createdatetime;
		this.modifydatetime = modifydatetime;
		this.outUserId = outUserId;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	

	public OutItem getOutItem() {
		return outItem;
	}

	public void setOutItem(OutItem outItem) {
		this.outItem = outItem;
	}

	public Customers getCustomer() {
		return customer;
	}

	public void setCustomer(Customers customer) {
		this.customer = customer;
	}

	public void setId(String id) {
		this.id = id;
	}

	public InItem getInItem() {
		return this.inItem;
	}

	public void setInItem(InItem inItem) {
		this.inItem = inItem;
	}

	public ItemCat getItemCat() {
		return this.itemCat;
	}

	public void setItemCat(ItemCat itemCat) {
		this.itemCat = itemCat;
	}

	public Stores getStores() {
		return this.stores;
	}

	public void setStores(Stores stores) {
		this.stores = stores;
	}

	

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getFlag() {
		return this.flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
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

	public String getOutUserId() {
		return this.outUserId;
	}

	public void setOutUserId(String outUserId) {
		this.outUserId = outUserId;
	}

}