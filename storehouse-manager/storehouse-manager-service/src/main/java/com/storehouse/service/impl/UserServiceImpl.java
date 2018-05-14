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
import com.storehouse.common.utils.MD5;
import com.storehouse.dao.BaseDaoI;
import com.storehouse.exception.CustomException;
import com.storehouse.model.BaseModel;

import com.storehouse.model.UserModel;

import com.storehouse.pojo.SysPermission;
import com.storehouse.pojo.SysRole;
import com.storehouse.pojo.SysRolePermission;
import com.storehouse.pojo.SysUser;
import com.storehouse.pojo.SysUserRole;
import com.storehouse.pojo.custom.ActiveUser;
import com.storehouse.pojo.custom.StoresCustom;
import com.storehouse.service.UserService;




@Service()
public class UserServiceImpl  extends BaseServiceImpl implements UserService {

	@Autowired
	private BaseDaoI<SysUser> userDao;
	@Autowired
	private BaseDaoI<SysRole> roleDao;
	@Autowired
	private BaseDaoI<SysUserRole> userroleDao;
	@Override
	public EUDataGridResult getUsers(BaseModel bm) {
		// TODO Auto-generated method stub
		
		String hql="from SysUser a";
		String  totalhql="select count(*) from SysUser a";
		
		Map<String, Object> params=new HashMap<String, Object>();
		hql=addWhere(bm, hql, params);
		hql=addOrder(bm, hql);
		totalhql=addWhere(bm, totalhql, params);
		List<SysUser> users= userDao.find(hql,params,bm.getPage(),bm.getRows());
		Long total=userDao.count(totalhql,params);
		EUDataGridResult eUDataGridResult=new EUDataGridResult();
		List <UserModel> usermodels=new ArrayList<UserModel>();
		changeModel(users,usermodels);
		eUDataGridResult.setRows(usermodels);
		eUDataGridResult.setTotal(total);
		return eUDataGridResult;
	}
	@Override
	public StorehouseResult update(UserModel usermodel) {
		StorehouseResult storehouseResult=new StorehouseResult();
		String  s=null;
		SysUser user=userDao.get(SysUser.class, usermodel.getId());
		BeanUtils.copyProperties(usermodel, user);
		user.setPassword(new MD5().getMD5ofStr(usermodel.getPassword()));
		if(userDao.update(user)){
			storehouseResult.setMsg("修改成功");
			storehouseResult.setStatus(200);
		}else{
			storehouseResult.setStatus(404);
			storehouseResult.setMsg("更新失败，请重试");
		}
		Set<SysRole> roles=user.getSysroles();
		StringBuilder ids=new StringBuilder();
		for(SysRole role : roles){
			ids.append(role.getId());
		}
		if(usermodel.getRoleIds()!=ids.toString()){
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("sys_user_id", user.getId());
			String hql="delete from SysUserRole where sys_user_id=:sys_user_id";
			userroleDao.executeHql(hql, params);
			for (String id : usermodel.getRoleIds().split(",")){ 
				SysUserRole userrole=new SysUserRole();
				userrole.setId(IDUtils.genItemId()+"");
				userrole.setSysUserId(user.getId());
				userrole.setSysRoleId(id);
				s=(String) userroleDao.save(userrole);
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
			SysUser s = userDao.get(SysUser.class, id);
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("sys_user_id", id);
			String hql="delete from SysUserRole where sys_user_id=:sys_user_id";
			userroleDao.executeHql(hql, params);
			if (s != null) {
				userDao.delete(s);
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
	public ActiveUser login(SysUser user) throws Exception {
		// TODO Auto-generated method stub
		ActiveUser activeUser =this.authenticat(user.getUsercode(), user.getPassword());
		return activeUser;
	}
	@Override
	public StorehouseResult addUser(UserModel usermodel,String password,String repassword) {
		SysUser user=new SysUser();
		Set<SysRole> roles=new HashSet();
		StorehouseResult storehouseResult=new StorehouseResult();
	
		SysUserRole userrole=new SysUserRole(); 
		BeanUtils.copyProperties(usermodel, user);
		user.setLocked("0");
		user.setId(IDUtils.genItemId()+"");
		user.setPassword(new MD5().getMD5ofStr(usermodel.getPassword()));
		if(password.equals(repassword)){
			String s=(String)userDao.save(user);
			if(s.length()>0)
			{
			
				
				storehouseResult.setMsg("添加成功");
				storehouseResult.setStatus(200);
			}else {
				storehouseResult.setMsg("对不起添加失败,请重新添加");
				storehouseResult.setStatus(404);
			}
		}else{
			storehouseResult.setMsg("两次密码不相同，添加失败，请重新添加");
			storehouseResult.setStatus(404);
		}
		String[] ids=usermodel.getRoleIds().split(",");
		userrole.setId(IDUtils.genItemId()+"");
		userrole.setSysUserId(user.getId());
		for(String id:ids){
			userrole.setSysRoleId(id);
			
			if(password.equals(repassword)){
				String s2=(String)userroleDao.save(userrole);
				if(s2.length()>0)
				{
				
					storehouseResult.setMsg("添加成功");
					storehouseResult.setStatus(200);
				}else {
					storehouseResult.setMsg("对不起添加失败,请重新添加");
					storehouseResult.setStatus(404);
				}
			}else{
				storehouseResult.setMsg("两次密码不相同，添加失败，请重新添加");
				storehouseResult.setStatus(404);
			}
		}
		return storehouseResult;
	}
	public void changeModel(List<SysUser> users,List <UserModel> usermodels){
		if (users != null && users.size() > 0) {
			for(SysUser user:users){
				UserModel usermodel=new UserModel();
				BeanUtils.copyProperties(user, usermodel);
				
				Set<SysRole> roles=user.getSysroles();
				
				if(roles !=null && roles.size()>0)
				{

					StringBuilder roleIds=new StringBuilder();
					StringBuilder roleNames=new StringBuilder();
					StringBuilder permissionIds=new StringBuilder();
					StringBuilder permissionNames=new StringBuilder();
					for(SysRole role:roles){
						if (roleIds.length() > 0) {
							roleIds.append(",");
							roleNames.append(",");
						}
						roleIds.append(role.getId());
						roleNames.append(role.getName());
						Set<SysPermission> permissions=role.getSyspermissions();
						for(SysPermission permission:permissions){
							if(permissionIds.length()>0){
								permissionIds.append(",");
								permissionNames.append(",");
							}
							permissionIds.append(permission.getId());
							permissionNames.append(permission.getName());
						}
						
					}
					usermodel.setRoleIds(roleIds.toString());
					usermodel.setRoleNames(roleNames.toString());
					usermodel.setPermissionIds(permissionIds.toString());
					usermodel.setPermissionNames(permissionNames.toString());
				}
			
				usermodels.add(usermodel);
			}
		}
	}
	@Override
	public ActiveUser authenticat(String userCode, String password) throws Exception {
		/**
		认证过程：
		根据用户身份（账号）查询数据库，如果查询不到用户不存在
		对输入的密码 和数据库密码 进行比对，如果一致，认证通过
			 */
			//根据用户账号查询数据库
			SysUser sysUser = this.findSysUserByUserCode(userCode);
			
			if(sysUser == null){
				//抛出异常
				throw new CustomException("用户账号不存在");
			}
			
			//数据库密码 (md5密码 )
			String password_db = sysUser.getPassword();
			
			//对输入的密码 和数据库密码 进行比对，如果一致，认证通过
			//对页面输入的密码 进行md5加密 
			String password_input_md5 = new MD5().getMD5ofStr(password);
			if(!password_input_md5.equalsIgnoreCase(password_db)){
				//抛出异常
				throw new CustomException("用户名或密码 错误");
			}
			//得到用户id
			String userid = sysUser.getId();
			//根据用户id查询菜单 
			//List<SysPermission> menus =this.findMenuListByUserId(userid);
			
			//根据用户id查询权限url
			List<SysPermission> permissions = this.findPermissionListByUserId(userid);
			
			//认证通过，返回用户身份信息
			ActiveUser activeUser = new ActiveUser();
			activeUser.setUserid(sysUser.getId());
			activeUser.setUsercode(userCode);
			activeUser.setUsername(sysUser.getUsername());//用户名称
			
			//放入权限范围的菜单和url
			//activeUser.setMenus(menus);
			activeUser.setPermissions(permissions);
			
			return activeUser;
	}
	@Override
	public SysUser findSysUserByUserCode(String userCode ) throws Exception {
		
		String hql="from SysUser where usercode ='"+userCode+"' ";
		SysUser user=userDao.get(hql);

		return user;
	}
	@Override
	public List<SysPermission> findMenuListByUserId(String userid) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<SysPermission> findPermissionListByUserId(String userid) throws Exception {
		// TODO Auto-generated method stub
		String hql="from SysUser where id='"+userid+"' ";
		SysUser user=userDao.get(hql);
		Set<SysRole> roles=user.getSysroles();
		
		List<SysPermission> list = new ArrayList();
		for(SysRole role:roles){
			Set<SysPermission> permissions=role.getSyspermissions();
			if(permissions!=null&&permissions.size()>0)
			{
				
				for(SysPermission permission:permissions){
					list.add(permission);
				}
			}
		}

		
		return list;
	}
}
