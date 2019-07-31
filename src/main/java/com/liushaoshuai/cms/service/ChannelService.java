package com.liushaoshuai.cms.service;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: ChannelService 
 * @Description: 栏目和分类
 * @author:鄙人：刘某 
 * @date: 2019年7月23日 下午7:30:48
 */
public interface ChannelService {
	
	/**
	 * 
	 * @Title: selectChannels 
	 * @Description: 所有栏目
	 * @return
	 * @return: List<Map>
	 */
	List<Map> selectChannels();
	/**
	 * 
	 * @Title: selectCategorys 
	 * @Description: 根据栏目查询其下分类
	 * @param channelId
	 * @return
	 * @return: List<Map>
	 */
	List<Map> selectCategorys(Integer channelId);
	
	
	
	
	
	
}
