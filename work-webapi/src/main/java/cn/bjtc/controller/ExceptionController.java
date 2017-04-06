package cn.bjtc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.bjtc.api.ApiReturn;

@RestController
@RequestMapping("ex")
public class ExceptionController {
	
	@RequestMapping(value="unsupport", method=RequestMethod.POST)
	public ApiReturn returnUnsupportedBusiness(){
		ApiReturn apiReturn = new ApiReturn();
		apiReturn.setCode(3);
		apiReturn.setMessage("不支持的业务操作");
		return apiReturn;
	}
	
	@RequestMapping(value="srverr", method=RequestMethod.POST)
	public ApiReturn returnServerError(){
		ApiReturn apiReturn = new ApiReturn();
		apiReturn.setCode(2);
		apiReturn.setMessage("服务器内部错误");
		return apiReturn;
	}
	
	@RequestMapping(value="needcode", method=RequestMethod.POST)
	public ApiReturn returnCodeNecessary(){
		ApiReturn apiReturn = new ApiReturn();
		apiReturn.setCode(1);
		apiReturn.setMessage("缺少必需参数");
		return apiReturn;
	}
}
