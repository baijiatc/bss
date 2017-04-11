package cn.bjtc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("dict")
public class DictViewController {
	
	@RequestMapping(value="show.html",method=RequestMethod.GET)
	public String showDictView(){
		return "dict/list";
	}
	
	@RequestMapping(value="add.html",method=RequestMethod.GET)
	public String showDictAddView(){
		return "dict/add";
	}
	
	@RequestMapping(value="{dictid}.html",method=RequestMethod.GET)
	public String showDictEditView(@PathVariable Integer dictid,Model model){
		model.addAttribute("dictid",dictid);
		return "dict/edit";
	}
	
 
}
