package com.storehouse.pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * SysPermission entity. @author MyEclipse Persistence Tools
 */

public class SysPermission implements java.io.Serializable {

	// Fields

	private String id;
	private String name;
	private String type;
	private String url;
	private String percode;
	private String parentid;
	private String parentids;
	private String sortstring;
	private String available;
	private Set<SysRole> sysroles=new HashSet();  ;

	// Constructors

	/** default constructor */
	public SysPermission() {
	}

	/** minimal constructor */
	public SysPermission(String id, String name, String type) {
		this.id = id;
		this.name = name;
		this.type = type;
	}

	/** full constructor */
	public SysPermission(String id, String name, String type, String url,
			String percode, String parentid, String parentids, String sortstring,
			String available) {
		this.id = id;
		this.name = name;
		this.type = type;
		this.url = url;
		this.percode = percode;
		this.parentid = parentid;
		this.parentids = parentids;
		this.sortstring = sortstring;
		this.available = available;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPercode() {
		return this.percode;
	}

	public void setPercode(String percode) {
		this.percode = percode;
	}

	public String getParentid() {
		return this.parentid;
	}

	public void setParentid(String parentid) {
		this.parentid = parentid;
	}

	public String getParentids() {
		return this.parentids;
	}

	public void setParentids(String parentids) {
		this.parentids = parentids;
	}

	public String getSortstring() {
		return this.sortstring;
	}

	public void setSortstring(String sortstring) {
		this.sortstring = sortstring;
	}

	public String getAvailable() {
		return this.available;
	}

	public void setAvailable(String available) {
		this.available = available;
	}

	public Set<SysRole> getSysroles() {
		return sysroles;
	}

	public void setSysroles(Set<SysRole> sysroles) {
		this.sysroles = sysroles;
	}

}