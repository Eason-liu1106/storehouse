package com.storehouse.service;





import java.io.Serializable;

import com.storehouse.common.pojo.EUDataGridResult;
import com.storehouse.common.pojo.StorehouseResult;
import com.storehouse.model.BaseModel;

import com.storehouse.model.StoreTypeModel;


public interface StoreTypeService extends BaseService{

	EUDataGridResult getStoreTypeList(BaseModel bm);
	StorehouseResult  addStoreType(StoreTypeModel sm);
	StorehouseResult update(StoreTypeModel sm);
	StorehouseResult delete(Serializable ids);
}
