package cn.bjtc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.bjtc.api.ApiManager;
import cn.bjtc.api.ApiParam;
import cn.bjtc.api.ApiReturn;
import cn.bjtc.api.util.ParamUtil;
import cn.bjtc.service.IProdService;
import cn.bjtc.view.ProductView;

@RestController
@RequestMapping("prod")
public class ProdController extends BaseController{

	@RequestMapping(value="all", method=RequestMethod.POST)
	public ApiReturn showProds(){
		ApiParam param=ApiManager.getInstance().getParameters(request);
		ProductView view=(ProductView) ParamUtil.convertToView(param, ProductView.class);
		int count=prodService.countAllProds(view);
		List<?> prods=prodService.findAllProds(view);
		apiReturn.setCount(count);
		apiReturn.setData(prods);
		return apiReturn;
	}
	
	@RequestMapping(value="create", method=RequestMethod.POST)
	public ApiReturn execAddProd(){
		ApiParam param=ApiManager.getInstance().getParameters(request);
		ProductView view=(ProductView) ParamUtil.convertToView(param, ProductView.class);
		prodService.saveProd(view);
		return apiReturn;	
	}
	
	@RequestMapping(value="update", method=RequestMethod.POST)
	public ApiReturn execUpdateProd(){
		ApiParam param=ApiManager.getInstance().getParameters(request);
		ProductView view=(ProductView) ParamUtil.convertToView(param, ProductView.class);
		prodService.updateProd(view);
		return apiReturn;
	}
	
	
	@RequestMapping(value="get", method=RequestMethod.POST)
	public ApiReturn execeditProd(){
		ApiParam  param=ApiManager.getInstance().getParameters(request);
		ProductView view=(ProductView) ParamUtil.convertToView(param, ProductView.class);
		List<?> prods=prodService.findAllProds(view);
		apiReturn.setData(prods);
		return apiReturn;
	}

	@Autowired
	private IProdService prodService;
}
