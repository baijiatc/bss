package cn.bjtc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("chanrs")
public class StaffChanRsViewController {

	@RequestMapping(value="show.html",method=RequestMethod.GET)
	public String showStaffobjView(){
		return "chanrs/list";
	}
	
	@RequestMapping(value="add.html",method=RequestMethod.GET)
	public String showStaffobjAddView(){
		return "chanrs/add";
	}
	
	@RequestMapping(value="{staffobjid}.html",method=RequestMethod.GET)
	public String showStaffobjEditView(@PathVariable Integer staffobjid,Model model){
		model.addAttribute("staffobjid", staffobjid);
		return "chanrs/edit";
	}
}
