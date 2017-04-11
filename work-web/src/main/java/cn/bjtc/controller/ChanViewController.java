package cn.bjtc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("chan")
public class ChanViewController {

	@RequestMapping(value="show.html",method=RequestMethod.GET)
	public String showChanListView(){
		return "chan/list";
	}
	
	@RequestMapping(value="add.html",method=RequestMethod.GET)
	public String showChanAddView(){
		return "chan/add";
	}
	
	@RequestMapping(value="{chanid}.html",method=RequestMethod.GET)
	public String showChanAddView(@PathVariable Integer chanid,Model model){
		model.addAttribute("chanid", chanid);
		return "chan/edit";
	}
}
