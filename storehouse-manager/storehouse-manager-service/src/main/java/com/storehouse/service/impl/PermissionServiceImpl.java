package com.storehouse.service.impl;

import java.io.Serializable;
import java.security.acl.Permission;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.HibernateException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.storehouse.common.pojo.EUDataGridResult;
import com.storehouse.common.pojo.StorehouseResult;
import com.storehouse.common.utils.IDUtils;
import com.storehouse.dao.BaseDaoI;
import com.storehouse.model.BaseModel;
import com.storehouse.model.PermissionModel;
import com.storehouse.model.PermssionTreeModel;
import com.storehouse.model.RoleModel;
import com.storehouse.pojo.Stores;
import com.storehouse.pojo.SysPermission;
import com.storehouse.pojo.SysRole;
import com.storehouse.pojo.custom.StoresCustom;
import com.storehouse.service.PermissionService;




@Service()
public class PermissionServiceImpl  extends BaseServiceImpl implements PermissionService {

	@Autowired
	private BaseDaoI<SysPermission> permissionDao;

	@Override
	public EUDataGridResult getPermissions(BaseModel bm) {
		String hql="from SysPermission a";
		String totalhql="select count(*) from  SysPermission a  ";
		EUDataGridResult eUDataGridResult =new EUDataGridResult();
		Map<String ,Object> params=new HashMap<String,Object>();
		hql=addWhere(bm, hql, params);
		hql=addOrder(bm, hql);
		totalhql=addWhere(bm, totalhql, params);
		List<PermissionModel> permissionModels=new ArrayList<PermissionModel>();
		List<SysPermission>  permissions=permissionDao.find(hql, params, bm.getPage(), bm.getRows());
		Long total=permissionDao.count(totalhql,params);
		for(SysPermission permission : permissions){
			PermissionModel permissionModel=new PermissionModel();
			BeanUtils.copyProperties(permission, permissionModel);
			permissionModels.add(permissionModel);
		}
		eUDataGridResult.setRows(permissionModels);
		eUDataGridResult.setTotal(total);
		return eUDataGridResult ;
	}

	@Override
	public StorehouseResult update(SysPermission permission) {
		// TODO Auto-generated method stub
		permissionDao.update(permission);
		StorehouseResult storehouseResult=new StorehouseResult();
	
		storehouseResult.setMsg("更新成功");
		storehouseResult.setStatus(200);
		return storehouseResult;
	}

	@Override
	public StorehouseResult delete(Serializable ids) {
		// TODO Auto-generated method stub
		StorehouseResult storehouseResult=new StorehouseResult();
		permissionDao.delete(permissionDao.get(SysPermission.class, ids));
		storehouseResult.setMsg("删除成功");
		storehouseResult.setStatus(200);
		return storehouseResult;
	}



	@Override
	public StorehouseResult addPermission(SysPermission permission) {
		// TODO Auto-generated method stub
		String id = IDUtils.genItemId()+"";
		permission.setId(id);
		StorehouseResult storehouseResult=new StorehouseResult();		
		String  s=(String) permissionDao.save(permission);
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
	public List<PermssionTreeModel> getPermissionTree(String id) {
		// TODO Auto-generated method stub
		List<PermssionTreeModel> treegrid = new ArrayList<PermssionTreeModel>();
		String hql = "from SysPermission t where parentid=0";
		if (id != null && !id.trim().equals("")) {
			hql = "from SysPermission t where t.parentid="+id;
		}
		List<SysPermission> syspermissions = permissionDao.find(hql);
		for (SysPermission syspermission : syspermissions) {
			PermssionTreeModel r = new PermssionTreeModel();
			BeanUtils.copyProperties(syspermission, r);
			hql="from SysPermission t where t.parentid="+r.getId();
			List<SysPermission> syspermissionstemp = permissionDao.find(hql);
			if(syspermissionstemp!=null&&syspermissionstemp.size()>0)
			{
			r.setState("closed");
			r.setParentText("父节点");
			}else{
				
				r.setParentText("子节点");
			}
			treegrid.add(r);
		}
		return treegrid;
		
	}
	

	
}
