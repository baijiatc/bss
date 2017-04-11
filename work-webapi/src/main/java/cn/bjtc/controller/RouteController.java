package cn.bjtc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.bjtc.api.ApiManager;
import cn.bjtc.api.ApiParam;

@Controller
@RequestMapping("route")
public class RouteController extends BaseController {

	@RequestMapping(value="dispatch", method=RequestMethod.POST)
	public String dispatch(@RequestBody ApiParam param){
		Integer code = param.getCode();
		if(code == null){
			return "forward:./ex/needcode.json";
		}else if(ApiManager.API_MAP.containsKey(code)){
			ApiManager.getInstance().setParameters(request, param);
			return "forward:./"+ApiManager.API_MAP.get(code);
		}else{
			return "forward:./ex/unsupport.json";
		}
	}
	
}
