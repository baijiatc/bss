package cn.bjtc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.bjtc.annotation.SysPrivilege;


@Controller
@RequestMapping("brand")
public class BrandViewController {

	@RequestMapping(value="show.html",method=RequestMethod.GET)
	@SysPrivilege(name="brand:show")
	public String showBrandView(){
		return "brand/list";
	}
	
	@RequestMapping(value="add.html",method=RequestMethod.GET)
	@SysPrivilege(name="brand:add")
    public String showBrandAddView(){
		return "brand/add";
	}
	
	@RequestMapping(value="{id}.html",method=RequestMethod.GET)
	@SysPrivilege(name="brand:edit")
	public String showBrandEditView(@PathVariable Integer id,Model model){
		model.addAttribute("id", id);
		return "brand/edit";
		
	}
	
}
