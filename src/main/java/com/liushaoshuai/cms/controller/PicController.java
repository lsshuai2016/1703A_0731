/*package com.liushaoshuai.cms.controller;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.liushaoshuai.cms.domain.ArticlePic;
import com.liushaoshuai.cms.service.ArticlePicService;
import com.liushaoshuai.cms.vo.ArticlePicVO;
@RequestMapping("pics")
@Controller
public class PicController {
	
	@Resource
	private ArticlePicService service;
	//可以把java转json对象，  json转java对象
	Gson gson = new Gson();
	
	@GetMapping("publishPic")
	public String publishPic() {
		
		return "my/article/publishpic";
	}
	
	*//**
	 * @Title: select 
	 * @Description: 单个查询
	 * @param model
	 * @param id
	 * @return
	 * @return: String
	 *//*
	@GetMapping("select")
	public String select(Model model ,Integer id) {
		Map map = service.select(id);
		
		String str = (String) map.get("content");
		JsonElement jsonElement = new JsonParser().parse(str);
		JsonArray jsonArray = jsonElement.getAsJsonArray();
		List<ArticlePicVO> list = new ArrayList<>();
		for(JsonElement element : jsonArray) {
			ArticlePicVO vo = gson.fromJson(element, ArticlePicVO.class);
			list.add(vo);
		}
		model.addAttribute("pics", list);
		//风景图标题
		model.addAttribute("title", map.get("title"));
		return "my/article/pics";
		
	}
	
	*//**
	 * @Title: selects 
	 * @Description: 查询所有
	 * @param model
	 * @return
	 * @return: String
	 *//*
	@GetMapping("selects")
	public String selects(Model model) {
		List<Map> pics = service.selects();
		List<ArticlePicVO> list = new ArrayList<>();
		for(Map map : pics) {
			String str = (String) map.get("content");
			JsonElement jsonElement = new JsonParser().parse(str);
			JsonArray jsonArray = jsonElement.getAsJsonArray();
			for(JsonElement element : jsonArray) {
				ArticlePicVO vo = gson.fromJson(element, ArticlePicVO.class);
				vo.setId((Integer)map.get("id"));
				list.add(vo);
				break;//只获取图片集的第一个，因为首页只显示一个
			}
		}
		model.addAttribute("pics", list);
		return "my/article/pics";
	}
	
	
	@PostMapping("publishpic")
	public String publishpic(MultipartFile[] files, String[] picContents,ArticlePic articlePic) {
		String path = "e:/pic/";
		
		List<ArticlePicVO> list = new ArrayList<ArticlePicVO>();
		//判断file数组不能为空并且长度大于0
		if(files!=null && files.length>0) {
			for(int i = 0 ; i < files.length ; i++) {
				//上传的文件原始名称
				String oldFilename = files[i].getOriginalFilename();
				String filename = UUID.randomUUID()+oldFilename.substring(oldFilename.lastIndexOf("."));
				File f = new File(path+filename);
				ArticlePicVO vo = new ArticlePicVO();
				vo.setId(i);
				vo.setContent(picContents[i]);
				vo.setUrl(filename);
				list.add(vo);
				try {
					files[i].transferTo(f);
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		String json = gson.toJson(list);
		articlePic.setContent(json);
		service.insert(articlePic);
		return "redirect:/my/";
		
	}
	
	
}
*/