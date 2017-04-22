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
import cn.bjtc.service.ISpecService;
import cn.bjtc.view.SpecView;

@RestController
@RequestMapping("spec")
public class SpecController extends BaseController {

	@RequestMapping(value="all", method=RequestMethod.POST)
	@SysLogger(content="查询产品规格信息",type=AspectType.CONTROLLER)
	public ApiReturn showActSpec(){
		 try {
			ApiParam param=findApiParam();
			 SpecView view=(SpecView) ParamUtil.convertToView(param, SpecView.class);
			 int count=specService.countAllSpecs(view);
			 List<?> Spec=specService.findAllSpecs(view);
			 apiReturn.setCount(count);
			 apiReturn.setData(Spec);
		} catch (Exception e) {
			showServerError();
		}
		 return apiReturn; 
	}
	
	@RequestMapping(value="create", method=RequestMethod.POST)
	@SysLogger(content="新增产品规格信息",type=AspectType.CONTROLLER)
	public ApiReturn execAddSpec(){
		try {
			ApiParam param=findApiParam();
			ifParamDataIsEmpty(param);
			SpecView view=(SpecView) ParamUtil.convertToView(param, SpecView.class);
			specService.saveSpec(view);
		} catch (Exception e) {
			showServerError();
		}
		return apiReturn;
	}
	
	@RequestMapping(value="update", method=RequestMethod.POST)
	@SysLogger(content="编辑产品规格信息",type=AspectType.CONTROLLER)
	public ApiReturn execUpdateSpec(){
		try {
			ApiParam param=findApiParam();
			ifParamDataIsEmpty(param);
			SpecView view=(SpecView) ParamUtil.convertToView(param, SpecView.class);
			specService.updateSpec(view);
		} catch (Exception e) {
			showServerError();
		}
		return apiReturn;
	}
	
	@RequestMapping(value="get", method=RequestMethod.POST)
	public ApiReturn execeditSpec(){
		try {
			ApiParam param=findApiParam();
			ifParamDataIsEmpty(param);
			SpecView view=(SpecView) ParamUtil.convertToView(param, SpecView.class);
			List<?> Spec=specService.findAllSpecs(view);
			apiReturn.setData(Spec);
		} catch (Exception e) {
			showServerError();
		}
		return apiReturn;
	}
	
	@Autowired
	private ISpecService specService;
}
