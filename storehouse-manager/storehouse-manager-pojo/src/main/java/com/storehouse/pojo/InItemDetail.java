package com.storehouse.pojo;

import java.sql.Timestamp;

/**
 * InItemDetail entity. @author MyEclipse Persistence Tools
 */

public class InItemDetail implements java.io.Serializable {

	// Fields

	private String id;
	private InItem inItem;
	private InItem parentInItem;
	private Stores moveStore;
	private ItemCat itemCat;
	private Suppliers suppliers;
	private Rack rack;
	private Calculate calculate;
	private ItemParamItem itemParamItem;
	private Measureunits measureunits;
	private Stores stores;
	private String time;
	private String bulk;
	private String description;
	private String money;
	private Integer status;
	private Integer warn;
	private String position;
	private String pay;
	private Integer flag;
	private Integer checknumber;
	private Integer actualnumber;
	private Timestamp createdatetime;
	private Timestamp modifydatetime;
	private String inUserId;
	private String brand;
	private Integer rental;
	// Constructors

	/** default constructor */
	public InItemDetail() {
	}

	

	public Integer getRental() {
		return rental;
	}



	public void setRental(Integer rental) {
		this.rental = rental;
	}



	/** minimal constructor */
	public InItemDetail(String id, InItem inItem, ItemCat itemCat,
			Suppliers suppliers, ItemParamItem itemParamItem, Stores stores,
			String time, String bulk, String money, String position,
			String inUserId,int rental) {
		this.id = id;
		this.inItem = inItem;
		this.itemCat = itemCat;
		this.suppliers = suppliers;
		this.itemParamItem = itemParamItem;
		this.stores = stores;
		this.time = time;
		this.bulk = bulk;
		this.money = money;
		this.position = position;
		this.inUserId = inUserId;
		this.rental=rental;
	}

	/** full constructor */
	public InItemDetail(String id, InItem inItem, ItemCat itemCat, Suppliers suppliers, Rack rack, Calculate calculate,
			ItemParamItem itemParamItem, Measureunits measureunits, Stores stores, String time, String bulk,
			String description, String money, Integer status, Integer warn, String position, String pay, Integer flag,
			Integer checknumber, Integer actualnumber, Timestamp createdatetime, Timestamp modifydatetime,
			String inUserId, String brand,int rental) {
		super();
		this.id = id;
		this.inItem = inItem;
		this.itemCat = itemCat;
		this.suppliers = suppliers;
		this.rack = rack;
		this.calculate = calculate;
		this.itemParamItem = itemParamItem;
		this.measureunits = measureunits;
		this.stores = stores;
		this.time = time;
		this.bulk = bulk;
		this.description = description;
		this.money = money;
		this.status = status;
		this.warn = warn;
		this.position = position;
		this.pay = pay;
		this.flag = flag;
		this.checknumber = checknumber;
		this.actualnumber = actualnumber;
		this.createdatetime = createdatetime;
		this.modifydatetime = modifydatetime;
		this.inUserId = inUserId;
		this.brand = brand;
		this.rental=rental;
	}

	


	


	// Property accessors

	public InItem getParentInItem() {
		return parentInItem;
	}

	public void setParentInItem(InItem parentInItem) {
		this.parentInItem = parentInItem;
	}

	public Stores getMoveStore() {
		return moveStore;
	}

	public void setMoveStore(Stores moveStore) {
		this.moveStore = moveStore;
	}

	public String getId() {
		return this.id;
	}
	public void setId(String id) {
		this.id = id;
	}
	

	
	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Integer getChecknumber() {
		return checknumber;
	}

	public void setChecknumber(Integer checknumber) {
		this.checknumber = checknumber;
	}

	public Integer getActualnumber() {
		return actualnumber;
	}

	public void setActualnumber(Integer actualnumber) {
		this.actualnumber = actualnumber;
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

	public Suppliers getSuppliers() {
		return this.suppliers;
	}

	public void setSuppliers(Suppliers suppliers) {
		this.suppliers = suppliers;
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

	public ItemParamItem getItemParamItem() {
		return this.itemParamItem;
	}

	public void setItemParamItem(ItemParamItem itemParamItem) {
		this.itemParamItem = itemParamItem;
	}

	public Measureunits getMeasureunits() {
		return this.measureunits;
	}

	public void setMeasureunits(Measureunits measureunits) {
		this.measureunits = measureunits;
	}

	public Stores getStores() {
		return this.stores;
	}

	public void setStores(Stores stores) {
		this.stores = stores;
	}

	public String getTime() {
		return this.time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getBulk() {
		return this.bulk;
	}

	public void setBulk(String bulk) {
		this.bulk = bulk;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMoney() {
		return this.money;
	}

	public void setMoney(String money) {
		this.money = money;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getWarn() {
		return this.warn;
	}

	public void setWarn(Integer warn) {
		this.warn = warn;
	}

	public String getPosition() {
		return this.position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getPay() {
		return this.pay;
	}

	public void setPay(String pay) {
		this.pay = pay;
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

	public String getInUserId() {
		return this.inUserId;
	}

	public void setInUserId(String inUserId) {
		this.inUserId = inUserId;
	}

}