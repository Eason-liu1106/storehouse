package com.storehouse.service;





import java.io.Serializable;
import java.util.List;

import com.storehouse.common.pojo.EUDataGridResult;
import com.storehouse.common.pojo.StorehouseResult;
import com.storehouse.model.StoreModel;
import com.storehouse.model.StoreName;
import com.storehouse.model.StoreNames;
import com.storehouse.pojo.Stores;


public interface StoresService extends BaseService{

	EUDataGridResult getStoresList(StoreModel sm);
	StorehouseResult  addStore(StoreModel sm);
	StorehouseResult update(StoreModel sm);
	StorehouseResult delete(Serializable ids);
	Stores getStoreById(String id);
	StoreNames getStoreNames(String id, int page, int rows);
	Stores judgeStoreName(String param);
}
