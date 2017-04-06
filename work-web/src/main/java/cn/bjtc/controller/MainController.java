package cn.bjtc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("main")
public class MainController {

	@RequestMapping(method=RequestMethod.GET)
	public String showMainView(){
		return "main";
	}
	
	@RequestMapping(value="left",method=RequestMethod.GET)
	public String showLeftView(){
		return "inc/left";
	}
	
	@RequestMapping(value="center",method=RequestMethod.GET)
	public String showCenterView(){
		return "inc/center";
	}
	
	@RequestMapping(value="200",method=RequestMethod.GET)
	public String show200View(){
		return "inc/200";
	}
}
