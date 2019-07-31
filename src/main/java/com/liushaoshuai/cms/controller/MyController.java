package com.liushaoshuai.cms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @ClassName: MyController 
 * @Description: 个人中心
 * @author:鄙人：刘某 
 * @date: 2019年7月19日 下午3:08:40
 */
@Controller
public class MyController {
	
	@GetMapping("my")
	public String toIndex() {
		return "my/index";
	}
	
	
	
	
	
	
}
