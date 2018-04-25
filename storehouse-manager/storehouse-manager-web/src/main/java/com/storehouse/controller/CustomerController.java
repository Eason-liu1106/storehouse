package com.storehouse.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.storehouse.common.pojo.EUDataGridResult;
import com.storehouse.common.pojo.StorehouseResult;
import com.storehouse.model.BaseModel;

import com.storehouse.pojo.Customers;

import com.storehouse.service.CustomerService;



@Controller
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	@RequestMapping("/customerManager/list")
	public String customerManager(){
		
		return "customerManager";
	}
	@RequestMapping("/customerManager/add")
	public String addCustomerManager(){
		
		return "addCustomer";
	}
	@RequestMapping("/customerManager/edit")
	public String editCustomerManager(){
		
		return "editCustomer";
	}
	@RequestMapping("/customer/list")
	@ResponseBody
	public EUDataGridResult  getCustomerList(BaseModel bm){	
		return customerService.getCustomerList(bm);
		
	}
	@RequestMapping("/customer/add")
	@ResponseBody
	public StorehouseResult  addCustomer(Customers customers){
		
		return customerService.addCustomer(customers);
		
	}
	@RequestMapping("/customer/edit")
	@ResponseBody
	public StorehouseResult editCustomer(Customers customers){
	
		return  customerService.update(customers);
		
	}
	@RequestMapping("/customer/delete")
	@ResponseBody
	public StorehouseResult  deleteStore(String  ids){
		
		return customerService.delete(ids);
		
	}

}
