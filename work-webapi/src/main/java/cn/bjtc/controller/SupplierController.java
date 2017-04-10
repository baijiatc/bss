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
import cn.bjtc.service.ISupplierService;
import cn.bjtc.view.SupplierView;

@RestController
@RequestMapping("supplier")
public class SupplierController extends BaseController {

	@RequestMapping(value="all", method=RequestMethod.POST)
	public ApiReturn showSupplier(){
		ApiParam param = ApiManager.getInstance().getParameters(request);
		SupplierView view = (SupplierView) ParamUtil.convertToView(param, SupplierView.class);
		int count = supplierService.countAllSupplier(view);
		List<?> supplier = supplierService.findAllSupplier(view);
		apiReturn.setCount(count);
		apiReturn.setData(supplier);
		return apiReturn;
	}
	
	@RequestMapping(value="create", method=RequestMethod.POST)
	public ApiReturn execAddSupplier(){
		ApiParam param = ApiManager.getInstance().getParameters(request);
		SupplierView view = (SupplierView) ParamUtil.convertToView(param, SupplierView.class);
		supplierService.saveSupplier(view);
		return apiReturn;
	}
	
	@RequestMapping(value="update", method=RequestMethod.POST)
	public ApiReturn execUpdateSupplier(){
		ApiParam param = ApiManager.getInstance().getParameters(request);
		SupplierView view = (SupplierView) ParamUtil.convertToView(param, SupplierView.class);
		supplierService.updateSupplier(view);
		return apiReturn;
	}
	
	@RequestMapping(value="get", method=RequestMethod.POST)
	public ApiReturn execeditSupplier(){
		ApiParam param = ApiManager.getInstance().getParameters(request);
		SupplierView view = (SupplierView) ParamUtil.convertToView(param, SupplierView.class);
		List<?> upplier =supplierService.findAllSupplier(view);
		apiReturn.setData(upplier);
		return apiReturn;
	}
	
	@Autowired
	private ISupplierService supplierService;
}
