package com.storehouse.pojo;

import java.sql.Timestamp;

/**
 * Customers entity. @author MyEclipse Persistence Tools
 */

public class Customers implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer intercourseTypeId;
	private String code;
	private String name;
	private String remark;
	private String address;
	private String postcode;
	private String phone;
	private String fax;
	private String www;
	private String email;
	private String answerMan;
	private String contactMan;
	private String licence;
	private String bank;
	private String taxCode;
	private String account;
	private String help;
	private Double recvCost;
	private Double payCost;
	private Timestamp createdatetime;
	private Timestamp modifydatetime;

	// Constructors

	/** default constructor */
	public Customers() {
	}

	/** full constructor */
	public Customers(Integer intercourseTypeId, String code, String name,
			String remark, String address, String postcode, String phone,
			String fax, String www, String email, String answerMan,
			String contactMan, String licence, String bank, String taxCode,
			String account, String help, Double recvCost, Double payCost,
			Timestamp createdatetime, Timestamp modifydatetime) {
		this.intercourseTypeId = intercourseTypeId;
		this.code = code;
		this.name = name;
		this.remark = remark;
		this.address = address;
		this.postcode = postcode;
		this.phone = phone;
		this.fax = fax;
		this.www = www;
		this.email = email;
		this.answerMan = answerMan;
		this.contactMan = contactMan;
		this.licence = licence;
		this.bank = bank;
		this.taxCode = taxCode;
		this.account = account;
		this.help = help;
		this.recvCost = recvCost;
		this.payCost = payCost;
		this.createdatetime = createdatetime;
		this.modifydatetime = modifydatetime;
	}

	// Property accessors

	

	public Integer getIntercourseTypeId() {
		return this.intercourseTypeId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setIntercourseTypeId(Integer intercourseTypeId) {
		this.intercourseTypeId = intercourseTypeId;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPostcode() {
		return this.postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getFax() {
		return this.fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getWww() {
		return this.www;
	}

	public void setWww(String www) {
		this.www = www;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAnswerMan() {
		return this.answerMan;
	}

	public void setAnswerMan(String answerMan) {
		this.answerMan = answerMan;
	}

	public String getContactMan() {
		return this.contactMan;
	}

	public void setContactMan(String contactMan) {
		this.contactMan = contactMan;
	}

	public String getLicence() {
		return this.licence;
	}

	public void setLicence(String licence) {
		this.licence = licence;
	}

	public String getBank() {
		return this.bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public String getTaxCode() {
		return this.taxCode;
	}

	public void setTaxCode(String taxCode) {
		this.taxCode = taxCode;
	}

	public String getAccount() {
		return this.account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getHelp() {
		return this.help;
	}

	public void setHelp(String help) {
		this.help = help;
	}

	public Double getRecvCost() {
		return this.recvCost;
	}

	public void setRecvCost(Double recvCost) {
		this.recvCost = recvCost;
	}

	public Double getPayCost() {
		return this.payCost;
	}

	public void setPayCost(Double payCost) {
		this.payCost = payCost;
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