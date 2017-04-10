package cn.bjtc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DictViewController {
	@RequestMapping(value="dict/show",method=RequestMethod.GET)
	public String showDictView(){
		return "dict/list";
	}
	
	@RequestMapping(value="dict/add",method=RequestMethod.GET)
	public String showDictAddView(){
		return "dict/add";
	}
	
	@RequestMapping(value="dict/{id}",method=RequestMethod.GET)
	public String showDictEditView(@PathVariable Integer id,Model model){
		model.addAttribute("id",id);
		return "dict/edit";
	}
	
 
}
