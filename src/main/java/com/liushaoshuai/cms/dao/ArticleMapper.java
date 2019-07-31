package com.liushaoshuai.cms.dao;

import java.util.List;
import java.util.Map;

import com.liushaoshuai.cms.domain.Article;

public interface ArticleMapper {
	
	/**
	 * @Title: update 
	 * @Description: 更新文章
	 * @param article
	 * @return
	 * @return: int
	 */
	int update(Article article);
	
	/**
	 * @Title: insert 
	 * @Description: 发布文章
	 * @param article
	 * @return
	 * @return: int
	 */
	int insert(Article article);
	
	/**
	 * @Title: get 
	 * @Description: 文章详情
	 * @param id
	 * @return
	 * @return: Map
	 */
	Map get(Integer id);
	
	/**
	 * @Title: getTitles 
	 * @Description: 按照条件查询所有文章的标题
	 * @param article
	 * @return
	 * @return: List<Map>
	 */
	List<Map> getTitles(Article article);
	
	
	
}
