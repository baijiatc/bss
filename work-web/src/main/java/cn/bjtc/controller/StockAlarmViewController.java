package cn.bjtc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.bjtc.annotation.SysPrivilege;

@Controller
@RequestMapping("alarm")
public class StockAlarmViewController {

	@RequestMapping(value="show.html",method=RequestMethod.GET)
	@SysPrivilege(name="alarm:show")
	public String showStockAlarmListView(){
		return "alarm/list";
	}
	
	@RequestMapping(value="add.html",method=RequestMethod.GET)
	@SysPrivilege(name="alarm:add")
	public String showStockAlarmAddView(){
		return "alarm/add";
	}
	
	@RequestMapping(value="{alarmid}.html",method=RequestMethod.GET)
	@SysPrivilege(name="alarm:edit")
	public String showStockAlarmEditView(@PathVariable Integer alarmid,Model model){
		model.addAttribute("alarmid", alarmid);
		return "alarm/edit";
	}
}
