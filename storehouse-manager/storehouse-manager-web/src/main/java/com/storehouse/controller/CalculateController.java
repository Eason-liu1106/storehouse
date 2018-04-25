package com.storehouse.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.storehouse.common.pojo.EUDataGridResult;
import com.storehouse.common.pojo.StorehouseResult;
import com.storehouse.model.BaseModel;
import com.storehouse.model.CalculateModel;

import com.storehouse.service.CalculateService;



@Controller
public class CalculateController {
	@Autowired
	private CalculateService calculateService;
	
	@RequestMapping("/calculateManager/list")
	public String calculateManager(){
		
		return "calculateManager";
	}
	@RequestMapping("/calculateManager/add")
	public String addCalculateManager(){
		
		return "addCalculate";
	}
	@RequestMapping("/calculateManager/edit")
	public String editCalculateManager(){
		
		return "editCalculate";
	}
	@RequestMapping("/calculate/list")
	@ResponseBody
	public EUDataGridResult  getCalculateList(BaseModel bm){	
		return calculateService.getCalculateList( bm);
		
	}
	@RequestMapping("/calculate/add")
	@ResponseBody
	public StorehouseResult  addCalculate(CalculateModel cm){
		System.out.println("1"+cm.getMon());
		return calculateService.addCalculate(cm);
		
	}
	@RequestMapping("/calculate/edit")
	@ResponseBody
	public StorehouseResult  editCalculate(CalculateModel cm){
	
		return calculateService.update(cm);
		
	}
	@RequestMapping("/calculate/delete")
	@ResponseBody
	public StorehouseResult  deleteCalculate(String  ids){
		
		return calculateService.delete(ids);
		
	}

}
