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
import cn.bjtc.service.IMotevtgetService;
import cn.bjtc.view.MotevtgetView;
@RestController
@RequestMapping("motevtget")
public class MotevtgetController extends BaseController{
	
	@RequestMapping(value="all", method=RequestMethod.POST)
	@SysLogger(content="查询事件群体",type=AspectType.CONTROLLER)
	public ApiReturn showMotevtget(){
		try {
			ApiParam param=findApiParam();
			MotevtgetView view=(MotevtgetView) ParamUtil.convertToView(param, MotevtgetView.class);
			int count=MotevtgetService.countAllMotevtget(view);
			List<?> Motevtget=MotevtgetService.findAllMotevtget(view);
			apiReturn.setCount(count);
			apiReturn.setData(Motevtget);
		} catch (Exception e) {
			e.printStackTrace();
			showServerError();
		}
		return apiReturn;
	}
	
	@RequestMapping(value="create", method=RequestMethod.POST)
	@SysLogger(content="新增事件群体",type=AspectType.CONTROLLER)
	public ApiReturn execAddMotevtget(){
//		try {
			ApiParam param=findApiParam();
			ifParamDataIsEmpty(param);
			MotevtgetView view=(MotevtgetView) ParamUtil.convertToView(param, MotevtgetView.class);
			MotevtgetService.saveMotevtget(view);
//		} catch (Exception e) {
//			showServerError();
//		}
		return apiReturn;
	}
	
	@RequestMapping(value="delete", method=RequestMethod.POST)
	@SysLogger(content="删除事件群体",type=AspectType.CONTROLLER)
	public ApiReturn execDelMotevtget(){
		try {
			ApiParam param=findApiParam();
			ifParamDataIsEmpty(param);
			Integer id = Integer.parseInt(String.valueOf(param.getData().get(0).get("id")));
			MotevtgetService.deleteMotevtget(id);
		} catch (Exception e) {
			showServerError();
		}
		return apiReturn;
	}
    
	@Autowired
	private IMotevtgetService MotevtgetService;
}
