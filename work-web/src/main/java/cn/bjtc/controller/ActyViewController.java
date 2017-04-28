package cn.bjtc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.bjtc.annotation.SysPrivilege;

@Controller
@RequestMapping("act")
public class ActyViewController {

	@RequestMapping(value="show.html",method=RequestMethod.GET)
	@SysPrivilege(name="act:show")
	public String showActyView(){
		return "act/list";
	}
	
	@RequestMapping(value="add.html",method=RequestMethod.GET)
	@SysPrivilege(name="act:add")
	public String showActyAddView(){
		return "act/add";
	}
	
	@RequestMapping(value="{id}.html",method=RequestMethod.GET)
	@SysPrivilege(name="act:edit")
	public String showActyEditView(@PathVariable Integer id,Model model){
		model.addAttribute("id", id);
		return "act/edit";
	}
}
