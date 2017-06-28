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
import cn.bjtc.service.IMoteventschemeService;
import cn.bjtc.view.MoteventschemeView;
@RestController
@RequestMapping("motevtsce")
public class MoteventschemeController extends BaseController{
	
	@RequestMapping(value="all", method=RequestMethod.POST)
	@SysLogger(content="查询事件方案",type=AspectType.CONTROLLER)
	public ApiReturn showMoteventscheme(){
		try {
			ApiParam param=findApiParam();
			MoteventschemeView view=(MoteventschemeView) ParamUtil.convertToView(param, MoteventschemeView.class);
			int count=moteventschemeService.countAllMoteventscheme(view);
			List<?> Moteventscheme=moteventschemeService.findAllMoteventscheme(view);
			apiReturn.setCount(count);
			apiReturn.setData(Moteventscheme);
		} catch (Exception e) {
			showServerError();
		}
		return apiReturn;
	}
	
	@RequestMapping(value="create", method=RequestMethod.POST)
	@SysLogger(content="新增事件方案",type=AspectType.CONTROLLER)
	public ApiReturn execAddMoteventscheme(){
		try {
			ApiParam param=findApiParam();
			ifParamDataIsEmpty(param);
			MoteventschemeView view=(MoteventschemeView) ParamUtil.convertToView(param, MoteventschemeView.class);
			moteventschemeService.saveMoteventscheme(view);
		} catch (Exception e) {
			showServerError();
		}
		return apiReturn;
	}
	
	@RequestMapping(value="delete", method=RequestMethod.POST)
	@SysLogger(content="删除事件方案",type=AspectType.CONTROLLER)
	public ApiReturn execDelMoteventscheme(){
		try {
			ApiParam param=findApiParam();
			ifParamDataIsEmpty(param);
			Integer id = Integer.parseInt(String.valueOf(param.getData().get(0).get("id")));
			moteventschemeService.deleteMoteventscheme(id);
		} catch (Exception e) {
			showServerError();
		}
		return apiReturn;
	}
    
	@Autowired
	private IMoteventschemeService moteventschemeService;
}
