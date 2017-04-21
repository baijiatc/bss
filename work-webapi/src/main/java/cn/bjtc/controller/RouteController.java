package cn.bjtc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.bjtc.api.ApiParam;

@Controller
@RequestMapping("route")
public class RouteController extends BaseController {

	@RequestMapping(value="dispatch", method=RequestMethod.POST)
	public String dispatch(@RequestBody ApiParam param){
		return validParam(param);
	}
	
}
