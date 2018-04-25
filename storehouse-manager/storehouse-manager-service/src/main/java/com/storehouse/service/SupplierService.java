package com.storehouse.service;



import java.io.Serializable;


import com.storehouse.common.pojo.EUDataGridResult;
import com.storehouse.common.pojo.StorehouseResult;
import com.storehouse.model.BaseModel;

import com.storehouse.pojo.Suppliers;


public interface SupplierService extends BaseService {

	EUDataGridResult getSupplierList(BaseModel bm);
	StorehouseResult  addSupplier(Suppliers supplier);
	StorehouseResult update(Suppliers supplier);
	StorehouseResult delete(Serializable ids);
}
