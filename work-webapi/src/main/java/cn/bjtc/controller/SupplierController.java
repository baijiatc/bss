package cn.bjtc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
		try {
			ApiParam param = findApiParam();
			SupplierView view = (SupplierView) ParamUtil.convertToView(param, SupplierView.class);
			int count = supplierService.countAllSupplier(view);
			List<?> supplier = supplierService.findAllSupplier(view);
			apiReturn.setCount(count);
			apiReturn.setData(supplier);
		} catch (Exception e) {
			showServerError();
		}
		return apiReturn;
	}
	
	@RequestMapping(value="create", method=RequestMethod.POST)
	public ApiReturn execAddSupplier(){
		try {
			ApiParam param = findApiParam();
			ifParamDataIsEmpty(param);
			SupplierView view = (SupplierView) ParamUtil.convertToView(param, SupplierView.class);
			supplierService.saveSupplier(view);
		} catch (Exception e) {
			showServerError();
		}
		return apiReturn;
	}
	
	@RequestMapping(value="update", method=RequestMethod.POST)
	public ApiReturn execUpdateSupplier(){
		try {
			ApiParam param = findApiParam();
			ifParamDataIsEmpty(param);
			SupplierView view = (SupplierView) ParamUtil.convertToView(param, SupplierView.class);
			supplierService.updateSupplier(view);
		} catch (Exception e) {
			showServerError();
		}
		return apiReturn;
	}
	
	@RequestMapping(value="get", method=RequestMethod.POST)
	public ApiReturn execeditSupplier(){
		try {
			ApiParam param = findApiParam();
			ifParamDataIsEmpty(param);
			SupplierView view = (SupplierView) ParamUtil.convertToView(param, SupplierView.class);
			List<?> upplier =supplierService.findAllSupplier(view);
			apiReturn.setData(upplier);
		} catch (Exception e) {
			showServerError();
		}
		return apiReturn;
	}
	
	@Autowired
	private ISupplierService supplierService;
}
