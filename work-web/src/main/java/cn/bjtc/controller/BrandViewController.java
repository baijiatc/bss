package cn.bjtc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("brand")
public class BrandViewController {

	@RequestMapping(value="show.html",method=RequestMethod.GET)
	public String showBrandView(){
		return "brand/list";
	}
	
	@RequestMapping(value="add.html",method=RequestMethod.GET)
    public String showBrandAddView(){
		return "brand/add";
	}
	
	@RequestMapping(value="{id}.html",method=RequestMethod.GET)
	public String showBrandEditView(@PathVariable Integer id,Model model){
		model.addAttribute("id", id);
		return "brand/edit";
		
	}
	
}
