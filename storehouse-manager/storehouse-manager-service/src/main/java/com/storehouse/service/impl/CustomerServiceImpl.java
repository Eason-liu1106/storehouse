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
import com.storehouse.pojo.Customers;
import com.storehouse.service.CustomerService;


@Service()
public class CustomerServiceImpl extends BaseServiceImpl implements CustomerService {
	@Autowired
	private BaseDaoI<Customers> CustomersDao;
	@Override
	public EUDataGridResult getCustomerList(BaseModel bm) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		String  hql="from Customers a ";
		String  totalhql="select count(*) from Customers a";
		Map<String, Object> params=new HashMap<String, Object>();
		hql=addWhere(bm, hql, params);
		hql=addOrder(bm, hql);
		totalhql=addWhere(bm, totalhql, params);
		EUDataGridResult eUDataGridResult=new EUDataGridResult();
		
		List<Customers> Customers= CustomersDao.find(hql,params,bm.getPage(),bm.getRows());
		Long total=CustomersDao.count(totalhql,params);
			
		eUDataGridResult.setRows(Customers);
		eUDataGridResult.setTotal(total);
		
		return eUDataGridResult;
	}
	@Override
	public StorehouseResult addCustomer(Customers Customer) {
		// TODO Auto-generated method stub
		StorehouseResult storehouseResult=new StorehouseResult();		
	
		Customer.setCreatedatetime(new Timestamp(new Date().getTime()));
		Customer.setModifydatetime(new Timestamp(new Date().getTime()));
		Integer s= (Integer) CustomersDao.save((Customers)Customer);
		if(s>0)
		{
			
			storehouseResult.setMsg("添加成功");
			storehouseResult.setStatus(200);
		}else {
			storehouseResult.setMsg("对不起添加失败,请重新添加");
			storehouseResult.setStatus(404);
		}
		return storehouseResult;
	}
	@Override
	public StorehouseResult update(Customers Customer) {
		// TODO Auto-generated method stub
		StorehouseResult storehouseResult=new StorehouseResult();
	
	
		Customer.setModifydatetime(new Timestamp(new Date().getTime()));
	
		if(CustomersDao.update((Customers) Customer))
		{
		
		storehouseResult.setData(Customer);
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
			Customers s = CustomersDao.get(Customers.class, Integer.valueOf(id));
			if (s != null) {
				CustomersDao.delete(s);
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
