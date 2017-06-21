package cn.bjtc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.bjtc.annotation.SysPrivilege;

@Controller
@RequestMapping("dprt")
public class DepartViewController {

	@RequestMapping(value="show.html",method=RequestMethod.GET)
	@SysPrivilege(name="dprt:show")
	public String showDeptView(){
		return "dprt/list";
	}
	
	@RequestMapping(value="add.html",method=RequestMethod.GET)
	@SysPrivilege(name="dprt:add")
	public String showDeptAddView(){
		return "dprt/add";
	}
	
	@RequestMapping(value="{departid}.html",method=RequestMethod.GET)
	@SysPrivilege(name="dprt:eidt")
	public String showDeptEditView(@PathVariable Integer departid,Model model){
		model.addAttribute("departid", departid);
		return "dprt/edit";
	}
}
