package cn.bjtc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
		try {
			ApiParam param = findApiParam();
			ElementView view = (ElementView) ParamUtil.convertToView(param, ElementView.class);
			int count = elemService.countAllElements(view);
			List<?> privis = elemService.findAllElements(view);
			apiReturn.setCount(count);
			apiReturn.setData(privis);
		} catch (Exception e) {
			showServerError();
		}
		return apiReturn;
	}
	
	@RequestMapping(value="create", method=RequestMethod.POST)
	public ApiReturn execAddElement(){
		try {
			ApiParam param = findApiParam();
			ifParamDataIsEmpty(param);
			ElementView view = (ElementView) ParamUtil.convertToView(param, ElementView.class);
			elemService.saveElement(view);
		} catch (Exception e) {
			showServerError();
		}
		return apiReturn;
	}
	
	@RequestMapping(value="update", method=RequestMethod.POST)
	public ApiReturn execUpdateElement(){
		try {
			ApiParam param = findApiParam();
			ifParamDataIsEmpty(param);
			ElementView view = (ElementView) ParamUtil.convertToView(param, ElementView.class);
			elemService.updateElement(view);
		} catch (Exception e) {
			showServerError();
		}
		return apiReturn;
	}
	
	@RequestMapping(value="get", method=RequestMethod.POST)
	public ApiReturn execeditElement(){
		try {
			ApiParam param = findApiParam();
			ifParamDataIsEmpty(param);
			ElementView view = (ElementView) ParamUtil.convertToView(param, ElementView.class);
			List<?> privis = elemService.findAllElements(view);
			apiReturn.setData(privis);
		} catch (Exception e) {
			showServerError();
		}
		return apiReturn;
	}
	
	@Autowired
	private IElementService elemService;
}
