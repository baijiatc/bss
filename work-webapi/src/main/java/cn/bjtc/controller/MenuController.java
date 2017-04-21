package cn.bjtc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
		 try {
			ApiParam param=findApiParam();
			 MenuView view=(MenuView) ParamUtil.convertToView(param, MenuView.class);
			 int count=menuService.countAllMenus(view);
			 List<?> menus=menuService.findAllMenus(view);
			 apiReturn.setCount(count);
			 apiReturn.setData(menus);
		} catch (Exception e) {
			showServerError();
		}
		 return apiReturn; 
	}
	
	@RequestMapping(value="create", method=RequestMethod.POST)
	public ApiReturn execAddMenu(){
		try {
			ApiParam param=findApiParam();
			ifParamDataIsEmpty(param);
			MenuView view=(MenuView) ParamUtil.convertToView(param, MenuView.class);
			menuService.saveMenu(view);
		} catch (Exception e) {
			showServerError();
		}
		return apiReturn;
	}
	
	@RequestMapping(value="update", method=RequestMethod.POST)
	public ApiReturn execUpdateMenu(){
		try {
			ApiParam param=findApiParam();
			ifParamDataIsEmpty(param);
			MenuView view=(MenuView) ParamUtil.convertToView(param, MenuView.class);
			menuService.updateMenu(view);
		} catch (Exception e) {
			showServerError();
		}
		return apiReturn;
	}
	
	@RequestMapping(value="get", method=RequestMethod.POST)
	public ApiReturn execeditMenu(){
		try {
			ApiParam param=findApiParam();
			ifParamDataIsEmpty(param);
			MenuView view=(MenuView) ParamUtil.convertToView(param, MenuView.class);
			List<?> menus=menuService.findAllMenus(view);
			apiReturn.setData(menus);
		} catch (Exception e) {
			showServerError();
		}
		return apiReturn;
	}
	
	@RequestMapping(value="refresh", method=RequestMethod.POST)
	public ApiReturn refreshMenus(){
		try {
			startupLoader.initSysMenus();
		} catch (Exception e) {
			showServerError();
		}
		return apiReturn;
	}
	
	@Autowired
	private IMenuService menuService;
	@Autowired
	private StartupLoader startupLoader;
}
