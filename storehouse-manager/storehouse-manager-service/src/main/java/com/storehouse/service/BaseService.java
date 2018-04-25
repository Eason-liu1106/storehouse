package com.storehouse.service;

import java.io.Serializable;
import java.util.Map;


import com.storehouse.model.BaseModel;

public interface BaseService {
	Serializable save(Object o);
	
	String addOrder(BaseModel bm, String hql);
	String addWhere(BaseModel bm, String hql, Map<String, Object> params);
}
