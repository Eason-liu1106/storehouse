package com.storehouse.service;



import java.io.Serializable;


import com.storehouse.common.pojo.EUDataGridResult;
import com.storehouse.common.pojo.StorehouseResult;
import com.storehouse.model.BaseModel;
import com.storehouse.model.CalculateModel;


public interface CalculateService extends BaseService {

	EUDataGridResult getCalculateList(BaseModel bm);
	StorehouseResult  addCalculate(CalculateModel cm);
	StorehouseResult update(CalculateModel cm);
	StorehouseResult delete(Serializable ids);
}
