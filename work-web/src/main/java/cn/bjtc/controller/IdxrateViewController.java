package cn.bjtc.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.bjtc.annotation.SysPrivilege;

@Controller
@RequestMapping("idxrate")
public class IdxrateViewController {

	@RequestMapping(value="show.html",method=RequestMethod.GET)
	public String showIdxrateView(){
		return "idxrate/list";
	}
	
	@RequestMapping(value="add.html",method=RequestMethod.GET)
	@SysPrivilege(name="idxrate:add")
	public String showIdxrateAddView(){
		return "idxrate/add";
	}
	
	@RequestMapping(value="{id}.html",method=RequestMethod.GET)
	@SysPrivilege(name="idxrate:edit")
	public String showIdxrateEditView(@PathVariable Integer id,Model model){
		model.addAttribute("id", id);
		return "idxrate/edit";
	}
}
