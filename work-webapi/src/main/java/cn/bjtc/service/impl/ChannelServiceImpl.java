package cn.bjtc.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
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

	public List<ChannelView> findAllChannels(ChannelView view) {
		List<Channel> chans = channelDAO.findAllChannels(view);
		if(chans == null){
			return new ArrayList<ChannelView>(0);
		}
		List<ChannelView> views = new ArrayList<ChannelView>(chans.size());
		for(Channel chan : chans){
			ChannelView chanView = new ChannelView();
			BeanUtils.copyProperties(chan, chanView);
			views.add(chanView);
		}
		return views;
	}

	public Integer countAllChannels(ChannelView view) {
		return channelDAO.countAllChannels(view);
	}
	
	@Autowired
	private IChannelDAO channelDAO;

}
