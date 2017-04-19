package cn.bjtc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("cstmrs")
public class CstmrsViewController {

	@RequestMapping(value="show.html",method=RequestMethod.GET)
	public String showStaffobjView(){
		return "cstmrs/list";
	}
	
	@RequestMapping(value="add.html",method=RequestMethod.GET)
	public String showStaffobjAddView(){
		return "cstmrs/add";
	}
	
	@RequestMapping(value="{staffobjid}.html",method=RequestMethod.GET)
	public String showStaffobjEditView(@PathVariable Integer staffobjid,Model model){
		model.addAttribute("staffobjid", staffobjid);
		return "cstmrs/edit";
	}
}
