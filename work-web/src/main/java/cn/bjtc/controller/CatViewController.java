package cn.bjtc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("cat")
public class CatViewController {

	@RequestMapping(value="show.html",method=RequestMethod.GET)
	public String showCatView(){
		return "cat/list";	
	}
	

	@RequestMapping(value="add.html",method=RequestMethod.GET)
    public String showCatAddView(){
		return "cat/add";
	}
	
	@RequestMapping(value="{id}.html",method=RequestMethod.GET)
	public String showCatEditView(@PathVariable Integer id,Model model){
		model.addAttribute("id", id);
		return "cat/edit";
		
	}
	
}
