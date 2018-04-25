package com.storehouse.service;

import java.io.Serializable;
import java.util.List;

import com.storehouse.common.pojo.EUDataGridResult;
import com.storehouse.common.pojo.StorehouseResult;
import com.storehouse.model.BaseModel;
import com.storehouse.model.CalculateModel;
import com.storehouse.model.InItemDetailModel;
import com.storehouse.model.MoveIntemModel;
import com.storehouse.pojo.InItem;
import com.storehouse.pojo.InItemDetail;
import com.storehouse.pojo.Stores;
import com.storehouse.pojo.custom.ActiveUser;

public interface InItemService extends BaseService{

	InItem getInItemById(String itemId);
	InItemDetailModel getInItemDetailById(String itemId);
	EUDataGridResult getInItemList(BaseModel bm);
	EUDataGridResult getInItemDetailList(BaseModel bm);
	StorehouseResult addInItem(InItemDetailModel inItemDetailModel,InItem inItem, String itemParam,ActiveUser activeUser,Stores stores,String time) throws Exception;
	StorehouseResult update(InItemDetailModel inItemDetailModel,InItem inItem, String itemParam);
	StorehouseResult delete(Serializable ids);
	StorehouseResult moveInItem(MoveIntemModel moveInItemModel,ActiveUser activeUser,InItemDetailModel inItemDetailModel);

	List getInItemIdsByStoreId(String hql);
	List getInItemChartByStoreId(String hql);
}
