package com.storehouse.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.storehouse.common.pojo.EUDataGridResult;
import com.storehouse.common.pojo.StorehouseResult;
import com.storehouse.model.BaseModel;
import com.storehouse.model.PermssionTreeModel;
import com.storehouse.model.UserModel;

import com.storehouse.service.UserService;



@Controller

public class UserController {
	@Autowired	
	UserService userService;
	@RequestMapping("/index")
	public String login(){
		
		return "home";
	}
	@RequestMapping("/user/list")
	@ResponseBody
	public  EUDataGridResult getUserList(BaseModel bm){
		
		return userService.getUsers(bm);
	}
	@RequestMapping("/userManager/list")
	public String UserManager(){
		
		return "userManager";
	}
	@RequestMapping("/userManager/add")
	public String addUserManager(){
		
		return "addUser";
	}
	@RequestMapping("/userManager/edit")
	public String editUserManager(){
		
		return "editUser";
	}
//	@RequestMapping("/user/tree")
//	@ResponseBody
//	public  List<PermssionTreeModel> getuserTree(String id){
//		
//		return userService.getuserTree(id);
//	}
	@RequestMapping("/user/add")
	@ResponseBody
	public  StorehouseResult addUser(UserModel usermodel,String password,String repassword){
		return userService.addUser(usermodel,password,repassword);
	}
	@RequestMapping("/user/edit")
	@ResponseBody
	public  StorehouseResult editUser(UserModel usermodel){
		
		return userService.update(usermodel);
	}
	@RequestMapping("/user/delete")
	@ResponseBody
	public  StorehouseResult deleteUser(String ids){
		
		return userService.delete(ids);
	}
	
}
