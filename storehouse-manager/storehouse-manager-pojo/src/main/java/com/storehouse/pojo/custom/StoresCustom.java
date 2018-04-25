package com.storehouse.pojo.custom;

import java.sql.Timestamp;





public class StoresCustom implements java.io.Serializable {
	private String id;
	private String storeTypeName;
	private String rackName;
	private String calculateName;
	private String storeTypeId;
	private String rackId;
	private String calculateId;
	private String name;
	private String description;
	private Timestamp createdatetime;
	private Timestamp modifydatetime;
	private String stock;
	private String bigstock;
	private String smallstock;
	private Integer iffull;
	private Integer remainStock;
	
	
	public Integer getRemainStock() {
		return remainStock;
	}
	public void setRemainStock(Integer remainStock) {
		this.remainStock = remainStock;
	}
	public String getStoreTypeName() {
		return storeTypeName;
	}
	public void setStoreTypeName(String storeTypeName) {
		this.storeTypeName = storeTypeName;
	}
	public String getRackName() {
		return rackName;
	}
	public void setRackName(String rackName) {
		this.rackName = rackName;
	}
	public String getCalculateName() {
		return calculateName;
	}
	public void setCalculateName(String calculateName) {
		this.calculateName = calculateName;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
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
	public String getStock() {
		return stock;
	}
	public void setStock(String stock) {
		this.stock = stock;
	}
	public String getBigstock() {
		return bigstock;
	}
	public void setBigstock(String bigstock) {
		this.bigstock = bigstock;
	}
	public String getSmallstock() {
		return smallstock;
	}
	public void setSmallstock(String smallstock) {
		this.smallstock = smallstock;
	}
	public Integer getIffull() {
		return iffull;
	}
	public void setIffull(Integer iffull) {
		this.iffull = iffull;
	}
	public String getStoreTypeId() {
		return storeTypeId;
	}
	public void setStoreTypeId(String storeTypeId) {
		this.storeTypeId = storeTypeId;
	}
	public String getRackId() {
		return rackId;
	}
	public void setRackId(String rackId) {
		this.rackId = rackId;
	}
	public String getCalculateId() {
		return calculateId;
	}
	public void setCalculateId(String calculateId) {
		this.calculateId = calculateId;
	}

}
