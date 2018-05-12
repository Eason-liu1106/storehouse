package com.storehouse.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.storehouse.model.StoreName;
import com.storehouse.model.StoreNames;
import com.storehouse.pojo.custom.StoresCustom;

public interface BaseDaoI<T> {

	public Serializable save(T o);

	public void delete(T o);

	public boolean update(T o);

	public void saveOrUpdate(T o);

	public T get(Class<T> c, Serializable id);

	public T get(String hql);

	public T get(String hql, Map<String, Object> params);
	public Object find(Class clazz, String id) ;

	public List<T> find(String hql);

	public List<T> find(String hql, Map<String, Object> params);

	public List<T> find(String hql, int page, int rows);

	public List<T> find(String hql, Map<String, Object> params, int page, int rows);

	public Long count(String hql);

	public Long count(String hql, Map<String, Object> params);

	public int executeHql(String hql);

	public int executeHql(String hql, Map<String, Object> params);
	

	public List<StoreName> findObjects(String hql, int page, int rows);
	public List getHql(String hql);
	
	public Object judgeTOrF(String hql);
	

}
