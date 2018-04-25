package com.storehouse.controller;




import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;

import com.storehouse.exception.CustomException;
import com.storehouse.pojo.SysUser;
import com.storehouse.pojo.custom.ActiveUser;
import com.storehouse.service.UserService;



@Controller
public class LoginController {

	@Autowired
	UserService userService;
	
	@RequestMapping("/login")
	public String login(){
		
		return "login";
	}
	@RequestMapping("/logout")
	public String logout(HttpSession session){
		session.invalidate();
		return "login";
	}
	@RequestMapping("/portal")
	public String portal(){
		
		return "portal";
	}

	@RequestMapping("/validate")
	public String validate(SysUser user,HttpServletRequest request,HttpSession session) throws Exception{
		

		ActiveUser activeUser=userService.login(user);
		
		if(activeUser!=null)
		{
			//如果service校验通过，将用户身份记录到session
			session.setAttribute("activeUser", activeUser);
			//重定向到主页面
			return "redirect:/index.action";
		}
		
		//如果登陆失败从request中获取认证异常信息，shiroLoginFailure就是shiro异常类的全限定名
				String exceptionClassName = (String) request.getAttribute("shiroLoginFailure");
				//根据shiro返回的异常类路径判断，抛出指定异常信息
				if(exceptionClassName!=null){
					if("randomCodeError".equals(exceptionClassName)){
						throw new CustomException("验证码错误 ");
					}else {
						throw new Exception();//最终在异常处理器生成未知错误
					}
				}								
		
			
				
				return "login";
	}

}
