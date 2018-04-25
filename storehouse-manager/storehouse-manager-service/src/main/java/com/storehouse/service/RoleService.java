package com.storehouse.service;





import java.io.Serializable;
import java.util.List;

import com.storehouse.common.pojo.EUDataGridResult;
import com.storehouse.common.pojo.StorehouseResult;
import com.storehouse.model.BaseModel;
import com.storehouse.model.PermssionTreeModel;
import com.storehouse.model.RoleModel;
import com.storehouse.pojo.SysRole;



public interface RoleService extends BaseService{

	EUDataGridResult getRoles(BaseModel bm);	
	StorehouseResult update(RoleModel rolemodel);
	StorehouseResult delete(Serializable ids);
	StorehouseResult addRole(RoleModel rolemodel);
	List<PermssionTreeModel> getRoleTree(String id);
	

	
}
