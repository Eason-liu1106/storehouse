package com.storehouse.controller;



import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.storehouse.common.pojo.EUDataGridResult;
import com.storehouse.common.pojo.StorehouseResult;
import com.storehouse.model.BaseModel;

import com.storehouse.model.OutItemModel;
import com.storehouse.pojo.custom.ActiveUser;
import com.storehouse.service.OutItemService;

@Controller
public class OutItemController {

	@Autowired
	private OutItemService outItemService;
	
	
	@RequestMapping("/outItemManager/list")
	public String outItemManager(){
		
		return "outItemManager";
	}
	@RequestMapping("/outItemManager/add")
	public String addOutItemManager(){
		
		return "addOutItem";
	}
	@RequestMapping("/outItemManager/edit")
	public String editOutItemManager(){
		
		return "editOutItem";
	}
	@RequestMapping("/outItemManager/moveoutItem")
	public String moveoutItemManager(){
		
		return "moveoutItem";
	}
	@RequestMapping("/outItemManager/detailOutItem")
	public String detailOutItemManager(){
		
		return "detailOutItem";
	}
	@RequestMapping("/outItem/list")
	@ResponseBody
	public EUDataGridResult getoutItemList(BaseModel bm) {
		EUDataGridResult result = outItemService.getOutItemList(bm);
		return result;
	}

	@RequestMapping(value="/outItem/add", method=RequestMethod.POST)
	@ResponseBody
	private StorehouseResult addoutItem( OutItemModel outItemModel,HttpSession session) throws Exception {
		ActiveUser activeUser=(ActiveUser) session.getAttribute("activeUser");
		StorehouseResult storeResult = outItemService.addOutItem(outItemModel,activeUser);
		System.out.println("出库结果："+storeResult.getMsg());
		return storeResult;
		
	}
	
}
