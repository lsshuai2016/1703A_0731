package com.liushaoshuai.cms.controller;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.liushaoshuai.cms.domain.User;
import com.liushaoshuai.cms.service.UserService;
import com.liushaoshuai.cms.utils.CMSConstant;
import com.liushaoshuai.cms.utils.CMSRuntimeException;
import com.liushaoshuai.cms.vo.UserVO;
/**
 * 
 * @ClassName: PassportController 
 * @Description: 登陆或注册
 * @author:鄙人：刘某 
 * @date: 2019年7月17日 下午7:51:48
 */
@Controller
public class PassportController {
	
	@Resource
	private UserService service;
	
	/**
	 * @Title: toRegist 
	 * @Description: 去注册页面
	 * @param userVO
	 * @param model
	 * @return
	 * @return: String
	 */
	@GetMapping("toRegist")
	public String toRegist(UserVO userVO,Model model) {
		
		return "passport/regist";
	}
	
	/**
	 * @Title: regist 
	 * @Description: 用户注册
	 * @param userVO
	 * @param result
	 * @param model
	 * @param redirectAttributes
	 * @return
	 * @return: String
	 */
	@PostMapping("regist")
	public String regist(@Valid UserVO userVO, BindingResult result, Model model, RedirectAttributes redirectAttributes) {
		//注册信息不符合要求
		if(result.hasErrors()) {
			return "passport/regist";//注册失败，回到注册页面显示错误信息
		}
		
		try {
			service.insert(userVO);
			//注册成功，重定向到登陆页面，把用户名携带到登陆页面并填充
			redirectAttributes.addFlashAttribute("msg", "恭喜您注册成功,请登陆!");
			redirectAttributes.addFlashAttribute("username", userVO.getUsername());
			return "redirect:toLogin";
		} catch(CMSRuntimeException e) {
			//封装自定义异常信息
			model.addAttribute("msg", e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", "未知异常，请与管理员联系");
		}
		return "passport/regist";//注册失败，回到注册页面
	}
	
	/**
	 * @Title: toLogin 
	 * @Description: 去登陆
	 * @param user
	 * @return
	 * @return: String
	 */
	@GetMapping("toLogin")
	public String toLogin(User user) {
		return "passport/login";
	}
	
	@PostMapping("login")
	public String login(User user,HttpSession session,Model model) {
		try {
			//登陆并返回用户对象
			User u = service.login(user.getUsername(), user.getPassword());//登陆成功
			//根据登陆角色判断，进入对应角色页面
			if(u.getRole().equals(CMSConstant.RULE_ADMIN)) {//管理员
				session.setAttribute(CMSConstant.LOGIN_ADMIN, u);//存session
				return "redirect:"+CMSConstant.URL_ADMIN;
			}
			session.setAttribute(CMSConstant.LOGIN_GENERAL, u);//存session
			return "redirect:"+CMSConstant.URL_GENERAL;//普通用户的url
		} catch(CMSRuntimeException e) {
			//封装自定义异常信息
			model.addAttribute("msg", e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", "登陆失败，系统出现未知bug!");
		}
		return "passport/login";//登陆失败，回到登陆页面
	}
	
	/**
	 * @Title: logout 
	 * @Description:注销
	 * @return
	 * @return: String
	 */
	
	@GetMapping("logout")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		
		//清空session
		if(null!=session) {
			session.invalidate();	
		}
		return "redirect:toLogin";
		
		
	}
	
	
	
}
