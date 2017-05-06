package cn.bjtc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("skuspec")
public class SkuspecViewController {

	@RequestMapping(value="{id}.html",method=RequestMethod.GET)
	public String showSkuspecView(@PathVariable Integer id,Model model){
		model.addAttribute("id", id);
		return"sku/descrip";
	}
}
