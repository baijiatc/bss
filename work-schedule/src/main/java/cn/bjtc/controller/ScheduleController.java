package cn.bjtc.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.bjtc.service.IScheduleService;

@Controller
public class ScheduleController {

	@RequestMapping("sched/show")
	public String showList(Model model){
		List<Map<String, Object>> triggers = scheduleService.getQrtzTriggers();
		model.addAttribute("test", "This is a test string...");
		model.addAttribute("triggers", triggers);
		return "list";
	}
	
	@Autowired
	private IScheduleService scheduleService;
}
