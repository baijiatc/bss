package cn.bjtc.load;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import cn.bjtc.api.ApiManager;
import cn.bjtc.model.Api;
import cn.bjtc.model.Dictionary;
import cn.bjtc.model.Menu;
import cn.bjtc.model.SysParam;
import cn.bjtc.service.IApiService;
import cn.bjtc.service.IDictService;
import cn.bjtc.service.IElementService;
import cn.bjtc.service.IMenuService;
import cn.bjtc.service.ISysParamService;
import cn.bjtc.tools.ApplicationDataManager;
import cn.bjtc.view.ApiView;
import cn.bjtc.view.DictionaryView;
import cn.bjtc.view.MenuView;
import cn.bjtc.view.SysParamView;

public class StartupLoader {
	
	public void init(){
		initApiMap();
		initSysParam();
		initSysMenus();
		initDicts();
	}
	
	public void initApiMap(){
		ApiManager.API_MAP.clear();
		ApiView view = new ApiView();
		view.setApist(1);
		view.setPageSize(Integer.MAX_VALUE);
		List<Api> apis = apiService.findAllApis(view);
		for(Api api : apis){
			ApiManager.API_MAP.put(api.getCode(), api.getApiurl());
		}
	}
	
	public void initSysParam(){
		ApplicationDataManager.SYSPARAMS.clear();
		SysParamView view = new SysParamView();
		view.setPageSize(Integer.MAX_VALUE);
		List<SysParam> sysParams = sysParmService.findAllSysParams(view);
		for(SysParam sysParam : sysParams){
			ApplicationDataManager.SYSPARAMS.put(sysParam.getCode(), sysParam.getParamvalue());
		}
	}
	
	public void initSysMenus(){
		ApplicationDataManager.SYSMENUS.clear();
		MenuView view = new MenuView();
		view.setParentid(0);
		view.setPageSize(50);
		view.setMenust(1);
		List<Menu> pmenus = menuService.findAllMenus(view);
		for(Menu parent : pmenus){
			view.setParentid(parent.getMenuid());
			List<Menu> cmenus = menuService.findAllMenus(view);
			List m2elemList = new ArrayList();
			for(Menu child : cmenus){
				List<?> elems = elemService.findElementsByMenuId(child.getMenuid());
				Object[] m2elem = {child,elems};
				m2elemList.add(m2elem);
			}
			Object[] p2child = {parent,m2elemList};
			ApplicationDataManager.SYSMENUS.add(p2child);
		}
	}
	
	public void initDicts(){
		ApplicationDataManager.SYSDICTS.clear();
		DictionaryView view = new DictionaryView();
		view.setPageSize(Integer.MAX_VALUE);
		view.setDicttype(0);
		List<Dictionary> baseDicts = dictService.findAllDicts(view);
		for(Dictionary base : baseDicts){
			view.setDicttype(base.getDictid());
			List<Dictionary> concetDicts = dictService.findAllDicts(view);
			Map<String, String> concetMap = new HashMap<String,String>();
			for(Dictionary concet : concetDicts){
				concetMap.put(concet.getDictval(), concet.getDictname());
			}
			ApplicationDataManager.SYSDICTS.put(base.getDictval(), concetMap);
		}
	}
	
	@Autowired
	private IApiService apiService;
	@Autowired
	private ISysParamService sysParmService;
	@Autowired
	private IMenuService menuService;
	@Autowired
	private IElementService elemService;
	@Autowired
	private IDictService dictService;
}
