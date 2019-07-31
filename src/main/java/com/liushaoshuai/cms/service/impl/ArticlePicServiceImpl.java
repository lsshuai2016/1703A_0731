package com.liushaoshuai.cms.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.liushaoshuai.cms.dao.ArticlePicMapper;
import com.liushaoshuai.cms.domain.ArticlePic;
import com.liushaoshuai.cms.service.ArticlePicService;
@Service
public class ArticlePicServiceImpl implements ArticlePicService {
	
	@Resource
	private ArticlePicMapper mapper;
	
	@Override
	public int insert(ArticlePic articlePic) {
		
		return mapper.insert(articlePic);
	}

	@Override
	public Map select(Integer id) {
		
		return mapper.select(id);
	}

	@Override
	public List<Map> selects() {
		
		return mapper.selects();
	}

}
