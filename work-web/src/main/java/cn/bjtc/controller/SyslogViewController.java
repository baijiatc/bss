package cn.bjtc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SyslogViewController {

	@RequestMapping(value="syslog/show.html",method=RequestMethod.GET)
	public String showSyslogView(){
		return "syslog/list";
	}
}
