package cn.bjtc.service;

import java.util.List;

import cn.bjtc.view.ChannelView;

public interface IChannelService {

	public int saveChannel(ChannelView view);
	public int updateChannel(ChannelView view);
	public List<ChannelView> findAllChannels(ChannelView view);
	public Integer countAllChannels(ChannelView view);
}
