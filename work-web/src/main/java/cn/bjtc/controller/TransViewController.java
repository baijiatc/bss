package cn.bjtc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("trans")
public class TransViewController {

	@RequestMapping(value="show.html",method=RequestMethod.GET)
	public String showUserView(){
		return "trans/list";
	}
}
