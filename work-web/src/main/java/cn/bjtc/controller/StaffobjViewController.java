package cn.bjtc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.bjtc.annotation.SysPrivilege;

@Controller
@RequestMapping("supprs")
public class StaffobjViewController {

	@RequestMapping(value="show.html",method=RequestMethod.GET)
	public String showStaffobjView(){
		return "supprs/list";
	}
	
	@RequestMapping(value="add.html",method=RequestMethod.GET)
	@SysPrivilege(name="supprs:add")
	public String showStaffobjAddView(){
		return "supprs/add";
	}
	
	@RequestMapping(value="{staffobjid}.html",method=RequestMethod.GET)
	@SysPrivilege(name="supprs:edit")
	public String showStaffobjEditView(@PathVariable Integer staffobjid,Model model){
		model.addAttribute("staffobjid", staffobjid);
		return "supprs/edit";
	}
}
