package cn.bjtc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("staffrole")
public class StaffroleViewController {

	@RequestMapping(value="{staffid}.html",method=RequestMethod.GET)
	public String showStaffroleEditView(@PathVariable Integer staffid,Model model){
		model.addAttribute("staffid", staffid);
		return "staffrole/edit";
	}
}
