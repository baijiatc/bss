package cn.bjtc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.bjtc.annotation.SysPrivilege;

@Controller
@RequestMapping("dict")
public class DictViewController {
	
	@RequestMapping(value="show.html",method=RequestMethod.GET)
	@SysPrivilege(name="dict:show")
	public String showDictView(){
		return "dict/list";
	}
	
	@RequestMapping(value="add.html",method=RequestMethod.GET)
	@SysPrivilege(name="dict:add")
	public String showDictAddView(){
		return "dict/add";
	}
	
	@RequestMapping(value="{dictid}.html",method=RequestMethod.GET)
	@SysPrivilege(name="dict:edit")
	public String showDictEditView(@PathVariable Integer dictid,Model model){
		model.addAttribute("dictid",dictid);
		return "dict/edit";
	}
	
 
}
