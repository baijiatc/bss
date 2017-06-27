package cn.bjtc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.bjtc.annotation.SysPrivilege;

@Controller
@RequestMapping("motjob")
public class MotJobViewController {

	@RequestMapping(value="show.html",method=RequestMethod.GET)
//	@SysPrivilege(name="motjob:show")
	public String showMotJobView(){
		return "motjob/list";
	}
 
	
	@RequestMapping(value="find.html",method=RequestMethod.GET)
//	@SysPrivilege(name="motjob:show")
	public String showMotJobQueryView(){
		return "motjob/find";
	}
 
//	
//	@RequestMapping(value="{id}.html",method=RequestMethod.GET)
//	@SysPrivilege(name="act:edit")
//	public String showActyEditView(@PathVariable Integer id,Model model){
//		model.addAttribute("id", id);
//		return "act/edit";
//	}
}
