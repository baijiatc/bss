package cn.bjtc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.bjtc.annotation.SysPrivilege;

@Controller
@RequestMapping("scheme")
public class MotSchemeViewController {

	@RequestMapping(value="show.html",method=RequestMethod.GET)
//	@SysPrivilege(name="scheme:show")
	public String showSchemeView(){
		return "scheme/list";
	}
	
	@RequestMapping(value="add.html",method=RequestMethod.GET)
	//@SysPrivilege(name="scheme:add")
	public String showSchemeAddView(){
		return "scheme/add";
	}
	
	@RequestMapping(value="{id}.html",method=RequestMethod.GET)
//	@SysPrivilege(name="scheme:edit")
	public String showSchemeEditView(@PathVariable Integer id,Model model){
		model.addAttribute("id", id);
		return "scheme/edit";
	}
}
