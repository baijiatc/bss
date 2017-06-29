package cn.bjtc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("motevt")
public class MoteventViewController {
	
	@RequestMapping(value="show.html",method=RequestMethod.GET)
//	@SysPrivilege(name="Motevent:show")
	public String showMoteventView(){
		return "motevt/list";
	}
	 
	@RequestMapping(value="add.html",method=RequestMethod.GET)
//	@SysPrivilege(name="Motevent:add")
	public String showMoteventAddView(){
		return "motevt/add";
	}
	
	@RequestMapping(value="{id}.html",method=RequestMethod.GET)
//	@SysPrivilege(name="Motevent:edit")
	public String showMoteventEditView(@PathVariable  Integer id, Model model){
		model.addAttribute("id", id);
		return "motevt/edit";	
	}
	@RequestMapping(value="query.html",method=RequestMethod.GET)
	public String showQueryView(){
		return "motevt/query";
	}
	@RequestMapping(value="{id}/control.html",method=RequestMethod.GET)
	//@SysPrivilege(name="pwd:modify")
	public String showControlView(@PathVariable Integer id,Model model){
		model.addAttribute("id", id);
		return "motevt/control";
	}
}
