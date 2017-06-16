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
import cn.bjtc.service.IMotidxService;
import cn.bjtc.view.MotidxView;

@RestController
@RequestMapping("motidx")
public class MotidxController extends BaseController{
	
	@RequestMapping(value="all", method=RequestMethod.POST)
	@SysLogger(content="查询MOT指标管理信息",type=AspectType.CONTROLLER)
	public ApiReturn showMotidx(){
		try {
			ApiParam param=findApiParam();
			MotidxView view=(MotidxView) ParamUtil.convertToView(param, MotidxView.class);
			int count=motidxService.countAllMotidx(view);
			List<?> Motidx=motidxService.findAllMotidx(view);
			apiReturn.setCount(count);
			apiReturn.setData(Motidx);
		} catch (Exception e) {
			showServerError();
		}
		return apiReturn;
	}
	
	@RequestMapping(value="create", method=RequestMethod.POST)
	@SysLogger(content="新增MOT指标管理信息",type=AspectType.CONTROLLER)
	public ApiReturn execAddMotidx(){
		try {
			ApiParam param=findApiParam();
			ifParamDataIsEmpty(param);
			MotidxView view=(MotidxView) ParamUtil.convertToView(param, MotidxView.class);
			motidxService.saveMotidx(view);
		} catch (Exception e) {
			showServerError();
		}
		return apiReturn;
	}
	
	@RequestMapping(value="update", method=RequestMethod.POST)
	@SysLogger(content="更新MOT指标管理信息",type=AspectType.CONTROLLER)
    public ApiReturn execUpdateMotidx(){
		try {
			ApiParam param=findApiParam();
			ifParamDataIsEmpty(param);
			MotidxView view=(MotidxView) ParamUtil.convertToView(param, MotidxView.class);
			motidxService.updateMotidx(view);
		} catch (Exception e) {
			showServerError();
		}
		return apiReturn;
	} 
    
	@RequestMapping(value="get", method=RequestMethod.POST)
    public ApiReturn execeditMotidx(){
		try {
			ApiParam param=findApiParam();
			ifParamDataIsEmpty(param);
			MotidxView view=(MotidxView) ParamUtil.convertToView(param, MotidxView.class);
			List<?> Motidx=motidxService.findAllMotidx(view);
			apiReturn.setData(Motidx);
		} catch (Exception e) {
			showServerError();
		}
		return apiReturn;	
	}
    
	@Autowired
	private IMotidxService motidxService;
}
