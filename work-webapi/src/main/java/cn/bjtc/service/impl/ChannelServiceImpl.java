package cn.bjtc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.bjtc.dao.IChannelDAO;
import cn.bjtc.model.Channel;
import cn.bjtc.service.IChannelService;
import cn.bjtc.view.ChannelView;

@Service("channelService")
public class ChannelServiceImpl implements IChannelService {

	public int saveChannel(ChannelView view) {
		return channelDAO.saveChannel(view);
	}

	public int updateChannel(ChannelView view) {
		return channelDAO.updateChannel(view);
	}

	public List<Channel> findAllChannels(ChannelView view) {
		return channelDAO.findAllChannels(view);
	}

	public Integer countAllChannels(ChannelView view) {
		return channelDAO.countAllChannels(view);
	}
	
	@Autowired
	private IChannelDAO channelDAO;

}
