package com.storehouse.pojo.custom;

import java.io.Serializable;
import java.util.List;

import com.storehouse.pojo.SysPermission;



public class ActiveUser implements Serializable {

	private String userid;
	private String usercode;
	private String username;// ç”¨æˆ·å��ç§°

	private List<SysPermission> menus;
	private List<SysPermission> permissions;
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUsercode() {
		return usercode;
	}
	public void setUsercode(String usercode) {
		this.usercode = usercode;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public List<SysPermission> getMenus() {
		return menus;
	}
	public void setMenus(List<SysPermission> menus) {
		this.menus = menus;
	}
	public List<SysPermission> getPermissions() {
		return permissions;
	}
	public void setPermissions(List<SysPermission> permissions) {
		this.permissions = permissions;
	}
	
}
