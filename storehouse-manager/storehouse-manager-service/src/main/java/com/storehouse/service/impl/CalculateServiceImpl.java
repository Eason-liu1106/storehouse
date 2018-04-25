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
import com.storehouse.model.CalculateModel;
import com.storehouse.pojo.Calculate;

import com.storehouse.pojo.custom.CalculateCustom;

import com.storehouse.service.CalculateService;
@Service("calculateService")
public class CalculateServiceImpl extends BaseServiceImpl implements CalculateService {
	@Autowired
	private BaseDaoI<Calculate> calculateDao;
	@Override
	public EUDataGridResult getCalculateList(BaseModel bm) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				String  hql="from Calculate a ";
				String  totalhql="select count(*) from Calculate a";
				Map<String, Object> params=new HashMap<String, Object>();
				hql=addWhere(bm, hql, params);
				hql=addOrder(bm, hql);
				totalhql=addWhere(bm, totalhql, params);
				EUDataGridResult eUDataGridResult=new EUDataGridResult();
				
				List<Calculate> calculates= calculateDao.find(hql,params,bm.getPage(),bm.getRows());
				Long total=calculateDao.count(totalhql,params);
				
				List<CalculateCustom> calculateCustoms=new ArrayList<CalculateCustom>();
				if (calculates != null && calculates.size() > 0) {// 转换模型
					for (Calculate calculate : calculates) {
						CalculateCustom calculateCustom=new CalculateCustom();
						BeanUtils.copyProperties(calculate, calculateCustom);
						calculateCustoms.add(calculateCustom); 
					}
				}				
				eUDataGridResult.setRows(calculateCustoms);
				eUDataGridResult.setTotal(total);
				
				return eUDataGridResult;
	}
	@Override
	public StorehouseResult addCalculate(CalculateModel cm) {
		// TODO Auto-generated method stub
		StorehouseResult storehouseResult=new StorehouseResult();
	
		Calculate calculate=new  Calculate();
		BeanUtils.copyProperties(cm, calculate);
		
		calculate.setId(IDUtils.genItemId()+"");
		calculate.setCreatedatetime(new Timestamp(new Date().getTime()));
		calculate.setModifydatetime(new Timestamp(new Date().getTime()));
		String s=(String) calculateDao.save((Calculate)calculate);
		CalculateCustom calculateCustom=new CalculateCustom();
		//BeanUtils.copyProperties(calculateCustom,calculate);
		if(s.length()>0)
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
	public StorehouseResult update(CalculateModel cm) {
		// TODO Auto-generated method stub
		StorehouseResult storehouseResult=new StorehouseResult();
		Calculate calculate=new  Calculate();
		BeanUtils.copyProperties(cm, calculate);
		calculate.setModifydatetime(new Timestamp(new Date().getTime()));
		CalculateCustom calculateCustom=new CalculateCustom();
		BeanUtils.copyProperties(calculate,calculateCustom);
		if(calculateDao.update((Calculate) calculate))
		{
		
		storehouseResult.setData(calculateCustom);
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
			Calculate s = calculateDao.get(Calculate.class, id);
			if (s != null) {
				calculateDao.delete(s);
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
