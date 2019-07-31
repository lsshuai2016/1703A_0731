package com.liushaoshuai.cms.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.liushaoshuai.cms.dao.CommentMapper;
import com.liushaoshuai.cms.domain.Comment;
import com.liushaoshuai.cms.service.CommentService;
@Service
public class CommentServiceImpl implements CommentService {
	
	@Resource
	private CommentMapper commentMapper;
	
	@Override
	public int insert(Comment comment) {
		
		return commentMapper.insert(comment);
	}

	@Override
	public List<Map> selects(Integer articleId) {
		
		return commentMapper.selects(articleId);
	}

}
