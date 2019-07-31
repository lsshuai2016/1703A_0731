package com.liushaoshuai.cms.controller;

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
import org.springframework.web.bind.annotation.ResponseBody;
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
public class ArticlePicController {
	
	@Resource
	private ArticlePicService service;
	Gson gson = new Gson();
	
	@GetMapping("publishPic")
	public String publishPic() {
		return "my/article/publishpic";
	}
	
	@PostMapping("publishpic")
	public String publishpic(MultipartFile[] files, String[] picContents, ArticlePic articlePic) {
		String path = "e:/pic/";
		
		List<ArticlePicVO> list = new ArrayList<ArticlePicVO>();
		if(files!=null && files.length>0) {
			for(int i = 0 ; i < files.length ; i++) {
				ArticlePicVO vo = new ArticlePicVO();
				String oldFilename = files[i].getOriginalFilename();
				String filename = UUID.randomUUID()+oldFilename.substring(oldFilename.lastIndexOf("."));
				File f = new File(path+filename);
				try {
					files[i].transferTo(f);
					vo.setId(i);
					vo.setContent(picContents[i]);
					vo.setUrl(filename);
					list.add(vo);
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		articlePic.setContent(gson.toJson(list));
		service.insert(articlePic);
		return "redirect:/my";
		
	}
	
	@GetMapping("select")
	public String select(Integer id,Model model) {
		Map map = service.select(id);
		String str = (String) map.get("content");
		JsonElement jsonElement = new JsonParser().parse(str);
		JsonArray jsonArray = jsonElement.getAsJsonArray();
		List<ArticlePicVO> list = new ArrayList<>(); 
		for(JsonElement element : jsonArray) {
			ArticlePicVO articlePic = new ArticlePicVO();
			ArticlePicVO vo = gson.fromJson(element, ArticlePicVO.class);
			articlePic.setContent(vo.getContent());
			articlePic.setUrl(vo.getUrl());
			list.add(articlePic);
		}
		
		model.addAttribute("title", map.get("title"));
		model.addAttribute("pics", list);
		return "/my/article/pics";
	}
	
	
}
