package cn.bjtc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.bjtc.annotation.SysPrivilege;

@Controller
@RequestMapping("actawd")
public class ActawardsViewController {
	
	@RequestMapping(value="show.html",method=RequestMethod.GET)
	@SysPrivilege(name="actawd:show")
	public String showActawardsView(){
		return "actawd/list";
	}
	 
	@RequestMapping(value="add.html",method=RequestMethod.GET)
	@SysPrivilege(name="actawd:add")
	public String showActawardsAddView(){
		return "actawd/add";
	}
	
	@RequestMapping(value="{id}.html",method=RequestMethod.GET)
	@SysPrivilege(name="actawd:edit")
	public String showActawardsEditView(@PathVariable  Integer id, Model model){
		model.addAttribute("id", id);
		return "actawd/edit";	
	}
}
