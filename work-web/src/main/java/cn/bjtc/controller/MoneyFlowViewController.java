package cn.bjtc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("flow")
public class MoneyFlowViewController {

	@RequestMapping(value="show.html",method=RequestMethod.GET)
	public String showFlowView(){
		return "flow/list";
	}
}
