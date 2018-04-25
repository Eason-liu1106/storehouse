package com.storehouse.controller;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.storehouse.common.pojo.EUDataGridResult;
import com.storehouse.common.pojo.StorehouseResult;
import com.storehouse.model.Auth;
import com.storehouse.model.BaseModel;
import com.storehouse.model.PermssionTreeModel;
import com.storehouse.model.RoleModel;
import com.storehouse.pojo.SysRole;
import com.storehouse.service.RoleService;
import com.storehouse.service.UserService;



@Controller

public class RoleController {
	@Autowired	
	RoleService roleService;
	
	@RequestMapping("/role/list")
	@ResponseBody
	public  EUDataGridResult getRoleList(BaseModel bm){
		
		return roleService.getRoles(bm);
	}
	@RequestMapping("/roleManager/list")
	public String userManager(){
		
		return "roleManager";
	}
	@RequestMapping("/roleManager/add")
	public String addUserManager(){
		
		return "addRole";
	}
	@RequestMapping("/roleManager/edit")
	public String editUserManager(){
		
		return "editRole";
	}
	@RequestMapping("/role/tree")
	@ResponseBody
	public  List<PermssionTreeModel> getRoleTree(String id){
		
		return roleService.getRoleTree(id);
	}
	@RequestMapping("/role/add")
	@ResponseBody
	public  StorehouseResult addRole(RoleModel rolemodel){
		
		return roleService.addRole(rolemodel);
	}
	@RequestMapping("/role/edit")
	@ResponseBody
	public  StorehouseResult editRole(RoleModel rolemodel){
		
		return roleService.update(rolemodel);
	}
	@RequestMapping("/role/delete")
	@ResponseBody
	public  StorehouseResult deleteRole(String ids){
		
		return roleService.delete(ids);
	}
	
}
