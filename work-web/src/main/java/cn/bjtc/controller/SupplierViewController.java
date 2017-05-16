package cn.bjtc.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.bjtc.annotation.SysPrivilege;

@Controller
@RequestMapping("supp")
public class SupplierViewController {

	@RequestMapping(value="show.html",method=RequestMethod.GET)
	@SysPrivilege(name="supp:show")
	public String showSupplierView(){
		return "supplier/list";
	}
	
	@RequestMapping(value="add.html",method=RequestMethod.GET)
	@SysPrivilege(name="supp:add")
	public String showSupplierAddView(){
		return "supplier/add";
	}
	
	@RequestMapping(value="{suppid}.html",method=RequestMethod.GET)
	@SysPrivilege(name="supp:edit")
	public String showSupplierEditView(@PathVariable Integer suppid,Model model){
		model.addAttribute("suppid", suppid);
		return "supplier/edit";
	}
}
