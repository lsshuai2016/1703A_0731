package com.liushaoshuai.cms.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.liushaoshuai.cms.dao.UserMapper;
import com.liushaoshuai.cms.domain.User;
import com.liushaoshuai.cms.service.UserService;
import com.liushaoshuai.cms.utils.CMSConstant;
import com.liushaoshuai.cms.utils.CMSRuntimeException;
import com.liushaoshuai.cms.utils.Md5Util;
import com.liushaoshuai.cms.vo.UserVO;
import com.yangchunbo.common.utils.AssertUtil;
@Service
public class UserServiceImpl implements UserService {
	
	@Resource
	private UserMapper mapper;
	
	@Override
	public boolean insert(UserVO userVO) {
		//具体业务
		//1两次密码是否相同
		if(!userVO.getPassword().equals(userVO.getRepassword())) {
			throw new CMSRuntimeException("两次密码不一致");
		}
		//校验用户名是否唯一
		User user = mapper.selectByUsername(userVO.getUsername());
		if(user!=null) {
			throw new CMSRuntimeException("用户名已经存在");
		}
		userVO.setLocked(CMSConstant.USER_STATUS_UNLOCKED);//默认账户正常，1：禁用
		userVO.setRole(CMSConstant.RULE_GENERAL);//默认注册账户为普通用户  1：为管理员
		//如果用户昵称为空，则默认为用户名
		if(userVO.getNickname()==null) {
			userVO.setNickname(userVO.getUsername());
		}
		//加密
		userVO.setPassword(Md5Util.md5Encoding(userVO.getPassword()));
		
		return mapper.insert(userVO)>0;
	}

	@Override
	public User selectByUsername(String username) {
		User user = mapper.selectByUsername(username);
		return user;
	}

	@Override
	public User login(String username, String password) {
		AssertUtil.hasText(username, "用户名不能为空");
		AssertUtil.hasText(password, "密码不能为空");
		
		//用登录名找对象.
		User user = mapper.selectByUsername(username);
		
		AssertUtil.isNotNull(user, "用户名不存在");
		
		AssertUtil.isTrue(user.getLocked()==0, "账号被禁用");
		
		AssertUtil.isTrue(user.getPassword().equals(Md5Util.md5Encoding(password)), "密码错误!");
	 
		return user;
	}

	@Override
	public List<Map> selects(Map map) {
		//只查询普通注册用户
		map.put("RULE_GENERAL", CMSConstant.RULE_GENERAL);
		return mapper.selects(map);
	}

	@Override
	public int updateLocked(Integer id, Integer locked) {
		
		return mapper.updateLocked(id, locked);
	}

}
