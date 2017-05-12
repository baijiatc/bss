package cn.bjtc.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.bjtc.annotation.SysLogger;
import cn.bjtc.api.ApiParam;
import cn.bjtc.api.ApiReturn;
import cn.bjtc.api.util.ParamUtil;
import cn.bjtc.aspect.AspectType;
import cn.bjtc.service.ISkuspecService;
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
	
	@RequestMapping(value="getSkuSpec", method=RequestMethod.POST)
	public ApiReturn findAllSkuSpec(){
		try {
			ApiParam param = findApiParam();
			ifParamDataIsEmpty(param);
			Map<String, Object> skuIdMap = param.getData().get(0);
			Object skuid = skuIdMap.get("skuid");
			List<?> specs = specService.findAllSpecBySkuId(skuid);
			apiReturn.setData(specs);
		} catch (Exception e) {
			showServerError();
		}
		return apiReturn;
	}
	
	@RequestMapping(value="createSkp", method=RequestMethod.POST)
	@SysLogger(content="sku绑定信息",type=AspectType.CONTROLLER)
	public ApiReturn execcreateSkuspec(){
		try {
			ApiParam param = findApiParam();
			ifParamDataIsEmpty(param);
			Object specids = param.getData().get(0).get("specid");
			Object skuid = param.getData().get(0).get("skuid");
			skuspecService.deleteById(skuid);
			if(specids != null && specids !=""){
				skuspecService.createSkuspec(skuid, specids);
			}
		} catch (Exception e) {
			showServerError();
		}
		return apiReturn;
	}
	
	@Autowired
	private ISpecService specService;
	@Autowired
	private ISkuspecService skuspecService;
}
