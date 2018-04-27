package com.storehouse.service;



import java.io.Serializable;
import java.util.List;

import com.storehouse.common.pojo.ComBoxResult;
import com.storehouse.common.pojo.EUDataGridResult;
import com.storehouse.common.pojo.StorehouseResult;
import com.storehouse.model.BaseModel;
import com.storehouse.model.CalculateModel;
import com.storehouse.model.RackModel;
import com.storehouse.pojo.Stores;

public interface RackService  extends BaseService {

	EUDataGridResult getRackList(BaseModel bm);
	StorehouseResult  addRack(RackModel rm);
	StorehouseResult update(RackModel rm);
	StorehouseResult delete(Serializable ids);
	List<ComBoxResult> getComBoxRackList(String id);
}
