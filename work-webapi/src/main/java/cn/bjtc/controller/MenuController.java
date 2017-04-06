package cn.bjtc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.bjtc.api.ApiReturn;
import cn.bjtc.service.IMenuService;

@RestController
@RequestMapping("menu")
public class MenuController extends BaseController {

	@RequestMapping(value="isact", method=RequestMethod.POST)
	public ApiReturn showActMenus(){
		List<?> pmenus = menuService.findActMenus();
		apiReturn.setData(pmenus);
		return apiReturn;
	}
	
	@Autowired
	private IMenuService menuService;
}
