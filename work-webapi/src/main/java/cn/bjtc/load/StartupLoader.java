package cn.bjtc.load;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.bjtc.api.ApiManager;
import cn.bjtc.model.Api;
import cn.bjtc.model.Menu;
import cn.bjtc.model.SysParam;
import cn.bjtc.service.IApiService;
import cn.bjtc.service.IMenuService;
import cn.bjtc.service.ISysParamService;
import cn.bjtc.tools.ApplicationDataManager;
import cn.bjtc.view.ApiView;
import cn.bjtc.view.MenuView;
import cn.bjtc.view.SysParamView;

public class StartupLoader {
	
	public void init(){
		initApiMap();
		initSysParam();
		initSysMenus();
	}
	
	public void initApiMap(){
		ApiView view = new ApiView();
		view.setApist(1);
		view.setPageSize(Integer.MAX_VALUE);
		List<Api> apis = apiService.findAllApis(view);
		for(Api api : apis){
			ApiManager.API_MAP.put(api.getCode(), api.getApiurl());
		}
	}
	
	public void initSysParam(){
		SysParamView view = new SysParamView();
		view.setPageSize(Integer.MAX_VALUE);
		List<SysParam> sysParams = sysParmService.findAllSysParams(view);
		for(SysParam sysParam : sysParams){
			ApplicationDataManager.SYSPARAMS.put(sysParam.getCode(), sysParam.getParamvalue());
		}
	}
	
	public void initSysMenus(){
		MenuView view = new MenuView();
		view.setParentid(0);
		view.setPageSize(50);
		view.setMenust(1);
		List<Menu> pmenus = menuService.findAllMenus(view);
		for(Menu parent : pmenus){
			MenuView view2 = new MenuView();
			view2.setParentid(parent.getMenuid());
			view2.setPageSize(50);
			view2.setMenust(1);
			List<Menu> cmenus = menuService.findAllMenus(view2);
			Object[] objs = {parent,cmenus};
			ApplicationDataManager.SYSMENUS.add(objs);
		}
	}
	
	@Autowired
	private IApiService apiService;
	@Autowired
	private ISysParamService sysParmService;
	@Autowired
	private IMenuService menuService;
}
