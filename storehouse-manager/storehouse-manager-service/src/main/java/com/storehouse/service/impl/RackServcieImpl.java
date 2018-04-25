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
import com.storehouse.model.RackModel;

import com.storehouse.pojo.Rack;

import com.storehouse.pojo.custom.RackCustom;
import com.storehouse.service.RackService;
@Service("rackService")
public class RackServcieImpl  extends BaseServiceImpl implements RackService {

	@Autowired
	private BaseDaoI<Rack> rackDao;
	@Override
	public EUDataGridResult getRackList(BaseModel bm) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				String  hql="from Rack a";
				String  totalhql="select count(*) from Rack a";
				EUDataGridResult eUDataGridResult=new EUDataGridResult();
				Map<String, Object> params=new HashMap<String, Object>();
				hql=addWhere(bm, hql, params);
				hql=addOrder(bm, hql);
				totalhql=addWhere(bm, totalhql, params);
				List<Rack> racks= rackDao.find(hql,params,bm.getPage(),bm.getRows());
				Long total=rackDao.count(totalhql,params);
				
				List<RackCustom> rackCustoms=new ArrayList<RackCustom>();
				if (racks != null && racks.size() > 0) {// 转换模型
					for (Rack rack : racks) {
						RackCustom rackCustom=new RackCustom();
						BeanUtils.copyProperties(rack, rackCustom);
						rackCustoms.add(rackCustom);
					}
				}
				
				eUDataGridResult.setRows(rackCustoms);
				eUDataGridResult.setTotal(total);
				
				return eUDataGridResult;
	}
	@Override
	public StorehouseResult addRack(RackModel rm) {
		// TODO Auto-generated method stub
		StorehouseResult storehouseResult=new StorehouseResult();
		Rack rack=new Rack();
		BeanUtils.copyProperties(rm, rack);
		rack.setId(IDUtils.genItemId()+"");
		rack.setCreatedatetime(new Timestamp(new Date().getTime()));
		rack.setModifydatetime(new Timestamp(new Date().getTime()));
		String s=(String) rackDao.save((Rack)rack);
		RackCustom rackCustom=new RackCustom();
		BeanUtils.copyProperties(rack,rackCustom);
		if(s.length()>0)
		{
			storehouseResult.setData(rackCustom);
			storehouseResult.setMsg("添加成功");
			storehouseResult.setStatus(200);
		}else {
			storehouseResult.setMsg("对不起添加失败,请重新添加");
			storehouseResult.setStatus(404);
		}
		return storehouseResult;
	
	}
	@Override
	public StorehouseResult update(RackModel rm) {
		// TODO Auto-generated method stub
		StorehouseResult storehouseResult=new StorehouseResult();
		Rack rack=new Rack();
		BeanUtils.copyProperties(rm,rack);
		rack.setModifydatetime(new Timestamp(new Date().getTime()));
		RackCustom rackCustom=new RackCustom();
		BeanUtils.copyProperties(rack,rackCustom);
		if(rackDao.update((Rack) rack))
		{
		
		storehouseResult.setData(rackCustom);
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
			Rack s = rackDao.get(Rack.class, id);
			if (s != null) {
				rackDao.delete(s);
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
