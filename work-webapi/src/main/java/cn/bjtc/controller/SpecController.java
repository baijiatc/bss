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
import cn.bjtc.service.ISpecService;
import cn.bjtc.view.SpecView;

@RestController
@RequestMapping("spec")
public class SpecController extends BaseController {

	@RequestMapping(value="all", method=RequestMethod.POST)
	public ApiReturn showActSpec(){
		 ApiParam param=ApiManager.getInstance().getParameters(request);
		 SpecView view=(SpecView) ParamUtil.convertToView(param, SpecView.class);
		 int count=specService.countAllSpecs(view);
		 List<?> Spec=specService.findAllSpecs(view);
		 apiReturn.setCount(count);
		 apiReturn.setData(Spec);
		 return apiReturn; 
	}
	
	@RequestMapping(value="create", method=RequestMethod.POST)
	public ApiReturn execAddSpec(){
		ApiParam param=ApiManager.getInstance().getParameters(request);
		SpecView view=(SpecView) ParamUtil.convertToView(param, SpecView.class);
		specService.saveSpec(view);
		return apiReturn;
	}
	
	@RequestMapping(value="update", method=RequestMethod.POST)
	public ApiReturn execUpdateSpec(){
		ApiParam param=ApiManager.getInstance().getParameters(request);
		SpecView view=(SpecView) ParamUtil.convertToView(param, SpecView.class);
		specService.updateSpec(view);
		return apiReturn;
	}
	
	@RequestMapping(value="get", method=RequestMethod.POST)
	public ApiReturn execeditSpec(){
		ApiParam param=ApiManager.getInstance().getParameters(request);
		SpecView view=(SpecView) ParamUtil.convertToView(param, SpecView.class);
		List<?> Spec=specService.findAllSpecs(view);
		apiReturn.setData(Spec);
		return apiReturn;
	}
	
	@Autowired
	private ISpecService specService;
}
