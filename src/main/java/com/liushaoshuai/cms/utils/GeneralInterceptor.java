package com.liushaoshuai.cms.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.liushaoshuai.cms.domain.User;

/**
 * @ClassName: GeneralInterceptor 
 * @Description: 普通用户后台拦截器
 * @author:鄙人：刘某 
 * @date: 2019年7月19日 下午4:50:51
 */
public class GeneralInterceptor extends HandlerInterceptorAdapter {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession(false);
		if(session==null || session.getAttribute(CMSConstant.LOGIN_GENERAL)==null) {
			request.setAttribute("msg", "请登陆后再下一步操作...");
			request.setAttribute("user", new User());
			request.getRequestDispatcher("/WEB-INF/view/passport/login.jsp").forward(request, response);
		}
		return true;
	}
	
	
}
