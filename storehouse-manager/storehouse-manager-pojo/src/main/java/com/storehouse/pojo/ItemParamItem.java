package com.storehouse.pojo;

import java.sql.Timestamp;

/**
 * ItemParamItem entity. @author MyEclipse Persistence Tools
 */

public class ItemParamItem implements java.io.Serializable {

	// Fields

	private String id;
	private String itemId;
	private String paramData;
	private Timestamp createdatetime;
	private Timestamp modifydatetime;

	// Constructors

	/** default constructor */
	public ItemParamItem() {
	}

	/** minimal constructor */
	public ItemParamItem(String id) {
		this.id = id;
	}

	/** full constructor */
	public ItemParamItem(String id, String itemId, String paramData,
			Timestamp createdatetime, Timestamp modifydatetime) {
		this.id = id;
		this.itemId = itemId;
		this.paramData = paramData;
		this.createdatetime = createdatetime;
		this.modifydatetime = modifydatetime;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getItemId() {
		return this.itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getParamData() {
		return this.paramData;
	}

	public void setParamData(String paramData) {
		this.paramData = paramData;
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