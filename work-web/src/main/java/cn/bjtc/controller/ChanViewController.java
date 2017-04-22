package cn.bjtc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.bjtc.annotation.SysPrivilege;

@Controller
@RequestMapping("chan")
public class ChanViewController {

	@RequestMapping(value="show.html",method=RequestMethod.GET)
	@SysPrivilege(name="chan:show")
	public String showChanListView(){
		return "chan/list";
	}
	
	@RequestMapping(value="add.html",method=RequestMethod.GET)
	@SysPrivilege(name="chan:add")
	public String showChanAddView(){
		return "chan/add";
	}
	
	@RequestMapping(value="{chanid}.html",method=RequestMethod.GET)
	@SysPrivilege(name="chan:edit")
	public String showChanEditView(@PathVariable Integer chanid,Model model){
		model.addAttribute("chanid", chanid);
		return "chan/edit";
	}
}
