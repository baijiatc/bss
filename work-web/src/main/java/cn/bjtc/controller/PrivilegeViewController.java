package cn.bjtc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cn.bjtc.annotation.SysPrivilege;

@Controller
public class PrivilegeViewController {

	@RequestMapping(value="priv/show.html",method=RequestMethod.GET)
	@SysPrivilege(name="priv:show")
	public String showPrivListView(){
		return "priv/list";
	}
	
	@RequestMapping(value="priv/add.html",method=RequestMethod.GET)
	@SysPrivilege(name="priv:add")
	public String showPrivAddView(){
		return "priv/add";
	}
	
	@RequestMapping(value="priv/{privid}.html",method=RequestMethod.GET)
	@SysPrivilege(name="priv:edit")
	public String showPrivEditView(@PathVariable Integer privid,Model model){
		model.addAttribute("privid", privid);
		return "priv/edit";
	}
	
	@RequestMapping(value="privset/show.html",method=RequestMethod.GET)
	@SysPrivilege(name="privset:show")
	public String showPrivSetView(){
		return "priv/set";
	}
	
	@RequestMapping(value="privset/det.html",method=RequestMethod.GET)
	public String showPrivSetDetView(@RequestParam Integer objid, @RequestParam Boolean isRole,Model model){
		model.addAttribute("objid", objid);
		model.addAttribute("isRole", isRole);
		return "priv/setdet";
	}
}
