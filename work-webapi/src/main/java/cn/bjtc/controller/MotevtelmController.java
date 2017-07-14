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
import cn.bjtc.service.IMotevtelmService;
import cn.bjtc.view.MotevtelmView;
@RestController
@RequestMapping("motevtelm")
public class MotevtelmController extends BaseController{
	
	@RequestMapping(value="all", method=RequestMethod.POST)
	@SysLogger(content="查询群体要素",type=AspectType.CONTROLLER)
	public ApiReturn showMotevtelm(){
		try {
			ApiParam param=findApiParam();
			MotevtelmView view=(MotevtelmView) ParamUtil.convertToView(param, MotevtelmView.class);
			int count=motevtelmService.countAllMotevtelm(view);
			List<?> Motevtelm=motevtelmService.findAllMotevtelm(view);
			apiReturn.setCount(count);
			apiReturn.setData(Motevtelm);
		} catch (Exception e) {
			showServerError();
		}
		return apiReturn;
	}
	
	@RequestMapping(value="create", method=RequestMethod.POST)
	@SysLogger(content="新增群体要素",type=AspectType.CONTROLLER)
	public ApiReturn execAddMotevtelm(){
		try {
			ApiParam param=findApiParam();
			ifParamDataIsEmpty(param);
			MotevtelmView view=(MotevtelmView) ParamUtil.convertToView(param, MotevtelmView.class);
			motevtelmService.saveMotevtelm(view);
		} catch (Exception e) {
			showServerError();
		}
		return apiReturn;
	}
	
	@RequestMapping(value="get", method=RequestMethod.POST)
    public ApiReturn execeditMotevtelm(){
		try {
			ApiParam param=findApiParam();
			ifParamDataIsEmpty(param);
			MotevtelmView view=(MotevtelmView) ParamUtil.convertToView(param, MotevtelmView.class);
			List<?> Motevtelm=motevtelmService.findAllMotevtelm(view);
			apiReturn.setData(Motevtelm);
		} catch (Exception e) {
			showServerError();
		}
		return apiReturn;	
	}
	@RequestMapping(value="delete", method=RequestMethod.POST)
	@SysLogger(content="删除事件群体",type=AspectType.CONTROLLER)
	public ApiReturn execDelMotevtget(){
		try {
			ApiParam param=findApiParam();
			ifParamDataIsEmpty(param);
			Integer id = Integer.parseInt(String.valueOf(param.getData().get(0).get("id")));
			motevtelmService.deleteMotevtelm(id);
		} catch (Exception e) {
			showServerError();
		}
		return apiReturn;
	}
	
	@Autowired
	private IMotevtelmService motevtelmService;
}
