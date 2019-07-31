package com.liushaoshuai.cms.dao;

import java.util.List;
import java.util.Map;

import com.liushaoshuai.cms.domain.ArticlePic;

public interface ArticlePicMapper {
	
	/**
	 * @Title: insert 
	 * @Description: 添加图片集
	 * @param articlePic
	 * @return
	 * @return: int
	 */
	int insert(ArticlePic articlePic);
	
	/**
	 * @Title: select 
	 * @Description: 根据id查询单个
	 * @param id
	 * @return
	 * @return: Map
	 */
	Map select(Integer id);
	
	/**
	 * @Title: selects 
	 * @Description: 查询所有
	 * @return
	 * @return: List<Map>
	 */
	List<Map> selects();
	
	
	
	
	
	
	
}
