package cn.bjtc.load;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import cn.bjtc.common.ApplicationDataManager;
import cn.bjtc.model.Dictionary;
import cn.bjtc.model.ElemPriv;
import cn.bjtc.model.MenuPriv;
import cn.bjtc.model.SysParam;
import cn.bjtc.service.IApiService;
import cn.bjtc.service.IDictService;
import cn.bjtc.service.IElementService;
import cn.bjtc.service.IFactorService;
import cn.bjtc.service.IMenuService;
import cn.bjtc.service.IPrivilegeService;
import cn.bjtc.service.IRegionService;
import cn.bjtc.service.ISysParamService;
import cn.bjtc.view.ApiView;
import cn.bjtc.view.DictionaryView;
import cn.bjtc.view.FactorView;
import cn.bjtc.view.MenuView;
import cn.bjtc.view.RegionView;
import cn.bjtc.view.SysParamView;

public class StartupLoader {
	
	public void init(){
		initApiMap();
		initSysParam();
		initSysMenus();
		initDicts();
		initMenuPriv();
		initElemPriv();
		initSysFactors();
		initRegions();
	}
	
	public void initApiMap(){
		ApplicationDataManager.SYSAPIMAP.clear();
		ApiView view = new ApiView();
		view.setApist(1);
		view.setPageSize(Integer.MAX_VALUE);
		List<ApiView> apis = apiService.findAllApis(view);
		for(ApiView api : apis){
			ApplicationDataManager.SYSAPIMAP.put(api.getCode(), api.getApiurl());
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
		List<MenuView> pmenus = menuService.findAllMenus(view);
		for(MenuView parent : pmenus){
			view.setParentid(parent.getMenuid());
			List<MenuView> cmenus = menuService.findAllMenus(view);
			List m2elemList = new ArrayList();
			for(MenuView child : cmenus){
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
		List<DictionaryView> baseDicts = dictService.findAllDicts(view);
		for(DictionaryView base : baseDicts){
			view.setDicttype(base.getDictid());
			List<DictionaryView> concetDicts = dictService.findAllDicts(view);
			Map<String, String> concetMap = new HashMap<String,String>();
			for(DictionaryView concet : concetDicts){
				concetMap.put(concet.getDictval(), concet.getDictname());
			}
			ApplicationDataManager.SYSDICTS.put(base.getDictval(), concetMap);
		}
	}
	
	public void initMenuPriv(){
		ApplicationDataManager.SYSMENUPRIVS.clear();
		List<MenuPriv> mpList = privilegeService.findAllMenuPrivs();
		for(MenuPriv mp : mpList){
			ApplicationDataManager.SYSMENUPRIVS.put(ApplicationDataManager.DEFAULT_KEY+mp.getMenuid(), mp.getPrivid());
		}
	}
	
	public void initElemPriv(){
		ApplicationDataManager.SYSELEMPRIVS.clear();
		List<ElemPriv> mpList = privilegeService.findAllElemPrivs();
		for(ElemPriv mp : mpList){
			ApplicationDataManager.SYSELEMPRIVS.put(ApplicationDataManager.DEFAULT_KEY+mp.getElemid().toString(), mp.getPrivid());
		}
	}
	
	public void initSysFactors(){
		ApplicationDataManager.SYSFACTORS.clear();
		ApplicationDataManager.SYSFACTORSRESERVE.clear();
		FactorView view = new FactorView();
		view.setPageSize(50);
		List<FactorView> fvLst = factorService.findAllFactors(view);
		for(FactorView factView : fvLst){
			ApplicationDataManager.SYSFACTORS.put(factView.getFactname(), factView.getFactid());
			ApplicationDataManager.SYSFACTORSRESERVE.put(ApplicationDataManager.DEFAULT_KEY+factView.getFactid().toString(),factView.getFactname());
		}
	}
	
	public void initRegions(){
		List<RegionView> provinceLst = regionService.findRegionByParent(0);
		ApplicationDataManager.SYSREGIONS.put(ApplicationDataManager.DEFAULT_KEY+0, provinceLst);
		for(RegionView province : provinceLst){
			List<RegionView> cityLst = regionService.findRegionByParent(province.getRegionid());
			ApplicationDataManager.SYSREGIONS.put(ApplicationDataManager.DEFAULT_KEY+province.getRegionid(), cityLst);
			for(RegionView city : cityLst){
				List<RegionView> districtLst = regionService.findRegionByParent(city.getRegionid());
				ApplicationDataManager.SYSREGIONS.put(ApplicationDataManager.DEFAULT_KEY+city.getRegionid(), districtLst);
			}
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
	@Autowired
	private IPrivilegeService privilegeService;
	@Autowired
	private IFactorService factorService;
	@Autowired
	private IRegionService regionService;
}
