package com.storehouse.service;



import java.io.Serializable;


import com.storehouse.common.pojo.EUDataGridResult;
import com.storehouse.common.pojo.StorehouseResult;
import com.storehouse.model.BaseModel;
import com.storehouse.model.CalculateModel;
import com.storehouse.pojo.Customers;


public interface CustomerService extends BaseService {

	EUDataGridResult getCustomerList(BaseModel bm);
	StorehouseResult  addCustomer(Customers customer);
	StorehouseResult update(Customers customer);
	StorehouseResult delete(Serializable ids);
}
