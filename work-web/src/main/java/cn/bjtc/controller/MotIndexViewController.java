package cn.bjtc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.bjtc.annotation.SysPrivilege;

@Controller
@RequestMapping("motidx")
public class MotIndexViewController {
	
	@RequestMapping(value="show.html",method=RequestMethod.GET)
//	@SysPrivilege(name="motidx:show")
	public String showMotIdxView(){
		return "motidx/list";
	}
	 
	@RequestMapping(value="add.html",method=RequestMethod.GET)
//	@SysPrivilege(name="motidx:add")
	public String showMotIdxAddView(){
		return "motidx/add";
	}
	
	@RequestMapping(value="{id}.html",method=RequestMethod.GET)
//	@SysPrivilege(name="motidx:edit")
	public String showMotIdxEditView(@PathVariable  Integer id, Model model){
		model.addAttribute("id", id);
		return "motidx/edit";	
	}
	@RequestMapping(value="query.html",method=RequestMethod.GET)
	public String showQueryView(){
		return "motidx/query";
	}
}
