package com.liushaoshuai.cms.service;

import java.util.List;
import java.util.Map;

import com.liushaoshuai.cms.domain.Comment;

public interface CommentService {
	
	/**
	 * @Title: insert 
	 * @Description: 增加评论
	 * @param comment
	 * @return
	 * @return: int
	 */
	int insert(Comment comment);
	
	/**
	 * @Title: selects 
	 * @Description: 根据id查询文章评论
	 * @param articleId
	 * @return
	 * @return: List<Map>
	 */
	List<Map> selects(Integer articleId);
	
	
	
	
}
