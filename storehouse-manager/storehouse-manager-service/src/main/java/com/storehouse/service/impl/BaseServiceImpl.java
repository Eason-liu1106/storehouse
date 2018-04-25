package com.storehouse.service.impl;

import java.io.Serializable;
import java.util.Map;


import com.storehouse.model.BaseModel;
import com.storehouse.service.BaseService;

public class BaseServiceImpl implements BaseService {


	@Override
	public Serializable save(Object o) {
		// TODO Auto-generated method stub
		return null;
	}
	public String addOrder(BaseModel bm, String hql) {
		if (bm.getSort() != null) {
			hql += " order by " + bm.getSort() + " " + bm.getOrder();
		}
		return hql;
	}

	
	
	public String addWhere(BaseModel bm, String hql, Map<String, Object> params) {
		hql += " where 1=1 ";
		if (bm.getCreatedatetimeStart() != null) {
			hql += " and a.createdatetime >= :getCreatedatetimeStart";
			params.put("getCreatedatetimeStart", bm.getCreatedatetimeStart());
		}
		if (bm.getCreatedatetimeEnd() != null) {
			hql += " and a.createdatetime <= :getCreatedatetimeEnd";
			params.put("getCreatedatetimeEnd", bm.getCreatedatetimeEnd());
		}
		if (bm.getModifydatetimeStart() != null) {
			hql += " and a.modifydatetime >= :getModifydatetimeStart";
			params.put("getModifydatetimeStart", bm.getModifydatetimeStart());
		}
		if (bm.getModifydatetimeEnd() != null) {
			hql += " and a.modifydatetime <= :getModifydatetimeEnd";
			params.put("getModifydatetimeEnd", bm.getModifydatetimeEnd());
		}
		if (bm.getQ() != null && !bm.getQ().trim().equals("")) {
			hql += " and a.name like :name ";
			params.put("name", "%%" + bm.getQ().trim() + "%%");
		}
		if (bm.getName() != null && !bm.getName().trim().equals("")) {
			hql += " and a.name like :name";
			params.put("name", "%%" + bm.getName().trim() + "%%");
		}
		
		return hql;
	}



	




	
	
}
