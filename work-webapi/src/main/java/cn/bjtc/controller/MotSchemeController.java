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
import cn.bjtc.service.IMotSchemeService;
import cn.bjtc.view.MotSchemeView;
 

@RestController
@RequestMapping("scheme")
public class MotSchemeController  extends BaseController {

	@RequestMapping(value="all", method=RequestMethod.POST)
	@SysLogger(content="查询方案信息",type=AspectType.CONTROLLER)
	public ApiReturn showMotScheme(){
   try {
		ApiParam param=findApiParam();
		MotSchemeView  view=(MotSchemeView) ParamUtil.convertToView(param, MotSchemeView.class);
		   int count=motSchService.countAllMotScheme(view);
		   List<?> motSch=motSchService.findAllMotScheme(view);
		   apiReturn.setCount(count);
		   apiReturn.setData(motSch);
	} catch (Exception e) {
		e.printStackTrace();
		showServerError();
	}
	   return apiReturn;
	}
	
	@RequestMapping(value="create", method=RequestMethod.POST)
	@SysLogger(content="新增方案信息",type=AspectType.CONTROLLER)
	public ApiReturn execAddMotScheme(){
		try {
			ApiParam param=findApiParam();
			ifParamDataIsEmpty(param);
			MotSchemeView view=(MotSchemeView) ParamUtil.convertToView(param, MotSchemeView.class);
			motSchService.saveMotScheme(view);
		} catch (Exception e) {
			showServerError();
		}
		return apiReturn;
	}	
	
	@RequestMapping(value="update", method=RequestMethod.POST)
	@SysLogger(content="更新方案信息",type=AspectType.CONTROLLER)
	public ApiReturn execUpdateMotScheme(){
		try {
			ApiParam param=findApiParam();
			ifParamDataIsEmpty(param);
			MotSchemeView view=(MotSchemeView) ParamUtil.convertToView(param, MotSchemeView.class);
			motSchService.updateMotScheme(view);
		} catch (Exception e) {
			showServerError();
		}
		return apiReturn;
	}

    @RequestMapping(value="get", method=RequestMethod.POST)
	public ApiReturn execeditMotScheme(){
    	try {
			ApiParam param=findApiParam();
			ifParamDataIsEmpty(param);
			MotSchemeView view=(MotSchemeView) ParamUtil.convertToView(param, MotSchemeView.class);
			List<?> motSche=motSchService.findAllMotScheme(view);
			apiReturn.setData(motSche);
		} catch (Exception e) {
			showServerError();
		}
        return apiReturn;
    }
    
//    @RequestMapping(value="findbyname", method=RequestMethod.POST)
//	@SysLogger(content="根据名字查询方案信息",type=AspectType.CONTROLLER)
//	public ApiReturn execFindByNameMotScheme(){
//		try {
//			ApiParam param=findApiParam();
//			ifParamDataIsEmpty(param);
//			String  schmname = (String) param.getData().get(0).get("schmname");
//			List<?> motSch=motSchService.fAllMScByName(schmname);
//			   apiReturn.setData(motSch);
//		} catch (Exception e) {
//			showServerError();
//		}
//		return apiReturn;
//	}
	
	@Autowired
	private IMotSchemeService motSchService;
}
