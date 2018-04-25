package com.storehouse.service;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

import com.storehouse.common.pojo.EchartsResult;
import com.storehouse.model.StoreName;
import com.storehouse.model.StoreNames;

public interface EchartsService  {

	EchartsResult getInItemChartById(String id);
	EchartsResult getOutItemChartById(String id);
	EchartsResult getMoveItemChartById(String id);
	StoreNames getStoreNames(String id, int page, int rows);
}
	
