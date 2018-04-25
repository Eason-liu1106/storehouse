package com.storehouse.pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * SysRole entity. @author MyEclipse Persistence Tools
 */

public class SysRole implements java.io.Serializable {

	// Fields

	private String id;
	private String name;
	private String available;
	private Set<SysPermission> syspermissions=new HashSet();  ;
	private Set<SysUser> sysusers=new HashSet();  ;
	// Constructors

	/** default constructor */
	public SysRole() {
	}

	/** minimal constructor */
	public SysRole(String id, String name) {
		this.id = id;
		this.name = name;
	}

	/** full constructor */
	public SysRole(String id, String name, String available) {
		this.id = id;
		this.name = name;
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

	public String getAvailable() {
		return this.available;
	}

	public void setAvailable(String available) {
		this.available = available;
	}

	public Set<SysPermission> getSyspermissions() {
		return syspermissions;
	}

	public void setSyspermissions(Set<SysPermission> syspermissions) {
		this.syspermissions = syspermissions;
	}

	public Set<SysUser> getSysusers() {
		return sysusers;
	}

	public void setSysusers(Set<SysUser> sysusers) {
		this.sysusers = sysusers;
	}

}