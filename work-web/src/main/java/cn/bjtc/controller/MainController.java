package cn.bjtc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

	@RequestMapping(value="main.html", method=RequestMethod.GET)
	public String showMainView(){
		return "main";
	}
	
	@RequestMapping(value="main/left.html",method=RequestMethod.GET)
	public String showLeftView(){
		return "inc/left";
	}
	
	@RequestMapping(value="main/center.html",method=RequestMethod.GET)
	public String showCenterView(){
		return "inc/center";
	}
	
	@RequestMapping(value="main/200.html",method=RequestMethod.GET)
	public String show200View(){
		return "inc/200";
	}
}
