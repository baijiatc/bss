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
import cn.bjtc.service.IBrandService;
import cn.bjtc.view.BrandView;

@RestController
@RequestMapping("brand")
public class BrandController extends BaseController{

	@RequestMapping(value="all", method=RequestMethod.POST)
	@SysLogger(content="查询品牌信息",type=AspectType.CONTROLLER)
	public ApiReturn showBrands(){
		try {
			ApiParam param=findApiParam();
			BrandView  view=(BrandView) ParamUtil.convertToView(param, BrandView.class);
			int count=brandService.countAllBrands(view);
			List<?> brands=brandService.findAllBrands(view);
			apiReturn.setCount(count);
			apiReturn.setData(brands);
		} catch (Exception e) {
			showServerError();
		}
		return apiReturn;
	}
	
	@RequestMapping(value="create", method=RequestMethod.POST)
	@SysLogger(content="新增品牌信息",type=AspectType.CONTROLLER)
	public ApiReturn execAddBrand(){
		try {
			ApiParam param=findApiParam();
			ifParamDataIsEmpty(param);
			BrandView view=(BrandView) ParamUtil.convertToView(param, BrandView.class);
			brandService.saveBrand(view);
		} catch (Exception e) {
			showServerError();
		}
		return apiReturn;
	}
	
	@RequestMapping(value="update", method=RequestMethod.POST)
	@SysLogger(content="更新品牌信息",type=AspectType.CONTROLLER)
	public ApiReturn execUpdateBrand(){
		try {
			ApiParam param=findApiParam();
			ifParamDataIsEmpty(param);
			BrandView view=(BrandView) ParamUtil.convertToView(param, BrandView.class);
			brandService.updateBrand(view);
		} catch (Exception e) {
			showServerError();
		}
		return apiReturn;
	}
	
	@RequestMapping(value="get", method=RequestMethod.POST)
	 public ApiReturn execeditBrand(){
		try {
			ApiParam param=findApiParam();
			ifParamDataIsEmpty(param);
			BrandView view =(BrandView) ParamUtil.convertToView(param, BrandView.class);
			List<?> brands=brandService.findAllBrands(view);
			apiReturn.setData(brands);
		} catch (Exception e) {
			showServerError();
		}
		return apiReturn;
	}
	
	@Autowired
	private IBrandService brandService;
}
