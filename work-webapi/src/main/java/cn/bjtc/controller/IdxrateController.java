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
import cn.bjtc.service.IIdxrateService;
import cn.bjtc.view.IdxrateView;

@RestController
@RequestMapping("idxrate")
public class IdxrateController extends BaseController {

	@RequestMapping(value="all", method=RequestMethod.POST)
	@SysLogger(content="查询参数实例信息",type=AspectType.CONTROLLER)
	public ApiReturn showIdxrate(){
		try {
			ApiParam param = findApiParam();
			IdxrateView view = (IdxrateView) ParamUtil.convertToView(param, IdxrateView.class);
			int count = IdxrateService.countAllIdxrate(view);
			List<?> Idxrates = IdxrateService.findAllIdxrate(view);
			apiReturn.setCount(count);
			apiReturn.setData(Idxrates);
		} catch (Exception e) {
			showServerError();
		}
		return apiReturn;
	}
	
	@RequestMapping(value="create", method=RequestMethod.POST)
	@SysLogger(content="新增参数实例信息",type=AspectType.CONTROLLER)
	public ApiReturn execAddIdxrate(){
		try {
			ApiParam param = findApiParam();
			ifParamDataIsEmpty(param);
			IdxrateView view = (IdxrateView) ParamUtil.convertToView(param, IdxrateView.class);
			IdxrateService.saveIdxrate(view);
		} catch (Exception e) {
			showServerError();
		}
		return apiReturn;
	}
	
	@RequestMapping(value="update", method=RequestMethod.POST)
	@SysLogger(content="编辑参数实例信息",type=AspectType.CONTROLLER)
	public ApiReturn execUpdateIdxrate(){
		try {
			ApiParam param = findApiParam();
			ifParamDataIsEmpty(param);
			IdxrateView view = (IdxrateView) ParamUtil.convertToView(param, IdxrateView.class);
			IdxrateService.updateIdxrate(view);
		} catch (Exception e) {
			showServerError();
		}
		return apiReturn;
	}
	
	@RequestMapping(value="get", method=RequestMethod.POST)
	public ApiReturn execeditIdxrate(){
		try {
			ApiParam param = findApiParam();
			ifParamDataIsEmpty(param);
			IdxrateView view = (IdxrateView) ParamUtil.convertToView(param, IdxrateView.class);
			List<?> Idxrates = IdxrateService.findAllIdxrate(view);
			apiReturn.setData(Idxrates);
		} catch (Exception e) {
			showServerError();
		}
		return apiReturn;
	}
	
	@Autowired
	private IIdxrateService IdxrateService;
}
