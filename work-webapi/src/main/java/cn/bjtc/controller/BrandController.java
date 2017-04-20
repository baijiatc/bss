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
import cn.bjtc.service.IBrandService;
import cn.bjtc.view.BrandView;

@RestController
@RequestMapping("brand")
public class BrandController extends BaseController{

	@RequestMapping(value="all", method=RequestMethod.POST)
	public ApiReturn showBrands(){
		ApiParam param=ApiManager.getInstance().getParameters(request);
		BrandView  view=(BrandView) ParamUtil.convertToView(param, BrandView.class);
		int count=brandService.countAllBrands(view);
		List<?> brands=brandService.findAllBrands(view);
		apiReturn.setCount(count);
		apiReturn.setData(brands);
		return apiReturn;
	}
	
	@RequestMapping(value="create", method=RequestMethod.POST)
	public ApiReturn execAddBrand(){
		ApiParam param=ApiManager.getInstance().getParameters(request);
		BrandView view=(BrandView) ParamUtil.convertToView(param, BrandView.class);
		brandService.saveBrand(view);
		return apiReturn;
	}
	
	@RequestMapping(value="update", method=RequestMethod.POST)
	public ApiReturn execUpdateBrand(){
		ApiParam param=ApiManager.getInstance().getParameters(request);
		BrandView view=(BrandView) ParamUtil.convertToView(param, BrandView.class);
		brandService.updateBrand(view);
		return apiReturn;
	}
	
	@RequestMapping(value="get", method=RequestMethod.POST)
	 public ApiReturn execeditBrand(){
		ApiParam param=ApiManager.getInstance().getParameters(request);
		BrandView view =(BrandView) ParamUtil.convertToView(param, BrandView.class);
		List<?> brands=brandService.findAllBrands(view);
		apiReturn.setData(brands);
		return apiReturn;
	}
	
   
	
	
	
	
	
	@Autowired
	private IBrandService brandService;
	
	
}
