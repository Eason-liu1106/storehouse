package com.storehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.storehouse.common.pojo.StorehouseResult;
import com.storehouse.pojo.ItemParam;
import com.storehouse.service.ItemParamService;

/**
 * 商品规格参数模板管理Controller
 * <p>Title: ItemParamController</p>
 * <p>Description: </p>
 * <p>Company: www.itcast.com</p> 
 * @author	入云龙
 * @date	2015年9月5日下午2:40:46
 * @version 1.0
 */
@Controller
@RequestMapping("/item/param")
public class ItemParamController {

	@Autowired
	private ItemParamService itemParamService;
	
	@RequestMapping("/query/itemcatid")
	@ResponseBody
	public StorehouseResult getItemParamByCid( Long itemCatId) {
		StorehouseResult result = itemParamService.getItemParamByCid(itemCatId);
		return result;
	}
	
	@RequestMapping("/save")
	@ResponseBody
	public StorehouseResult insertItemParam( Long cid, String paramData) {
		//创建pojo对象
		ItemParam itemParam = new ItemParam();
		itemParam.setItemCatId(cid);
		itemParam.setParamData(paramData);
		StorehouseResult result = itemParamService.insertItemParam(itemParam);
		return result;
	}
}
