package cn.bjtc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("role")
public class RoleViewController {

	@RequestMapping(value="show.html",method=RequestMethod.GET)
	public String showRoleListView(){
		return "role/list";
	}
	
	@RequestMapping(value="add.html",method=RequestMethod.GET)
	public String showRoleAddView(){
		return "role/add";
	}
	
	@RequestMapping(value="{roleid}.html",method=RequestMethod.GET)
	public String showRoleAddView(@PathVariable Integer roleid,Model model){
		model.addAttribute("roleid", roleid);
		return "role/edit";
	}
}
