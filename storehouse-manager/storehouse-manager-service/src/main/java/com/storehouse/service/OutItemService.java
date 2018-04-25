package com.storehouse.service;

import java.io.Serializable;
import java.util.List;

import com.storehouse.common.pojo.EUDataGridResult;
import com.storehouse.common.pojo.StorehouseResult;
import com.storehouse.model.BaseModel;
import com.storehouse.model.CalculateModel;
import com.storehouse.model.InItemDetailModel;
import com.storehouse.model.MoveIntemModel;
import com.storehouse.model.OutItemModel;
import com.storehouse.pojo.InItem;
import com.storehouse.pojo.InItemDetail;
import com.storehouse.pojo.OutItem;
import com.storehouse.pojo.custom.ActiveUser;

public interface OutItemService extends BaseService{

	OutItem getOutItemById(String itemId);
	InItemDetailModel getOutItemDetailById(String itemId);
	EUDataGridResult getOutItemList(BaseModel bm);
	EUDataGridResult getOutItemDetailList(BaseModel bm);
	StorehouseResult addOutItem(OutItemModel outItemModel,ActiveUser activeUser) throws Exception;
	StorehouseResult update(OutItemModel outItemModel);
	StorehouseResult delete(Serializable ids);
	List getOutItemIdsByStoreId(String hql);
	List getOutItemChartByStoreId(String hql);
}
