package cn.bjtc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.bjtc.annotation.SysPrivilege;

@Controller
@RequestMapping("passwd")
public class PasswdViewController {

	@RequestMapping(value="show.html",method=RequestMethod.GET)
	public String showPasswdView(){
		return "passwd/list";
	}
	
	@RequestMapping(value="{staffid}.html",method=RequestMethod.GET)
	@SysPrivilege(name="pwd:reset")
	public String showPasswdEditView(@PathVariable Integer staffid,Model model){
		model.addAttribute("staffid", staffid);
		return "passwd/edit";
	}
}
