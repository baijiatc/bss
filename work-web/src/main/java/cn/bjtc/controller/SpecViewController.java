package cn.bjtc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.bjtc.annotation.SysPrivilege;

@Controller
@RequestMapping("spec")
public class SpecViewController {

	@RequestMapping(value="show.html",method=RequestMethod.GET)
	public String showSpecView(){
		return "spec/list";
	}
	
	@RequestMapping(value="add.html",method=RequestMethod.GET)
	@SysPrivilege(name="spec:add")
	public String showSpecAddView(){
		return "spec/add";
	}
	
	@RequestMapping(value="{id}.html",method=RequestMethod.GET)
	@SysPrivilege(name="spec:edit")
	public String showSpecfEditView(@PathVariable Integer id,Model model){
		model.addAttribute("id", id);
		return "spec/edit";
	}
}
