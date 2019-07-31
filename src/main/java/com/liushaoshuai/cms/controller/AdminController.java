package com.liushaoshuai.cms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @ClassName: AdminController 
 * @Description: 管理员的控制器
 * @author:鄙人：刘某 
 * @date: 2019年7月19日 下午3:06:53
 */
@RequestMapping("admin")
@Controller
public class AdminController {
	
	
	@GetMapping({"/","","index"})
	public String toIndex() {
		return "admin/index";
	}
	
	
	
	
	
}
