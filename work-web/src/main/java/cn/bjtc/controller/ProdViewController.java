package cn.bjtc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.bjtc.annotation.SysPrivilege;

@Controller
@RequestMapping("prod")
public class ProdViewController {

	@RequestMapping(value="show.html",method=RequestMethod.GET)
	@SysPrivilege(name="prod:show")
	public String showProdView(){
		return "prod/list";
	}

	@RequestMapping(value="add.html",method=RequestMethod.GET)
	@SysPrivilege(name="prod:add")
	public String showProdAddView(){
		return "prod/add";
	}
	
	@RequestMapping(value="{id}.html",method=RequestMethod.GET)
	@SysPrivilege(name="prod:edit")
	public String showProdEditView(@PathVariable  Integer id, Model model){
		model.addAttribute("id", id);
		return "prod/edit";	
	}
}
