package com.storehouse.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.storehouse.common.pojo.EUDataGridResult;
import com.storehouse.common.pojo.StorehouseResult;
import com.storehouse.model.BaseModel;
import com.storehouse.model.StoreTypeModel;
import com.storehouse.service.CalculateService;
import com.storehouse.service.StoreTypeService;
import com.storehouse.service.StoreTypeService;



@Controller
public class StoreTypeController {
	@Autowired
	private StoreTypeService storeTypeService;
	
	@RequestMapping("/storeTypeManager/list")
	public String storeTypeManager(){
		    
		return "storeTypeManager";
	}
	@RequestMapping("/storeTypeManager/add")
	public String addStoreTypeManager(){
		
		return "addStoreType";
	}
	@RequestMapping("/storeTypeManager/edit")
	public String editStoreTypeManager(){
		
		return "editStoreType";
	}
	
	
	@RequestMapping("/storeType/list")
	@ResponseBody
	public EUDataGridResult  getStoreTypeList(BaseModel bm){
		
	
		
		
			return storeTypeService.getStoreTypeList(bm);
		
	}
	@RequestMapping("/storeType/add")
	@ResponseBody
	public StorehouseResult  addStoreType(StoreTypeModel stm){
		
		return storeTypeService.addStoreType(stm);
		
	}
	@RequestMapping("/storeType/edit")
	@ResponseBody
	public StorehouseResult  editStoreType(StoreTypeModel stm){
	
		return storeTypeService.update(stm);
		
	}
	@RequestMapping("/storeType/delete")
	@ResponseBody
	public StorehouseResult  deleteStoreType(String  ids){
		
		return storeTypeService.delete(ids);
		
	}

}
