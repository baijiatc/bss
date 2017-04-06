package cn.bjtc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ViewController {

	@RequestMapping(value="staff/show",method=RequestMethod.GET)
	public String showUserView(){
		return "staff/list";
	}
	
	@RequestMapping(value="priv/show",method=RequestMethod.GET)
	public String showPrivListView(){
		return "priv/list";
	}
	
	@RequestMapping(value="priv/add",method=RequestMethod.GET)
	public String showPrivAddView(){
		return "priv/add";
	}
	
	@RequestMapping(value="priv/{privid}",method=RequestMethod.GET)
	public String showPrivEditView(@PathVariable Integer privid,Model model){
		model.addAttribute("privid", privid);
		return "priv/edit";
	}
	
	@RequestMapping(value="privset/show",method=RequestMethod.GET)
	public String showPrivSetView(){
		return "priv/set";
	}
	
	@RequestMapping(value="privset/det",method=RequestMethod.GET)
	public String showPrivSetDetView(){
		return "priv/setdet";
	}
	

	@RequestMapping(value="role/show",method=RequestMethod.GET)
	public String showRoleListView(){
		return "role/list";
	}
}
