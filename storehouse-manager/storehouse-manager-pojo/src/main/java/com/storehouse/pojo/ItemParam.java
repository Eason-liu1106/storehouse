package com.storehouse.pojo;

import java.sql.Timestamp;

/**
 * ItemParam entity. @author MyEclipse Persistence Tools
 */

public class ItemParam implements java.io.Serializable {

	// Fields

	private Long id;
	private Long itemCatId;
	private String paramData;
	private Timestamp createdatetime;
	private Timestamp modifydatetime;

	// Constructors

	/** default constructor */
	public ItemParam() {
	}

	/** full constructor */
	public ItemParam(Long itemCatId, String paramData,
			Timestamp createdatetime, Timestamp modifydatetime) {
		this.itemCatId = itemCatId;
		this.paramData = paramData;
		this.createdatetime = createdatetime;
		this.modifydatetime = modifydatetime;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getItemCatId() {
		return this.itemCatId;
	}

	public void setItemCatId(Long itemCatId) {
		this.itemCatId = itemCatId;
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