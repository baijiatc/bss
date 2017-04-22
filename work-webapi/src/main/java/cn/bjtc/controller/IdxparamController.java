package cn.bjtc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.bjtc.annotation.SysLogger;
import cn.bjtc.api.ApiParam;
import cn.bjtc.api.ApiReturn;
import cn.bjtc.api.util.ParamUtil;
import cn.bjtc.aspect.AspectType;
import cn.bjtc.service.IIdxparamService;
import cn.bjtc.view.IdxparamView;

@RestController
@RequestMapping("idxparam")
public class IdxparamController extends BaseController {

	@RequestMapping(value="all", method=RequestMethod.POST)
	@SysLogger(content="查询参数指标信息",type=AspectType.CONTROLLER)
	public ApiReturn showIdxparam(){
		try {
			ApiParam param = findApiParam();
			IdxparamView view = (IdxparamView) ParamUtil.convertToView(param, IdxparamView.class);
			int count = idxparamService.countAllIdxparam(view);
			List<?> idxparams = idxparamService.findAllIdxparam(view);
			apiReturn.setCount(count);
			apiReturn.setData(idxparams);
		} catch (Exception e) {
			showServerError();
		}
		return apiReturn;
	}
	
	@RequestMapping(value="create", method=RequestMethod.POST)
	@SysLogger(content="新增参数指标信息",type=AspectType.CONTROLLER)
	public ApiReturn execAddIdxparam(){
		try {
			ApiParam param = findApiParam();
			ifParamDataIsEmpty(param);
			IdxparamView view = (IdxparamView) ParamUtil.convertToView(param, IdxparamView.class);
			idxparamService.saveIdxparam(view);
		} catch (Exception e) {
			showServerError();
		}
		return apiReturn;
	}
	
	@RequestMapping(value="update", method=RequestMethod.POST)
	@SysLogger(content="编辑参数指标信息",type=AspectType.CONTROLLER)
	public ApiReturn execUpdateIdxparam(){
		try {
			ApiParam param = findApiParam();
			ifParamDataIsEmpty(param);
			IdxparamView view = (IdxparamView) ParamUtil.convertToView(param, IdxparamView.class);
			idxparamService.updateIdxparam(view);
		} catch (Exception e) {
			showServerError();
		}
		return apiReturn;
	}
	
	@RequestMapping(value="get", method=RequestMethod.POST)
	public ApiReturn execeditIdxparam(){
		try {
			ApiParam param = findApiParam();
			ifParamDataIsEmpty(param);
			IdxparamView view = (IdxparamView) ParamUtil.convertToView(param, IdxparamView.class);
			List<?> idxparams = idxparamService.findAllIdxparam(view);
			apiReturn.setData(idxparams);
		} catch (Exception e) {
			showServerError();
		}
		return apiReturn;
	}
	
	@Autowired
	private IIdxparamService idxparamService;
}
