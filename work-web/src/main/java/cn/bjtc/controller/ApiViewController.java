package cn.bjtc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.bjtc.annotation.SysPrivilege;

@Controller
@RequestMapping("api")
public class ApiViewController {

	@RequestMapping(value="show.html",method=RequestMethod.GET)
	@SysPrivilege(name="api:show")
	public String showApiListView(){
		return "api/list";
	}
	
	@RequestMapping(value="add.html",method=RequestMethod.GET)
	@SysPrivilege(name="api:add")
	public String showApiAddView(){
		return "api/add";
	}
	
	@RequestMapping(value="{apiid}.html",method=RequestMethod.GET)
	@SysPrivilege(name="api:edit")
	public String showApiEditView(@PathVariable Integer apiid,Model model){
		model.addAttribute("apiid", apiid);
		return "api/edit";
	}
}
