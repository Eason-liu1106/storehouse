package com.storehouse.controller.interceptor;

import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.storehouse.common.utils.ResourcesUtil;
import com.storehouse.pojo.SysPermission;
import com.storehouse.pojo.custom.ActiveUser;

public class PermissionInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		
		String url=request.getRequestURI();
		List<String> open_urls=ResourcesUtil.gekeyList("anonymousURL");
		for(String open_url: open_urls){
			if(url.indexOf(open_url)>=0){
				return true;
			}
		}
		List<String> common_urls=ResourcesUtil.gekeyList("commonURL");
		for(String common_url : common_urls){
			if(url.indexOf(common_url)>0){
				return true;
			}
		}
		HttpSession httpsession=request.getSession();
		ActiveUser activeUser=(ActiveUser) httpsession.getAttribute("activeUser");
		if(activeUser!=null){
			if(activeUser.getUsercode().equals("root")){
				return true;
			}
			List<SysPermission>	permissions=activeUser.getPermissions();
		
			for(SysPermission permission: permissions){

			if(url.indexOf(permission.getUrl())>0){
				return true;
			}
				
			}
		}
		//执行到这里拦截，跳转到登陆页面，用户进行身份认证
		request.getRequestDispatcher("/WEB-INF/jsp/refuse.jsp").forward(request, response);
		return false;
	}

}
