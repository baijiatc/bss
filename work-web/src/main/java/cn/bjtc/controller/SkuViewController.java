package cn.bjtc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("sku")
public class SkuViewController {

	@RequestMapping(value="show.html",method=RequestMethod.GET)
	public String showSkuListView(){
		return "sku/list";
	}
	
	@RequestMapping(value="add.html",method=RequestMethod.GET)
	public String showSkuAddView(){
		return "sku/add";
	}
	
	@RequestMapping(value="{id}.html",method=RequestMethod.GET)
	public String showSkuAddView(@PathVariable Integer id,Model model){
		model.addAttribute("id", id);
		return "sku/edit";
	}
}
