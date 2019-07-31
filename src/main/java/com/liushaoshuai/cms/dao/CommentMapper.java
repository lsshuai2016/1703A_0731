package com.liushaoshuai.cms.dao;

import java.util.List;
import java.util.Map;

import com.liushaoshuai.cms.domain.Comment;
/**
 * @ClassName: CommentMapper 
 * @Description: 评论
 * @author:鄙人：刘某 
 * @date: 2019年7月28日 下午7:26:42
 */
public interface CommentMapper {
	
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
