package com.storehouse.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.storehouse.common.pojo.EUDataGridResult;
import com.storehouse.common.pojo.StorehouseResult;
import com.storehouse.model.BaseModel;

import com.storehouse.pojo.Suppliers;
import com.storehouse.service.SupplierService;




@Controller
public class SupplierController {
	@Autowired
	private SupplierService supplierService;
	
	@RequestMapping("/supplierManager/list")
	public String supplierManager(){
		    
		return "supplierManager";
	}
	@RequestMapping("/supplierManager/add")
	public String addSupplierManager(){
		
		return "addSupplier";
	}
	@RequestMapping("/supplierManager/edit")
	public String editSupplierManager(){
		
		return "editSupplier";
	}
	
	@RequestMapping("/supplier/list")
	@ResponseBody
	public EUDataGridResult  getSupplierList(BaseModel bm){	
		return supplierService.getSupplierList( bm);
		
	}
	@RequestMapping("/supplier/add")
	@ResponseBody
	public StorehouseResult  addSupplier(Suppliers suppliers){
		
		return supplierService.addSupplier(suppliers);
		
	}
	@RequestMapping("/supplier/edit")
	@ResponseBody
	public StorehouseResult  editStore(Suppliers suppliers){
	
		return  supplierService.update(suppliers);
		
	}
	@RequestMapping("/supplier/delete")
	@ResponseBody
	public StorehouseResult  deleteStore(String ids){
		
		return supplierService.delete(ids);
		
	}

}
