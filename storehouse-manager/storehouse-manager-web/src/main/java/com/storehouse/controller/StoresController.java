package com.storehouse.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.storehouse.common.pojo.EUDataGridResult;
import com.storehouse.common.pojo.StorehouseResult;
import com.storehouse.model.StoreModel;
import com.storehouse.service.StoresService;


@Controller
public class StoresController {
	@Autowired
	private StoresService storesService;
	@RequestMapping("/storeManager/list")
	public String storeManager(){
		
		return "storeManager";
	}
	@RequestMapping("/storeManager/add")
	public String addStoreManager(){
		
		return "addStore";
	}
	@RequestMapping("/storeManager/edit")
	public String editStoreManager(){
		
		return "editStore";
	}
	@RequestMapping("/store/list")
	@ResponseBody
	public EUDataGridResult  getStoresList(StoreModel sm){
		return storesService.getStoresList(sm);
		
	}
	@RequestMapping("/store/add")
	@ResponseBody
	public StorehouseResult  addStore(StoreModel sm){
		
		return storesService.addStore(sm);
		
	}
	@RequestMapping("/store/edit")
	@ResponseBody
	public StorehouseResult  editStore(StoreModel sm){
		
		return storesService.update(sm);
		
	}
	@RequestMapping("/store/delete")
	@ResponseBody
	public StorehouseResult  deleteStore(String  ids){
		
		return storesService.delete(ids);
		
	}


}
