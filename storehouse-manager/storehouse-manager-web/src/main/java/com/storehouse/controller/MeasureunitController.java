package com.storehouse.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.storehouse.common.pojo.EUDataGridResult;
import com.storehouse.common.pojo.StorehouseResult;
import com.storehouse.model.BaseModel;

import com.storehouse.pojo.Measureunits;
import com.storehouse.service.MeasureunitService;



@Controller
public class MeasureunitController {
	@Autowired
	private MeasureunitService measureunitService;
	
	
	@RequestMapping("/measureunitManager/list")
	public String measureunitManager(){
		
		return "measureunitManager";
	}
	@RequestMapping("/measureunitManager/add")
	public String addMeasureunitManager(){
		
		return "addMeasureunit";
	}
	@RequestMapping("/measureunitManager/edit")
	public String editMeasureunitManager(){
		
		return "editMeasureunit";
	}

	@RequestMapping("/measureunit/list")
	@ResponseBody
	public EUDataGridResult  getMeasureunitList(BaseModel bm){	
		return measureunitService.getMeasureunitList( bm);
		
	}
	@RequestMapping("/measureunit/add")
	@ResponseBody
	public StorehouseResult  addMeasureunit(Measureunits ms){
		
		return measureunitService.addMeasureunit(ms);
		
	}
	@RequestMapping("/measureunit/edit")
	@ResponseBody
	public StorehouseResult  editMeasureunit(Measureunits ms){
	
		return measureunitService.update(ms);
		
	}
	@RequestMapping("/measureunit/delete")
	@ResponseBody
	public StorehouseResult  deleteStore(String  ids){
		
		return measureunitService.delete(ids);
		
	}

}
