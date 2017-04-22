package cn.bjtc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.bjtc.annotation.SysPrivilege;

@Controller
@RequestMapping("stock")
public class StockViewController {
	
	@RequestMapping(value="show.html",method=RequestMethod.GET)
	@SysPrivilege(name="stock:show")
	public String showStockView(){
		return "stock/list";
	}
}
