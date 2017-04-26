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
import cn.bjtc.service.IActruleService;
import cn.bjtc.view.ActruleView;

@RestController
@RequestMapping("actrule")
public class ActruleController extends BaseController{
	
	@RequestMapping(value="all", method=RequestMethod.POST)
	@SysLogger(content="查询活动规则信息",type=AspectType.CONTROLLER)
	public ApiReturn showActrules(){
		try {
			ApiParam param=findApiParam();
			ActruleView view=(ActruleView) ParamUtil.convertToView(param, ActruleView.class);
			int count=actruleService.countAllActrules(view);
			List<?> actrules=actruleService.findAllActrules(view);
			apiReturn.setCount(count);
			apiReturn.setData(actrules);
		} catch (Exception e) {
			showServerError();
		}
		return apiReturn;
	}
	
	@RequestMapping(value="create", method=RequestMethod.POST)
	@SysLogger(content="新增活动规则信息",type=AspectType.CONTROLLER)
	public ApiReturn execAddActrule(){
		try {
			ApiParam param=findApiParam();
			ifParamDataIsEmpty(param);
			ActruleView view=(ActruleView) ParamUtil.convertToView(param, ActruleView.class);
			actruleService.saveActrule(view);
		} catch (Exception e) {
			showServerError();
		}
		return apiReturn;
	}
	
	@RequestMapping(value="update", method=RequestMethod.POST)
	@SysLogger(content="更新活动规则信息",type=AspectType.CONTROLLER)
    public ApiReturn execUpdateActrule(){
		try {
			ApiParam param=findApiParam();
			ifParamDataIsEmpty(param);
			ActruleView view=(ActruleView) ParamUtil.convertToView(param, ActruleView.class);
			actruleService.updateActrule(view);
		} catch (Exception e) {
			showServerError();
		}
		return apiReturn;
	} 
    
	@RequestMapping(value="get", method=RequestMethod.POST)
    public ApiReturn execeditActrule(){
		try {
			ApiParam param=findApiParam();
			ifParamDataIsEmpty(param);
			ActruleView view=(ActruleView) ParamUtil.convertToView(param, ActruleView.class);
			List<?> actrules=actruleService.findAllActrules(view);
			apiReturn.setData(actrules);
		} catch (Exception e) {
			showServerError();
		}
		return apiReturn;	
	}
    
	@Autowired
	private IActruleService actruleService;
}
