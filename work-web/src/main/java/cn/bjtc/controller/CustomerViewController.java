package cn.bjtc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CustomerViewController {

	@RequestMapping(value="cstmls/show.html",method=RequestMethod.GET)
	public String showCustomerView(){
		return "cust/list";
	}

	@RequestMapping(value="cstmchk/show.html",method=RequestMethod.GET)
	public String showCstmChkView(){
		return "cmchk/show";
	}
	
	@RequestMapping(value="cstmchk/cert/{cid}.html",method=RequestMethod.GET)
	public String showCstmChkCertView(@PathVariable Integer cid, Model model){
		model.addAttribute("cid", cid);
		return "cmchk/cert";
	}
	
	@RequestMapping(value="cstmchk/cnfrm/{cid}.html",method=RequestMethod.GET)
	public String showCstmChkCnfrmView(@PathVariable Integer cid, Model model){
		model.addAttribute("cid", cid);
		return "cmchk/cnfrm";
	}
	
	@RequestMapping(value="cstmchk/exec.html",method=RequestMethod.GET)
	public String showCstmExecView(){
		return "cmchk/exec";
	}
}
