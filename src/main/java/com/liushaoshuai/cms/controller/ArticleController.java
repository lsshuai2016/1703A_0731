package com.liushaoshuai.cms.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liushaoshuai.cms.domain.Article;
import com.liushaoshuai.cms.domain.User;
import com.liushaoshuai.cms.service.ArticleService;
import com.liushaoshuai.cms.utils.CMSConstant;
import com.liushaoshuai.cms.utils.PageUtil;

/**
 * @ClassName: ArticleController 
 * @Description: 文章控制器
 * @author:鄙人：刘某 
 * @date: 2019年7月23日 下午3:59:22
 */
@RequestMapping("article")
@Controller
public class ArticleController {
	
	@Resource
	private ArticleService service ;
	
	/**
	 * @Title: update 
	 * @Description: 更新文章
	 * @param article
	 * @return
	 * @return: boolean
	 */
	@ResponseBody
	@PostMapping("update")
	public boolean update(Article article) {
		return service.update(article)>0;
	}
	
	/**
	 * @Title: get 
	 * @Description: 文章详情
	 * @param id
	 * @param model
	 * @return
	 * @return: String
	 */
	@GetMapping("get")
	public String get(Integer id,Model model) {
		Map map = service.get(id);
		model.addAttribute("map", map);
		return "my/article/articledetail";
	}
	
	/**
	 * @Title: getByAdmin 
	 * @Description: 文章详情
	 * @param id
	 * @param model
	 * @return
	 * @return: String
	 */
	@GetMapping("getByAdmin")
	public String getByAdmin(Integer id,Model model) {
		Map map = service.get(id);
		model.addAttribute("map", map);
		return "admin/article/articledetail";
	}
	
	/**
	 * @Title: getTitles 
	 * @Description: 查询所有文章标题(个人)
	 * @param page
	 * @param pageSize
	 * @param article
	 * @param model
	 * @param request
	 * @return
	 * @return: String
	 */
	@GetMapping("getTitles")
	public String getTitles(@RequestParam(defaultValue="1")Integer page,
							@RequestParam(defaultValue="2")Integer pageSize,
							Article article,
							Model model,
							HttpServletRequest request) {
		
		HttpSession session = request.getSession(false);
		
		//查询用户自己文章
		User user = (User) session.getAttribute(CMSConstant.LOGIN_GENERAL);
		article.setUserId(user.getId());
		
		PageHelper.startPage(page,pageSize);
		List<Map> titles = service.getTitles(article);
		PageInfo<Map> info = new PageInfo<>(titles);
		String pageInfo = PageUtil.page(page, info.getPages(), "/article/getTitles", pageSize);
		model.addAttribute("titles", titles);
		model.addAttribute("pageInfo", pageInfo);
		return "my/article/articletitles";
	}
	
	/**
	 * @Title: getTitlesByAdmin 
	 * @Description: 管理员查询
	 * @param article
	 * @param page
	 * @param pageSize
	 * @param model
	 * @param request
	 * @return
	 * @return: String
	 */
	@GetMapping("getTitlesByAdmin")
	public String getTitlesByAdmin(Article article,	
									@RequestParam(defaultValue="1")Integer page ,
									@RequestParam(defaultValue="5") Integer pageSize,
									Model model, 
									HttpServletRequest request) {

		HttpSession session = request.getSession(false);
				
		PageHelper.startPage(page, pageSize);
		
		List<Map> titles = service.getTitles(article);
		
		PageInfo<Map> info = new PageInfo<>(titles);
		String pageInfo = PageUtil.page(page, info.getPages(), "/article/getTitlesByAdmin", pageSize);
		
		model.addAttribute("titles", titles);
		model.addAttribute("pageInfo", pageInfo);
		model.addAttribute("article", article);//查询条件
		return "admin/article/articletitles";
	}
	
	/**
	 * @Title: toPublish 
	 * @Description: 去发布文章
	 * @return
	 * @return: String
	 */
	@GetMapping("toPublish")
	public String toPublish() {
		return "my/article/publish";
	}
	
	
	@ResponseBody
	@PostMapping("publish")
	public boolean publish(Article article,MultipartFile file,HttpServletRequest request) {
		
		if(!file.isEmpty()) {
			String path="e:/pic/";
			//上传的文件原始名称
			String oldFilename = file.getOriginalFilename();
			//为防止名称重复，文件改名为uuid
			String filename = UUID.randomUUID()+oldFilename.substring(oldFilename.lastIndexOf("."));
			File f = new File(path+filename);
			try {
				file.transferTo(f);
				article.setPicture(filename);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		article.setStatus(CMSConstant.ARTICLE_STATUS_NEW);
		article.setDeleted(0);
		article.setHot(0);
		article.setHits(0);
		HttpSession session = request.getSession(false);
		User user = (User)session.getAttribute(CMSConstant.LOGIN_GENERAL);
		
		article.setUserId(user.getId());
		return service.insert(article)>0;
		
		
		
	}
	
	
	
	
	
	
	
	
}
