package cn.bjtc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.bjtc.api.ApiManager;
import cn.bjtc.api.ApiParam;
import cn.bjtc.api.ApiReturn;
import cn.bjtc.api.util.ParamUtil;
import cn.bjtc.load.StartupLoader;
import cn.bjtc.service.IMenuService;
import cn.bjtc.view.MenuView;

@RestController
@RequestMapping("menu")
public class MenuController extends BaseController {

	@RequestMapping(value="all", method=RequestMethod.POST)
	public ApiReturn showActMenus(){
		 ApiParam param=ApiManager.getInstance().getParameters(request);
		 MenuView view=(MenuView) ParamUtil.convertToView(param, MenuView.class);
		 int count=menuService.countAllMenus(view);
		 List<?> menus=menuService.findAllMenus(view);
		 apiReturn.setCount(count);
		 apiReturn.setData(menus);
		 return apiReturn; 
	}
	
	@RequestMapping(value="create", method=RequestMethod.POST)
	public ApiReturn execAddMenu(){
		ApiParam param=ApiManager.getInstance().getParameters(request);
		MenuView view=(MenuView) ParamUtil.convertToView(param, MenuView.class);
		menuService.saveMenu(view);
		return apiReturn;
	}
	
	@RequestMapping(value="update", method=RequestMethod.POST)
	public ApiReturn execUpdateMenu(){
		ApiParam param=ApiManager.getInstance().getParameters(request);
		MenuView view=(MenuView) ParamUtil.convertToView(param, MenuView.class);
		menuService.updateMenu(view);
		return apiReturn;
	}
	
	@RequestMapping(value="get", method=RequestMethod.POST)
	public ApiReturn execeditMenu(){
		ApiParam param=ApiManager.getInstance().getParameters(request);
		MenuView view=(MenuView) ParamUtil.convertToView(param, MenuView.class);
		List<?> menus=menuService.findAllMenus(view);
		apiReturn.setData(menus);
		return apiReturn;
	}
	
	@RequestMapping(value="refresh", method=RequestMethod.POST)
	public ApiReturn refreshMenus(){
		startupLoader.initSysMenus();
		return apiReturn;
	}
	
	@Autowired
	private IMenuService menuService;
	@Autowired
	private StartupLoader startupLoader;
}
