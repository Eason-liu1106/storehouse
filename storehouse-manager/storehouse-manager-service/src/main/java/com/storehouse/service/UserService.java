package com.storehouse.service;





import java.io.Serializable;
import java.util.List;

import com.storehouse.common.pojo.EUDataGridResult;
import com.storehouse.common.pojo.StorehouseResult;
import com.storehouse.model.BaseModel;
import com.storehouse.model.StoreModel;
import com.storehouse.model.UserModel;
import com.storehouse.pojo.SysPermission;
import com.storehouse.pojo.SysUser;
import com.storehouse.pojo.custom.ActiveUser;




public interface UserService extends BaseService{

	EUDataGridResult getUsers(BaseModel bm);	
	StorehouseResult update(UserModel usermodel);
	StorehouseResult delete(Serializable ids);
	ActiveUser login(SysUser  user)throws Exception;
	StorehouseResult addUser(UserModel usermodel,String password,String repassword);
	//根据用户的身份和密码 进行认证，如果认证通过，返回用户身份信息
	 ActiveUser authenticat(String userCode,String password) throws Exception;
	
	//根据用户账号查询用户信息
	SysUser findSysUserByUserCode(String userCode)throws Exception;
	
	//根据用户id查询权限范围的菜单
	 List<SysPermission> findMenuListByUserId(String userid) throws Exception;
	
	//根据用户id查询权限范围的url
	 List<SysPermission> findPermissionListByUserId(String userid) throws Exception;

	
}
