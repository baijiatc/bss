package cn.bjtc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.bjtc.annotation.SysPrivilege;

@Controller
@RequestMapping("idx")
public class IndexesViewController {

	@RequestMapping(value="show.html",method=RequestMethod.GET)
	public String showIdxView(){
		return "idx/list";
	}
	
	@RequestMapping(value="add.html",method=RequestMethod.GET)
	@SysPrivilege(name="idx:add")
	public String showidxAddView(){
		return "idx/add";
	}
	
	@RequestMapping(value="{id}.html",method=RequestMethod.GET)
	@SysPrivilege(name="idx:edit")
	public String showidxfEditView(@PathVariable Integer id,Model model){
		model.addAttribute("id", id);
		return "idx/edit";
	}
}
