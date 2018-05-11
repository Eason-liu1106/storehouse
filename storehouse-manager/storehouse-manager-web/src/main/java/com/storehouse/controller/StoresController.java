package com.storehouse.controller;



import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.storehouse.common.pojo.EUDataGridResult;
import com.storehouse.common.pojo.StorehouseResult;
import com.storehouse.model.StoreModel;
import com.storehouse.pojo.Stores;
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
	@RequestMapping("/storeModel")
	@ResponseBody
	public StoreModel getStoreById(String id,HttpSession session){
		StoreModel storeModel=storesService.getStoreModelById(id);
		session.setAttribute("getStoreModelById", storeModel);
		return storeModel;
		
	}
	@RequestMapping("/store/edit")
	@ResponseBody
	public StorehouseResult  editStore(StoreModel sm,HttpSession session){
		StoreModel storeModel=(StoreModel) session.getAttribute("getStoreModelById");
		return storesService.update(sm,storeModel);
		
	}
	
	@RequestMapping("/store/delete")
	@ResponseBody
	public StorehouseResult  deleteStore(String  ids){
		
		return storesService.delete(ids);
		
	}


}
