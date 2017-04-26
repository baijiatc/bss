package cn.bjtc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.bjtc.annotation.SysPrivilege;

@Controller
@RequestMapping("idxparam")
public class IdxparamViewController {

	@RequestMapping(value="show.html",method=RequestMethod.GET)
	public String showIdxparamView(){
		return "idxparam/list";
	}
	
	@RequestMapping(value="add.html",method=RequestMethod.GET)
	@SysPrivilege(name="idxparam:add")
	public String showIdxparamAddView(){
		return "idxparam/add";
	}
	
	@RequestMapping(value="{id}.html",method=RequestMethod.GET)
	@SysPrivilege(name="idxparam:edit")
	public String showIdxparamEditView(@PathVariable Integer id,Model model){
		model.addAttribute("id", id);
		return "idxparam/edit";
	}
}
