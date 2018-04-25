package com.storehouse.pojo;

/**
 * SysRolePermission entity. @author MyEclipse Persistence Tools
 */

public class SysRolePermission implements java.io.Serializable {

	// Fields

	private String id;
	private String sysRoleId;
	private String sysPermissionId;

	// Constructors

	/** default constructor */
	public SysRolePermission() {
	}

	/** full constructor */
	public SysRolePermission(String id, String sysRoleId, String sysPermissionId) {
		this.id = id;
		this.sysRoleId = sysRoleId;
		this.sysPermissionId = sysPermissionId;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSysRoleId() {
		return this.sysRoleId;
	}

	public void setSysRoleId(String sysRoleId) {
		this.sysRoleId = sysRoleId;
	}

	public String getSysPermissionId() {
		return this.sysPermissionId;
	}

	public void setSysPermissionId(String sysPermissionId) {
		this.sysPermissionId = sysPermissionId;
	}

}