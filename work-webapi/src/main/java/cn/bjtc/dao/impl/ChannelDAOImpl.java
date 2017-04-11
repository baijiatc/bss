package cn.bjtc.dao.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import cn.bjtc.dao.IChannelDAO;
import cn.bjtc.dao.mybatis.MyBatisDAO;
import cn.bjtc.model.Channel;
import cn.bjtc.view.ChannelView;

@Component("channelDAO")
public class ChannelDAOImpl extends MyBatisDAO<Channel, Integer> implements
		IChannelDAO {

	public int saveChannel(ChannelView view) {
		Channel channel = new Channel();
		BeanUtils.copyProperties(view, channel);
		return super.save("saveChannel", channel);
	}

	public int updateChannel(ChannelView view) {
		return super.update("updateChannel", view);
	}

	public List<Channel> findAllChannels(ChannelView view) {
		return super.findByParam("findAllChannels", view);
	}

	public Integer countAllChannels(ChannelView view) {
		return super.countByParam("countAllChannels", view);
	}

}
