package cn.bjtc.service;

import java.util.List;

import cn.bjtc.model.Channel;
import cn.bjtc.view.ChannelView;

public interface IChannelService {

	public int saveChannel(ChannelView view);
	public int updateChannel(ChannelView view);
	public List<Channel> findAllChannels(ChannelView view);
	public Integer countAllChannels(ChannelView view);
}
