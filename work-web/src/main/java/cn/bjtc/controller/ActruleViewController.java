package cn.bjtc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("actrule")
public class ActruleViewController {
	
	@RequestMapping(value="show.html",method=RequestMethod.GET)
	public String showActruleView(){
		return "actrule/list";
	}
	
	@RequestMapping(value="add.html",method=RequestMethod.GET)
	public String showActruleAddView(){
		return "actrule/add";
	}
	
	@RequestMapping(value="{id}.html",method=RequestMethod.GET)
	public String showActruleEditView(@PathVariable  Integer id, Model model){
		model.addAttribute("id", id);
		return "actrule/edit";	
	}
}
