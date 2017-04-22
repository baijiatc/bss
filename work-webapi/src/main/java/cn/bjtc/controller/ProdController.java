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
import cn.bjtc.service.IProdService;
import cn.bjtc.view.ProductView;

@RestController
@RequestMapping("prod")
public class ProdController extends BaseController{

	@RequestMapping(value="all", method=RequestMethod.POST)
	@SysLogger(content="查询产品信息",type=AspectType.CONTROLLER)
	public ApiReturn showProds(){
		try {
			ApiParam param=findApiParam();
			ProductView view=(ProductView) ParamUtil.convertToView(param, ProductView.class);
			int count=prodService.countAllProds(view);
			List<?> prods=prodService.findAllProds(view);
			apiReturn.setCount(count);
			apiReturn.setData(prods);
		} catch (Exception e) {
			showServerError();
		}
		return apiReturn;
	}
	
	@RequestMapping(value="create", method=RequestMethod.POST)
	@SysLogger(content="新增产品信息",type=AspectType.CONTROLLER)
	public ApiReturn execAddProd(){
		try {
			ApiParam param=findApiParam();
			ifParamDataIsEmpty(param);
			ProductView view=(ProductView) ParamUtil.convertToView(param, ProductView.class);
			prodService.saveProd(view);
		} catch (Exception e) {
			showServerError();
		}
		return apiReturn;	
	}
	
	@RequestMapping(value="update", method=RequestMethod.POST)
	@SysLogger(content="更新产品信息",type=AspectType.CONTROLLER)
	public ApiReturn execUpdateProd(){
		try {
			ApiParam param=findApiParam();
			ifParamDataIsEmpty(param);
			ProductView view=(ProductView) ParamUtil.convertToView(param, ProductView.class);
			prodService.updateProd(view);
		} catch (Exception e) {
			showServerError();
		}
		return apiReturn;
	}
	
	
	@RequestMapping(value="get", method=RequestMethod.POST)
	public ApiReturn execeditProd(){
		try {
			ApiParam  param=findApiParam();
			ifParamDataIsEmpty(param);
			ProductView view=(ProductView) ParamUtil.convertToView(param, ProductView.class);
			List<?> prods=prodService.findAllProds(view);
			apiReturn.setData(prods);
		} catch (Exception e) {
			showServerError();
		}
		return apiReturn;
	}

	@Autowired
	private IProdService prodService;
}
