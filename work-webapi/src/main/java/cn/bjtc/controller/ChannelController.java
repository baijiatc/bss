package cn.bjtc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.bjtc.annotation.SysLogger;
import cn.bjtc.api.ApiManager;
import cn.bjtc.api.ApiParam;
import cn.bjtc.api.ApiReturn;
import cn.bjtc.api.util.ParamUtil;
import cn.bjtc.aspect.AspectType;
import cn.bjtc.service.IChannelService;
import cn.bjtc.view.ChannelView;

@RestController
@RequestMapping("chan")
public class ChannelController extends BaseController {

	@RequestMapping(value="all", method=RequestMethod.POST)
	@SysLogger(content="查询渠道信息",type=AspectType.CONTROLLER)
	public ApiReturn showChannels(){
		ApiParam param = ApiManager.getInstance().getParameters(request);
		ChannelView view = (ChannelView) ParamUtil.convertToView(param, ChannelView.class);
		int count = channelService.countAllChannels(view);
		List<?> privis = channelService.findAllChannels(view);
		apiReturn.setCount(count);
		apiReturn.setData(privis);
		return apiReturn;
	}
	
	@RequestMapping(value="create", method=RequestMethod.POST)
	@SysLogger(content="新增渠道",type=AspectType.CONTROLLER)
	public ApiReturn execAddChannel(){
		ApiParam param = ApiManager.getInstance().getParameters(request);
		ChannelView view = (ChannelView) ParamUtil.convertToView(param, ChannelView.class);
		channelService.saveChannel(view);
		return apiReturn;
	}
	
	@RequestMapping(value="update", method=RequestMethod.POST)
	@SysLogger(content="更新渠道信息",type=AspectType.CONTROLLER)
	public ApiReturn execUpdateChannel(){
		ApiParam param = ApiManager.getInstance().getParameters(request);
		ChannelView view = (ChannelView) ParamUtil.convertToView(param, ChannelView.class);
		channelService.updateChannel(view);
		return apiReturn;
	}
	
	@RequestMapping(value="get", method=RequestMethod.POST)
	public ApiReturn execeditChannel(){
		ApiParam param = ApiManager.getInstance().getParameters(request);
		ChannelView view = (ChannelView) ParamUtil.convertToView(param, ChannelView.class);
		List<?> privis = channelService.findAllChannels(view);
		apiReturn.setData(privis);
		return apiReturn;
	}
	
	@Autowired
	private IChannelService channelService;
}
