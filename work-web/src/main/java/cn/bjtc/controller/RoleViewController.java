package cn.bjtc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.bjtc.annotation.SysPrivilege;

@Controller
@RequestMapping("role")
public class RoleViewController {

	@RequestMapping(value="show.html",method=RequestMethod.GET)
	@SysPrivilege(name="role:show")
	public String showRoleListView(){
		return "role/list";
	}
	
	@RequestMapping(value="add.html",method=RequestMethod.GET)
	@SysPrivilege(name="role:add")
	public String showRoleAddView(){
		return "role/add";
	}
	
	@RequestMapping(value="{roleid}.html",method=RequestMethod.GET)
	@SysPrivilege(name="role:edit")
	public String showRoleEditView(@PathVariable Integer roleid,Model model){
		model.addAttribute("roleid", roleid);
		return "role/edit";
	}
}
