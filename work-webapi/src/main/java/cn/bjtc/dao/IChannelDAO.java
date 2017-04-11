package cn.bjtc.dao;

import java.util.List;

import cn.bjtc.model.Channel;
import cn.bjtc.view.ChannelView;

public interface IChannelDAO {

	public int saveChannel(ChannelView view);
	public int updateChannel(ChannelView view);
	public List<Channel> findAllChannels(ChannelView view);
	public Integer countAllChannels(ChannelView view);
}
