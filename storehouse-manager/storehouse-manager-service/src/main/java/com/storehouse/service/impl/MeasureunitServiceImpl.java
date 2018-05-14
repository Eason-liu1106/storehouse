package com.storehouse.service.impl;

import java.io.Serializable;
import java.sql.Timestamp;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.storehouse.common.pojo.EUDataGridResult;
import com.storehouse.common.pojo.StorehouseResult;

import com.storehouse.dao.BaseDaoI;
import com.storehouse.model.BaseModel;
import com.storehouse.model.MeasureunitsModel;
import com.storehouse.pojo.InItemDetail;
import com.storehouse.pojo.Measureunits;
import com.storehouse.service.MeasureunitService;


@Service()
public class MeasureunitServiceImpl extends BaseServiceImpl implements MeasureunitService {
	@Autowired
	private BaseDaoI<Measureunits> measureunitDao;
	@Override
	public EUDataGridResult getMeasureunitList(BaseModel bm) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				String  hql="from Measureunits a ";
				String  totalhql="select count(*) from Measureunits a";
				Map<String, Object> params=new HashMap<String, Object>();
				hql=addWhere(bm, hql, params);
				hql=addOrder(bm, hql);
				totalhql=addWhere(bm, totalhql, params);
				EUDataGridResult eUDataGridResult=new EUDataGridResult();
				
				List<Measureunits> Measureunits= measureunitDao.find(hql,params,bm.getPage(),bm.getRows());
				Long total=measureunitDao.count(totalhql,params);							
				eUDataGridResult.setRows(Measureunits);
				eUDataGridResult.setTotal(total);
				
				return eUDataGridResult;
	}
	@Override
	public StorehouseResult addMeasureunit(Measureunits ms) {
		// TODO Auto-generated method stub
		StorehouseResult storehouseResult=new StorehouseResult();
	
	
	
		ms.setCreatedatetime(new Timestamp(new Date().getTime()));
		ms.setModifydatetime(new Timestamp(new Date().getTime()));
		Integer s=(Integer) measureunitDao.save((Measureunits)ms);
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
	public StorehouseResult update(Measureunits ms) {
		// TODO Auto-generated method stub
		StorehouseResult storehouseResult=new StorehouseResult();
		
		ms.setModifydatetime(new Timestamp(new Date().getTime()));
		if(measureunitDao.update((Measureunits)ms))
		{
			
			storehouseResult.setData(ms);
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

		int sid=0;
		for (String id : ((String) ids).split(",")) {
			sid=Integer.parseInt(id);
			String hql=" from InItemDetail where measureunit_id="+id;
			List<InItemDetail> inItemDetailList=measureunitDao.getHql(hql);
			if(inItemDetailList.size()>0){
				storehouseResult.setMsg("该计量单位正在被使用，无法删除，若要删除请先将所属商品删除");
				storehouseResult.setStatus(404);
			}else{
				Measureunits s = measureunitDao.get(Measureunits.class, sid);
				if (s != null) {
					measureunitDao.delete(s);
					storehouseResult.setMsg("删除成功");
					storehouseResult.setStatus(200);
				}
				else {
					storehouseResult.setMsg("删除失败");
					storehouseResult.setStatus(404);
				}
			}
			
		}
		return storehouseResult;
	}
	
	
}
