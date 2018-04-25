package com.storehouse.service.impl;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.storehouse.common.pojo.EUDataGridResult;
import com.storehouse.common.pojo.StorehouseResult;
import com.storehouse.common.utils.IDUtils;
import com.storehouse.dao.BaseDaoI;
import com.storehouse.model.BaseModel;

import com.storehouse.model.StoreTypeModel;

import com.storehouse.pojo.StoreType;

import com.storehouse.pojo.custom.StoreTypeCustom;

import com.storehouse.service.StoreTypeService;




@Service("storeTypeService")
public class StoreTypeServiceImpl  extends BaseServiceImpl implements StoreTypeService {

	@Autowired
	private BaseDaoI<StoreType> storeTypeDao;
	@Override
	public EUDataGridResult getStoreTypeList(BaseModel bm) {
		// TODO Auto-generated method stub
		String  hql="from StoreType a ";
		Map<String, Object> params=new HashMap<String, Object>();
		hql=addWhere(bm, hql, params);
		hql=addOrder(bm, hql);
		String  totalhql="select count(*) from StoreType a ";
		totalhql=addWhere(bm, totalhql, params);
		
		EUDataGridResult eUDataGridResult=new EUDataGridResult();
		List<StoreType> storeTypes= storeTypeDao.find(hql,params,bm.getPage(),bm.getRows());
		
		Long total=storeTypeDao.count(totalhql,params);
		List<StoreTypeCustom> storesTypeCustoms=new ArrayList<StoreTypeCustom>();
		if (storeTypes != null && storeTypes.size() > 0) {// 转换模型
			for (StoreType storeType : storeTypes) {
				StoreTypeCustom storesTypeCustom=new StoreTypeCustom();
				BeanUtils.copyProperties(storeType, storesTypeCustom);
				storesTypeCustoms.add(storesTypeCustom);
			}
		}
		eUDataGridResult.setRows(storesTypeCustoms);
		eUDataGridResult.setTotal(total);
		
		return eUDataGridResult;
	}
	@Override
	public StorehouseResult addStoreType(StoreTypeModel stm) {
		// TODO Auto-generated method stub
		StorehouseResult storehouseResult=new StorehouseResult();
		StoreType storeType=new StoreType();
		BeanUtils.copyProperties(stm, storeType);
		storeType.setId(IDUtils.genItemId()+"");
		storeType.setCreatedatetime(new Timestamp(new Date().getTime()));
		storeType.setModifydatetime(new Timestamp(new Date().getTime()));
		String s=(String) storeTypeDao.save((StoreType)storeType);
		StoreTypeCustom storeTypeCustom=new StoreTypeCustom();
		BeanUtils.copyProperties(storeType,storeTypeCustom);
		if(s.length()>0)
		{
			storehouseResult.setData(storeTypeCustom);
			storehouseResult.setMsg("添加成功");
			storehouseResult.setStatus(200);
		}else {
			storehouseResult.setMsg("对不起添加失败,请重新添加");
			storehouseResult.setStatus(404);
		}
		return storehouseResult;
	}
	@Override
	public StorehouseResult update(StoreTypeModel stm) {
		// TODO Auto-generated method stub
		StorehouseResult storehouseResult=new StorehouseResult();
		StoreType storeType=new StoreType();
		BeanUtils.copyProperties(stm, storeType);
		 storeType.setModifydatetime(new Timestamp(new Date().getTime()));
		 StoreTypeCustom storeTypeCustom=new StoreTypeCustom();
			BeanUtils.copyProperties(storeType,storeTypeCustom);
		if(storeTypeDao.update((StoreType) storeType))
		{
		
		storehouseResult.setData(storeTypeCustom);
		storehouseResult.setMsg("修改成功");
		storehouseResult.setStatus(200);
	
		}else{
			storehouseResult.setStatus(404);
			storehouseResult.setMsg("更新失败，请重试");
			
		}
		return storehouseResult;
	}
	@Override
	public StorehouseResult delete(Serializable ids) {
		// TODO Auto-generated method stub
		StorehouseResult storehouseResult=new StorehouseResult();
		for (String id : ((String) ids).split(",")) {
			StoreType s = storeTypeDao.get(StoreType.class, id);
			if (s != null) {
				storeTypeDao.delete(s);
				storehouseResult.setMsg("删除成功");
				storehouseResult.setStatus(200);
			}
			else {
				storehouseResult.setMsg("删除失败");
				storehouseResult.setStatus(404);
			}
		}
		return storehouseResult;
	}
	
}
