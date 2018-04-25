package com.storehouse.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.storehouse.common.pojo.EchartsResult;
import com.storehouse.model.StoreNames;
import com.storehouse.service.CalculateService;
import com.storehouse.service.EchartsService;



@Controller

public class EchartsController {
	
	@Autowired
	private EchartsService echartsService;

	@RequestMapping("/echarts/inEchart")
	public String inEchart(){
		return "inEchart";
	}
	@RequestMapping("/echarts/outEchart")
	public String outEchart(){
		return "outEchart";
	}
	@RequestMapping("/echarts/moveEchart")
	public String moveEchart(){
		return "moveEchart";
	}
	@RequestMapping("/echarts/storename")
	@ResponseBody
	
	public StoreNames names(String id,@RequestParam(value="page", defaultValue="1")int page,@RequestParam(value="rows", defaultValue="5")int rows){
		
		return echartsService.getStoreNames(id, page, rows);
	}
	@RequestMapping("/echarts/InItem/storeId")
	@ResponseBody
	public EchartsResult getInItemChartById( String id){
		
		return echartsService.getInItemChartById(id);
	}
	@RequestMapping("/echarts/OutItem/storeId")
	@ResponseBody
	
	public EchartsResult getOutItemChartById( String id){
		
		return echartsService.getOutItemChartById(id);
	}
	@RequestMapping("/echarts/MoveItem/storeId")
	@ResponseBody
	
	public EchartsResult getMoveItemChartById( String id){
		
		return echartsService.getMoveItemChartById(id);
	}
}
