package com.storehouse.service.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.storehouse.common.pojo.StorehouseResult;
import com.storehouse.dao.BaseDaoI;

import com.storehouse.pojo.ItemParam;
import com.storehouse.service.ItemParamService;


/**
 * 商品规格参数模板管理
 * <p>Title: ItemParamServiceImpl</p>
 * <p>Description: </p>
 * <p>Company: www.itcast.com</p> 
 * @author	入云龙
 * @date	2015年9月5日下午2:36:57
 * @version 1.0
 */
@Service
public class ItemParamServiceImpl implements ItemParamService {

	@Autowired
	private BaseDaoI<ItemParam> itemParamDao;
	
	@Override
	public StorehouseResult  getItemParamByCid(long cid) {
		String hql="from ItemParam where item_cat_id="+cid;
		List<ItemParam> list = itemParamDao.find(hql);
		//判断是否查询到结果
		if (list != null && list.size() > 0) {
			return StorehouseResult.ok(list.get(0));
		}
		
		return StorehouseResult.ok();
	}

	@Override
	public StorehouseResult  insertItemParam(ItemParam itemParam) {
		//补全pojo
		itemParam.setCreatedatetime(new Timestamp(new Date().getTime()));
		itemParam.setModifydatetime(new Timestamp(new Date().getTime()));
		
		//插入到规格参数模板表
		itemParamDao.save(itemParam);
		return StorehouseResult.ok();
	}

}
