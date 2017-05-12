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
import cn.bjtc.aspect.AspectType;
import cn.bjtc.service.IParametersService;
import cn.bjtc.service.IProdParmService;

@RestController
@RequestMapping("prodparm")
public class ProdParmController extends BaseController{
	
 
	@RequestMapping(value="create", method=RequestMethod.POST)
	@SysLogger(content="新增产品绑定参数",type=AspectType.CONTROLLER)
	public ApiReturn execAddProdParms(){
 		 try {
			ApiParam param=findApiParam();
			ifParamDataIsEmpty(param);
			Object paramid = param.getData().get(0).get("paramid");
			Object productid = param.getData().get(0).get("productid");
			 ppService.delectProdParmById(productid);
			 if(paramid != "" && paramid != null){
				 ppService.saveProdParms(productid, paramid); 
				 
 			 }
  		} catch (Exception e) {
   		showServerError();
 		} 
		return apiReturn;
	}
	
 
	@RequestMapping(value="getParmByProdId", method=RequestMethod.POST)
    public ApiReturn execeditProdParms(){
		try {
			ApiParam param=findApiParam();
			ifParamDataIsEmpty(param);
			Map<String, Object> ProdIdMap = param.getData().get(0);
			Object productid = ProdIdMap.get("id");
			List<?> pps=parmService.findAllParameterByProductId(productid);
			apiReturn.setData(pps);
		} catch (Exception e) {
			showServerError();
		}
		return apiReturn;	
	}
    
	@Autowired
	private IProdParmService ppService;
	
	@Autowired
	private IParametersService  parmService;
}
