package com.storehouse.service;

import com.storehouse.common.pojo.StorehouseResult;
import com.storehouse.pojo.ItemParam;

public interface ItemParamService {

	StorehouseResult getItemParamByCid(long cid);
	StorehouseResult insertItemParam(ItemParam itemParam);
}
