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
import cn.bjtc.service.ISkuService;
import cn.bjtc.view.SkuView;

@RestController
@RequestMapping("sku")
public class SkuController extends BaseController {

	@RequestMapping(value="all", method=RequestMethod.POST)
	@SysLogger(content="查询sku信息",type=AspectType.CONTROLLER)
	public ApiReturn showActSku(){
		 try {
			ApiParam param=findApiParam();
			 SkuView view=(SkuView) ParamUtil.convertToView(param, SkuView.class);
			 int count=skuService.countAllSkus(view);
			 List<?> sku=skuService.findAllSkus(view);
			 apiReturn.setCount(count);
			 apiReturn.setData(sku);
		} catch (Exception e) {
			showServerError();
		}
		 return apiReturn; 
	}
	
	@RequestMapping(value="create", method=RequestMethod.POST)
	@SysLogger(content="新增sku信息",type=AspectType.CONTROLLER)
	public ApiReturn execAddSku(){
		try {
			ApiParam param=findApiParam();
			ifParamDataIsEmpty(param);
			SkuView view=(SkuView) ParamUtil.convertToView(param, SkuView.class);
			skuService.saveSku(view);
		} catch (Exception e) {
			showServerError();
		}
		return apiReturn;
	}
	
	@RequestMapping(value="update", method=RequestMethod.POST)
	@SysLogger(content="编辑sku信息",type=AspectType.CONTROLLER)
	public ApiReturn execUpdateSku(){
		try {
			ApiParam param=findApiParam();
			ifParamDataIsEmpty(param);
			SkuView view=(SkuView) ParamUtil.convertToView(param, SkuView.class);
			skuService.updateSku(view);
		} catch (Exception e) {
			showServerError();
		}
		return apiReturn;
	}
	
	@RequestMapping(value="get", method=RequestMethod.POST)
	public ApiReturn execeditSku(){
		try {
			ApiParam param=findApiParam();
			ifParamDataIsEmpty(param);
			SkuView view=(SkuView) ParamUtil.convertToView(param, SkuView.class);
			List<?> Sku=skuService.findAllSkus(view);
			apiReturn.setData(Sku);
		} catch (Exception e) {
			showServerError();
		}
		return apiReturn;
	}
	
	@Autowired
	private ISkuService skuService;
}
