package com.storehouse.service;



import java.io.Serializable;


import com.storehouse.common.pojo.EUDataGridResult;
import com.storehouse.common.pojo.StorehouseResult;
import com.storehouse.model.BaseModel;
import com.storehouse.model.CalculateModel;
import com.storehouse.pojo.Measureunits;


public interface MeasureunitService extends BaseService {

	EUDataGridResult getMeasureunitList(BaseModel bm);
	StorehouseResult  addMeasureunit(Measureunits ms);
	StorehouseResult update(Measureunits ms);
	StorehouseResult delete(Serializable ids);
}
