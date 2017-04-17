package cn.bjtc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("staff")
public class StaffViewController {

	@RequestMapping(value="show.html",method=RequestMethod.GET)
	public String showUserView(){
		return "staff/list";
	}
	
	@RequestMapping(value="add.html",method=RequestMethod.GET)
	public String showStaffAddView(){
		return "staff/add";
	}
	
	@RequestMapping(value="{staffid}.html",method=RequestMethod.GET)
	public String showStaffEditView(@PathVariable Integer staffid,Model model){
		model.addAttribute("staffid", staffid);
		return "staff/edit";
	}
	
	@RequestMapping(value="{staffid}/profile.html",method=RequestMethod.GET)
	public String showStaffCenterView(@PathVariable Integer staffid,Model model){
		model.addAttribute("staffid", staffid);
		return "staff/profile";
	}
	@RequestMapping(value="{staffid}/repasswd.html",method=RequestMethod.GET)
	public String showRepasswdView(@PathVariable Integer staffid,Model model){
		model.addAttribute("staffid", staffid);
		return "staff/repasswd";
	}
}
