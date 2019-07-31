package com.liushaoshuai.cms.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.liushaoshuai.cms.dao.ArticleMapper;
import com.liushaoshuai.cms.domain.Article;
import com.liushaoshuai.cms.service.ArticleService;
@Service
public class ArticleServiceImpl implements ArticleService {

	@Resource
	private ArticleMapper mapper;
	
	@Override
	public int insert(Article article) {
		return mapper.insert(article);
	}

	@Override
	public Map get(Integer id) {
		return mapper.get(id);
	}

	@Override
	public List<Map> getTitles(Article article) {
		// TODO Auto-generated method stub
		return mapper.getTitles(article);
	}

	@Override
	public int update(Article article) {
		// TODO Auto-generated method stub
		return mapper.update(article);
	}

}
