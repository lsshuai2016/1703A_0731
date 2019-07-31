package com.liushaoshuai.cms.service;

import java.util.List;
import java.util.Map;

import com.liushaoshuai.cms.domain.User;
import com.liushaoshuai.cms.vo.UserVO;

public interface UserService {
	
	/**
	 * @Title: selects 
	 * @Description: 根据条件查询用户信息
	 * @param map
	 * @return
	 * @return: List<Map>
	 */
	List<Map> selects(Map map);
	
	/**
	 * @Title: updateLocked 
	 * @Description: 改变用户的登陆状态，禁用或启用
	 * @param id
	 * @param locked
	 * @return
	 * @return: int
	 */
	int updateLocked(Integer id,Integer locked);
	
	/**
	 * @Title: insert 
	 * @Description: 用户注册
	 * @param user
	 * @return
	 * @return: boolean
	 */
	boolean insert(UserVO userVO);
	
	/**
	 * @Title: selectByUsername 
	 * @Description: 根据用户名查询对象
	 * @param username
	 * @return
	 * @return: User
	 */
	User selectByUsername(String username);
	
	/**
	 * 
	 * @Title: login 
	 * @Description: 登陆
	 * @param username
	 * @param password
	 * @return
	 * @return: User
	 */
	User login(String username,String password);
	
}
