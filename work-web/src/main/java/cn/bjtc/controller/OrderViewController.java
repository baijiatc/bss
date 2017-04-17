package cn.bjtc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("order")
public class OrderViewController {

	@RequestMapping(value="show.html",method=RequestMethod.GET)
	public String showOrderView(){
		return "order/list";
	}
}
