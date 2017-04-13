package cn.bjtc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.bjtc.api.ApiManager;
import cn.bjtc.api.ApiParam;
import cn.bjtc.api.ApiReturn;
import cn.bjtc.api.util.ParamUtil;
import cn.bjtc.service.IIdxrateService;
import cn.bjtc.view.IdxrateView;

@RestController
@RequestMapping("idxrate")
public class IdxrateController extends BaseController {

	@RequestMapping(value="all", method=RequestMethod.POST)
	public ApiReturn showIdxrate(){
		ApiParam param = ApiManager.getInstance().getParameters(request);
		IdxrateView view = (IdxrateView) ParamUtil.convertToView(param, IdxrateView.class);
		int count = IdxrateService.countAllIdxrate(view);
		List<?> Idxrates = IdxrateService.findAllIdxrate(view);
		apiReturn.setCount(count);
		apiReturn.setData(Idxrates);
		return apiReturn;
	}
	
	@RequestMapping(value="create", method=RequestMethod.POST)
	public ApiReturn execAddIdxrate(){
		ApiParam param = ApiManager.getInstance().getParameters(request);
		IdxrateView view = (IdxrateView) ParamUtil.convertToView(param, IdxrateView.class);
		IdxrateService.saveIdxrate(view);
		return apiReturn;
	}
	
	@RequestMapping(value="update", method=RequestMethod.POST)
	public ApiReturn execUpdateIdxrate(){
		ApiParam param = ApiManager.getInstance().getParameters(request);
		IdxrateView view = (IdxrateView) ParamUtil.convertToView(param, IdxrateView.class);
		IdxrateService.updateIdxrate(view);
		return apiReturn;
	}
	
	@RequestMapping(value="get", method=RequestMethod.POST)
	public ApiReturn execeditIdxrate(){
		ApiParam param = ApiManager.getInstance().getParameters(request);
		IdxrateView view = (IdxrateView) ParamUtil.convertToView(param, IdxrateView.class);
		List<?> Idxrates = IdxrateService.findAllIdxrate(view);
		apiReturn.setData(Idxrates);
		return apiReturn;
	}
	
	@Autowired
	private IIdxrateService IdxrateService;
}
