package com.storehouse.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.storehouse.common.pojo.ComBoxResult;
import com.storehouse.common.pojo.EUDataGridResult;
import com.storehouse.common.pojo.StorehouseResult;
import com.storehouse.model.BaseModel;

import com.storehouse.model.RackModel;

import com.storehouse.service.RackService;



@Controller
public class RackController {
	@Autowired
	private RackService rackService;
	
	
	
	@RequestMapping("/rackManager/list")
	public String rackManager(){
		
		return "rackManager";
	}
	@RequestMapping("/rackManager/add")
	public String addRackManager(){
		
		return "addRack";
	}
	@RequestMapping("/rackManager/edit")
	public String editRackManager(){
		
		return "editRack";
	}
	@RequestMapping("/rack/list")
	@ResponseBody

	public EUDataGridResult  getRackList(BaseModel bm){
		
	
		return rackService.getRackList(bm);
		
	}
	@RequestMapping("/rack/add")
	@ResponseBody
	public StorehouseResult  addRack(RackModel rm){
		
		return rackService.addRack(rm);
		
	}
	@RequestMapping("/rack/edit")
	@ResponseBody
	public StorehouseResult  editRack(RackModel rm){
	
		return rackService.update(rm);
		
	}
	@RequestMapping("/rack/delete")
	@ResponseBody
	public StorehouseResult  deleteRack(String  ids){
		
		return rackService.delete(ids);
		
	}
	@RequestMapping("/rack/combox")
	@ResponseBody
	public List<ComBoxResult> getComBoxRack(String id){
	
		
		return  rackService.getComBoxRackList(id);
		
		
	}

}
