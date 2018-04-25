package com.storehouse.service;





import java.io.Serializable;
import java.util.List;

import com.storehouse.common.pojo.EUDataGridResult;
import com.storehouse.common.pojo.StorehouseResult;
import com.storehouse.model.BaseModel;
import com.storehouse.model.PermssionTreeModel;
import com.storehouse.pojo.SysPermission;



public interface PermissionService extends BaseService{

	EUDataGridResult getPermissions(BaseModel bm);	
	StorehouseResult update(SysPermission permission);
	StorehouseResult delete(Serializable ids);

	StorehouseResult addPermission(SysPermission permission);
	List<PermssionTreeModel> getPermissionTree(String id);
	
}
