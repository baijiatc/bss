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
import cn.bjtc.service.IElementService;
import cn.bjtc.view.ElementView;

@RestController
@RequestMapping("elem")
public class ElementController extends BaseController {

	@RequestMapping(value="all", method=RequestMethod.POST)
	public ApiReturn showElements(){
		ApiParam param = ApiManager.getInstance().getParameters(request);
		ElementView view = (ElementView) ParamUtil.convertToView(param, ElementView.class);
		int count = elemService.countAllElements(view);
		List<?> privis = elemService.findAllElements(view);
		apiReturn.setCount(count);
		apiReturn.setData(privis);
		return apiReturn;
	}
	
	@RequestMapping(value="create", method=RequestMethod.POST)
	public ApiReturn execAddElement(){
		ApiParam param = ApiManager.getInstance().getParameters(request);
		ElementView view = (ElementView) ParamUtil.convertToView(param, ElementView.class);
		elemService.saveElement(view);
		return apiReturn;
	}
	
	@RequestMapping(value="update", method=RequestMethod.POST)
	public ApiReturn execUpdateElement(){
		ApiParam param = ApiManager.getInstance().getParameters(request);
		ElementView view = (ElementView) ParamUtil.convertToView(param, ElementView.class);
		elemService.updateElement(view);
		return apiReturn;
	}
	
	@RequestMapping(value="get", method=RequestMethod.POST)
	public ApiReturn execeditElement(){
		ApiParam param = ApiManager.getInstance().getParameters(request);
		ElementView view = (ElementView) ParamUtil.convertToView(param, ElementView.class);
		List<?> privis = elemService.findAllElements(view);
		apiReturn.setData(privis);
		return apiReturn;
	}
	
	@Autowired
	private IElementService elemService;
}
