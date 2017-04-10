package cn.bjtc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("api")
public class ApiViewController {

	@RequestMapping(value="show.html",method=RequestMethod.GET)
	public String showApiListView(){
		return "api/list";
	}
	
	@RequestMapping(value="add.html",method=RequestMethod.GET)
	public String showApiAddView(){
		return "api/add";
	}
	
	@RequestMapping(value="{apiid}.html",method=RequestMethod.GET)
	public String showApiAddView(@PathVariable Integer apiid,Model model){
		model.addAttribute("apiid", apiid);
		return "api/edit";
	}
}
