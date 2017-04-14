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
import cn.bjtc.service.IIdxparamService;
import cn.bjtc.view.IdxparamView;

@RestController
@RequestMapping("idxparam")
public class IdxparamController extends BaseController {

	@RequestMapping(value="all", method=RequestMethod.POST)
	public ApiReturn showIdxparam(){
		ApiParam param = ApiManager.getInstance().getParameters(request);
		IdxparamView view = (IdxparamView) ParamUtil.convertToView(param, IdxparamView.class);
		int count = idxparamService.countAllIdxparam(view);
		List<?> idxparams = idxparamService.findAllIdxparam(view);
		apiReturn.setCount(count);
		apiReturn.setData(idxparams);
		return apiReturn;
	}
	
	@RequestMapping(value="create", method=RequestMethod.POST)
	public ApiReturn execAddIdxparam(){
		ApiParam param = ApiManager.getInstance().getParameters(request);
		IdxparamView view = (IdxparamView) ParamUtil.convertToView(param, IdxparamView.class);
		idxparamService.saveIdxparam(view);
		return apiReturn;
	}
	
	@RequestMapping(value="update", method=RequestMethod.POST)
	public ApiReturn execUpdateIdxparam(){
		ApiParam param = ApiManager.getInstance().getParameters(request);
		IdxparamView view = (IdxparamView) ParamUtil.convertToView(param, IdxparamView.class);
		idxparamService.updateIdxparam(view);
		return apiReturn;
	}
	
	@RequestMapping(value="get", method=RequestMethod.POST)
	public ApiReturn execeditIdxparam(){
		ApiParam param = ApiManager.getInstance().getParameters(request);
		IdxparamView view = (IdxparamView) ParamUtil.convertToView(param, IdxparamView.class);
		List<?> idxparams = idxparamService.findAllIdxparam(view);
		apiReturn.setData(idxparams);
		return apiReturn;
	}
	
	@Autowired
	private IIdxparamService idxparamService;
}
