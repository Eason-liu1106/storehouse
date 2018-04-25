package com.storehouse.model;

public class MoveIntemModel {

	private String moveStoreId;
	private String storeId;
	private String description;
	private String id;
	private Integer movenum;	
	public String getStoreId() {
		return storeId;
	}
	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}
	public Integer getMovenum() {
		return movenum;
	}
	public void setMovenum(Integer movenum) {
		this.movenum = movenum;
	}
	public String getMoveStoreId() {
		return moveStoreId;
	}
	public void setMoveStoreId(String moveStoreId) {
		this.moveStoreId = moveStoreId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
}
