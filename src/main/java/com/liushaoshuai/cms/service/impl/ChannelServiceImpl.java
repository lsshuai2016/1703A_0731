package com.liushaoshuai.cms.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.liushaoshuai.cms.dao.ChannelMapper;
import com.liushaoshuai.cms.service.ChannelService;
@Service
public class ChannelServiceImpl implements ChannelService {

	@Resource
	private ChannelMapper mapper;
	
	@Override
	public List<Map> selectChannels() {
		return mapper.selectChannels();
	}

	@Override
	public List<Map> selectCategorys(Integer channelId) {
		return mapper.selectCategorys(channelId);
	}

}
