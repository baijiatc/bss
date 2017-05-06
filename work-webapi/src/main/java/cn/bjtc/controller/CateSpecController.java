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
import cn.bjtc.service.ICateSpecService;
import cn.bjtc.service.IParametersService;
import cn.bjtc.service.IProdParmService;
import cn.bjtc.service.ISpecService;

@RestController
@RequestMapping("cateSpec")
public class CateSpecController extends BaseController{
	
 
	@RequestMapping(value="create", method=RequestMethod.POST)
	@SysLogger(content="新增品类绑定规格",type=AspectType.CONTROLLER)
	public ApiReturn execAddCateSpecs(){
// 		 try {
			ApiParam param=findApiParam();
			ifParamDataIsEmpty(param);
			Object specid = param.getData().get(0).get("specid");
			Object catid = param.getData().get(0).get("catid");
			 catespecService.delectCatesById(catid);
			 if(specid != "" && specid != null){
				 catespecService.saveCateSpecs(catid, specid);  
				 
			 }
// 		} catch (Exception e) {
//  		showServerError();
// 		}
		return apiReturn;
	}
	
 
	@RequestMapping(value="getSpecByCatId", method=RequestMethod.POST)
    public ApiReturn execeditCateSpec(){
		try {
			ApiParam param=findApiParam();
			ifParamDataIsEmpty(param);
			Map<String, Object> CatIdMap = param.getData().get(0);
			Object catid = CatIdMap.get("id");
			List<?> specs=specService.findAllSpecByCatId(catid);
			apiReturn.setData(specs);
		} catch (Exception e) {
			showServerError();
		}
		return apiReturn;	
	}
    
	
	@Autowired
	private ICateSpecService catespecService;
	@Autowired
	private ISpecService specService;
}
