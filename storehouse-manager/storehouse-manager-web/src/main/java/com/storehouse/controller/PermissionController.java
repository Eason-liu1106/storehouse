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
import com.storehouse.pojo.SysPermission;
import com.storehouse.service.PermissionService;
import com.storehouse.service.UserService;



@Controller

public class PermissionController {
	@Autowired	
	PermissionService permissionService;
	
	@RequestMapping("/permission/list")
	@ResponseBody
	public  EUDataGridResult getPermissionList(BaseModel bm){
		
		return permissionService.getPermissions(bm);
	}
	@RequestMapping("/permissionManager/list")
	public String userManager(){
		
		return "permissionManager";
	}
	@RequestMapping("/permission/tree")
	@ResponseBody
	public  List<PermssionTreeModel> getPermissionTree(String id){
		
		return permissionService.getPermissionTree(id);
	}
	@RequestMapping("/permission/add")
	@ResponseBody
	public  StorehouseResult addPermission(SysPermission permission){
		
		return permissionService.addPermission(permission);
	}
	@RequestMapping("/permission/edit")
	@ResponseBody
	public  StorehouseResult editPermission(SysPermission permission){
		
		return permissionService.update(permission);
	}
	@RequestMapping("/permission/delete")
	@ResponseBody
	public  StorehouseResult deletePermission(String id){
		
		return permissionService.delete(id);
	}
	
}
