package com.storehouse.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.storehouse.common.pojo.EUDataGridResult;
import com.storehouse.common.pojo.StorehouseResult;
import com.storehouse.model.BaseModel;
import com.storehouse.model.InItemDetailModel;
import com.storehouse.model.MoveIntemModel;
import com.storehouse.model.StoreModel;
import com.storehouse.pojo.InItem;
import com.storehouse.pojo.Stores;
import com.storehouse.pojo.custom.ActiveUser;
import com.storehouse.service.InItemService;
import com.storehouse.service.StoresService;
import com.storehouse.service.impl.StoresServiceImpl;

@Controller
public class InItemController {

	@Autowired
	private InItemService inItemService;
	@Autowired
	private StoresService storesService;
	
	@RequestMapping("/inItemManager/list")
	public String inItemManager(){
		
		return "inItemManager";
	}
	@RequestMapping("/inItemManager/add")
	public String addInItemManager(){
		
		return "addInItem";
	}
	@RequestMapping("/inItemManager/edit")
	public String editInItemManager(){
		return "editInItem";
	}
	@RequestMapping("/inItemManager/detail")
	public String detailInItemManager(){
		
		return "detailIntem";
	}
	@RequestMapping("/inItemManager/move")
	public String moveInItemManager(){
		
		return "moveInItem";
	}
	@RequestMapping("/inItem")
	@ResponseBody
	public InItem getInItemById( String itemId) {
		InItem inItem = inItemService.getInItemById(itemId);
		return inItem;
	}
	
	@RequestMapping("/inItem/list")
	@ResponseBody
	public EUDataGridResult getInItemList(BaseModel bm) {
		EUDataGridResult result = inItemService.getInItemList(bm);
		return result;
	}
	//数据库未做记录
	@RequestMapping("/inItemDetail")
	@ResponseBody
	public InItemDetailModel getInItemDetailById( String itemId,HttpSession session) {
		InItemDetailModel inItemDetailModel = inItemService.getInItemDetailById(itemId);
		session.setAttribute("getInItemDetailModel", inItemDetailModel);
		return inItemDetailModel;
	}
	//数据库未做记录
	@RequestMapping("/inItemDetail/list")
	@ResponseBody
	public EUDataGridResult getInItemDetailList(BaseModel bm) {
		EUDataGridResult result = inItemService.getInItemDetailList(bm);
		return result;
	}
	@RequestMapping("/inItem/delete")
	@ResponseBody
	public StorehouseResult deleteInItem(String  ids) {
		StorehouseResult result = inItemService.delete(ids);
		return result;
	}
	@RequestMapping("/inItem/edit")
	@ResponseBody
	public StorehouseResult editInItem(InItemDetailModel inItemDetailModel,InItem inItem, String itemParams) {
		StorehouseResult storehouseResult = inItemService.update(inItemDetailModel, inItem, itemParams);
		return storehouseResult;
	}
	@RequestMapping(value="/inItem/add", method=RequestMethod.POST)
	@ResponseBody
	private StorehouseResult addInItem( InItemDetailModel InItemDetailModel,InItem inItem, String itemParams,HttpSession session,String storeId,String time) throws Exception {
		System.out.println("add "+time);
		session.setAttribute("getTime", time);
		Stores stores=storesService.getStoreById(storeId);
		ActiveUser activeUser=(ActiveUser) session.getAttribute("activeUser");
		StorehouseResult storeResult = inItemService.addInItem(InItemDetailModel, inItem,itemParams,activeUser,stores,time);
		return storeResult;
	}
	@RequestMapping(value="/inItem/move", method=RequestMethod.POST)
	@ResponseBody
	private StorehouseResult moveInItem( MoveIntemModel moveInItemModel,HttpSession session) throws Exception {
		InItemDetailModel inItemDetailModel=(InItemDetailModel) session.getAttribute("getInItemDetailModel");
		ActiveUser activeUser=(ActiveUser) session.getAttribute("activeUser");
		StorehouseResult storeResult = inItemService.moveInItem(moveInItemModel,activeUser,inItemDetailModel);
		return storeResult;
	}
}
