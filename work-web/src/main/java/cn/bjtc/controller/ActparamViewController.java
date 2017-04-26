package cn.bjtc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.bjtc.annotation.SysPrivilege;

@Controller
@RequestMapping("actparam")
public class ActparamViewController {
	
	@RequestMapping(value="show.html",method=RequestMethod.GET)
	@SysPrivilege(name="actparam:show")
	public String showActparamView(){
		return "actparam/list";
	}
	
	@RequestMapping(value="add.html",method=RequestMethod.GET)
	@SysPrivilege(name="actparam:add")
    public String showAactparamAddView(){
		return "actparam/add";
	}
	
	@RequestMapping(value="{id}.html",method=RequestMethod.GET)
	@SysPrivilege(name="actparam:edit")
	public String showActparamEditView(@PathVariable Integer id,Model model){
		model.addAttribute("id", id);
		return "actparam/edit";
		
	}
}