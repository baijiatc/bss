package cn.bjtc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.bjtc.annotation.SysPrivilege;

@Controller
@RequestMapping("factor")
public class FactorViewController {

	@RequestMapping(value="show.html",method=RequestMethod.GET)
	@SysPrivilege(name="factor:show")
	public String showFactorListView(){
		return "factor/list";
	}
	
	@RequestMapping(value="add.html",method=RequestMethod.GET)
	@SysPrivilege(name="factor:add")
	public String showFactorAddView(){
		return "factor/add";
	}
	
	@RequestMapping(value="{factorid}.html",method=RequestMethod.GET)
	@SysPrivilege(name="factor:edit")
	public String showFactorEditView(@PathVariable Integer factorid,Model model){
		model.addAttribute("factorid", factorid);
		return "factor/edit";
	}
}
