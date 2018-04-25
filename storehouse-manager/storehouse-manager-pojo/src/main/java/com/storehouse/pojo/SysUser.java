package com.storehouse.pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * SysUser entity. @author MyEclipse Persistence Tools
 */

public class SysUser implements java.io.Serializable {

	// Fields

	private String id;
	private String usercode;
	private String username;
	private String password;
	private String salt;
	private String locked;
	private String name;
	private Set<SysRole> sysroles=new HashSet();  ;
	// Constructors

	
	

	/** default constructor */
	public SysUser() {
	}

	/** minimal constructor */
	public SysUser(String id, String usercode, String username, String password) {
		this.id = id;
		this.usercode = usercode;
		this.username = username;
		this.password = password;
	}

	/** full constructor */
	public SysUser(String id, String usercode, String username,
			String password, String salt, String locked) {
		this.id = id;
		this.usercode = usercode;
		this.username = username;
		this.password = password;
		this.salt = salt;
		this.locked = locked;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsercode() {
		return this.usercode;
	}

	public void setUsercode(String usercode) {
		this.usercode = usercode;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return this.salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getLocked() {
		return this.locked;
	}

	public void setLocked(String locked) {
		this.locked = locked;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<SysRole> getSysroles() {
		return sysroles;
	}

	public void setSysroles(Set<SysRole> sysroles) {
		this.sysroles = sysroles;
	}

}