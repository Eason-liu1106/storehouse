package com.storehouse.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.storehouse.common.pojo.EUDataGridResult;
import com.storehouse.common.pojo.StorehouseResult;
import com.storehouse.common.utils.IDUtils;
import com.storehouse.dao.BaseDaoI;
import com.storehouse.model.BaseModel;
import com.storehouse.model.PermssionTreeModel;
import com.storehouse.model.RoleModel;
import com.storehouse.pojo.Stores;
import com.storehouse.pojo.SysPermission;
import com.storehouse.pojo.SysRole;
import com.storehouse.pojo.SysRolePermission;
import com.storehouse.service.RoleService;




@Service()
public class RoleServiceImpl  extends BaseServiceImpl implements RoleService {

	@Autowired
	private BaseDaoI<SysRole> roleDao;
	@Autowired
	private BaseDaoI<SysPermission> permissionDao;
	@Autowired
	private BaseDaoI<SysRolePermission> rolepermissionDao;
	
	@Override
	public EUDataGridResult getRoles(BaseModel bm) {
		// TODO Auto-generated method stub
		String hql="from SysRole a";
		String totalhql="select count(*) from  SysRole a  ";
		EUDataGridResult eUDataGridResult =new EUDataGridResult();
		Map<String ,Object> params=new HashMap<String,Object>();
		hql=addWhere(bm, hql, params);
		hql=addOrder(bm, hql);
		totalhql=addWhere(bm, totalhql, params);
		List<RoleModel> roleModels=new ArrayList<RoleModel>();
		List<SysRole> roles=roleDao.find(hql, params, bm.getPage(), bm.getRows());
		Long total=roleDao.count(totalhql,params);
		for(SysRole role:roles){
			RoleModel roleModel=new RoleModel();
			StringBuilder roleIds=new StringBuilder();
			StringBuilder roleNames=new StringBuilder();
			Set<SysPermission> permissions=role.getSyspermissions();
			for(SysPermission permission:permissions){
				if(roleIds.length()>0){
					roleIds.append(",");
					roleNames.append(",");
				}
				roleNames.append(permission.getName());
				roleIds.append(permission.getId());
			}
			BeanUtils.copyProperties(role, roleModel);
			roleModel.setPermissionNames(roleNames.toString());
			roleModel.setPermissionIds(roleIds.toString());
			roleModels.add(roleModel);
		}
		eUDataGridResult.setRows(roleModels);
		eUDataGridResult.setTotal(total);
		return eUDataGridResult ;
	}

	@Override
	public StorehouseResult update(RoleModel rolemodel) {
		StorehouseResult storehouseResult=new StorehouseResult();
		String  s=null;
	
		SysRole role=roleDao.get(SysRole.class, rolemodel.getId());
		BeanUtils.copyProperties(rolemodel, role);
		if(roleDao.update(role)){
			
				storehouseResult.setMsg("修改成功");
				storehouseResult.setStatus(200);
		}else{
				storehouseResult.setStatus(404);
				storehouseResult.setMsg("更新失败，请重试");
		}
		Set<SysPermission> permissions=role.getSyspermissions();
		StringBuilder ids=new StringBuilder();
		for(SysPermission permission : permissions){
			ids.append(permission.getId());
		}
		if(rolemodel.getPermissionIds()!=ids.toString()){
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("sys_role_id", role.getId());
		String hql="delete from SysRolePermission where sys_role_id=:sys_role_id";
		rolepermissionDao.executeHql(hql, params);
		for (String id : rolemodel.getPermissionIds().split(",")){ 
			SysRolePermission rolepermission=new SysRolePermission();
			rolepermission.setId(IDUtils.genItemId()+"");
			rolepermission.setSysPermissionId(id);
			rolepermission.setSysRoleId(role.getId());
			s=(String) rolepermissionDao.save(rolepermission);
		}
		
		if(s.length()>0){
			
			storehouseResult.setMsg("更新成功");
			storehouseResult.setStatus(200);
		}else {
			storehouseResult.setMsg("对不起更新失败");
			storehouseResult.setStatus(404);
		}
	}
		return storehouseResult;
}

	@Override
	public StorehouseResult delete(Serializable ids) {
		// TODO Auto-generated method stub
				StorehouseResult storehouseResult=new StorehouseResult();
					for (String id : ((String) ids).split(",")) {
						SysRole s = roleDao.get(SysRole.class, id);
						if (s != null) {
							roleDao.delete(s);
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


	@Override
	public StorehouseResult addRole(RoleModel rolemodel) {
		StorehouseResult storehouseResult=new StorehouseResult();
		String temp=rolemodel.getPermissionIds();
		SysRole role=new SysRole();
		
		BeanUtils.copyProperties(rolemodel, role);
		role.setAvailable("1");
		role.setId(IDUtils.genItemId()+"");

		String  x=(String)roleDao.save(role);
		if(x.length()>0){
			
			storehouseResult.setMsg("添加成功");
			storehouseResult.setStatus(200);
		}else {
			storehouseResult.setMsg("对不起添加失败,请重新添加");
			storehouseResult.setStatus(404);
		}
		String[] ids=temp.split(",");
		Set<SysPermission> syspermissions=new HashSet<SysPermission>();
		for(String id:ids){
			SysRolePermission rolepermission=new SysRolePermission();
			rolepermission.setId(IDUtils.genItemId()+"");
			rolepermission.setSysPermissionId(id);
			rolepermission.setSysRoleId(role.getId());
			String s=(String)rolepermissionDao.save(rolepermission);
			if(s.length()>0)
			{
				storehouseResult.setMsg("添加成功");
				storehouseResult.setStatus(200);
			}else {
				storehouseResult.setMsg("对不起添加失败,请重新添加");
				storehouseResult.setStatus(404);
			}
		}
		
		return storehouseResult;
	}

	

	@Override
	public List<PermssionTreeModel> getRoleTree(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
