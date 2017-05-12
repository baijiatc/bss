package cn.bjtc.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.bjtc.dao.IMenuDAO;
import cn.bjtc.model.Menu;
import cn.bjtc.service.IMenuService;
import cn.bjtc.view.MenuView;

@Service("menuService")
public class MenuServiceImpl implements IMenuService {


	public int saveMenu(MenuView view) {
		return menuDAO.saveMenu(view);
	}

	public int updateMenu(MenuView view) {
		return  menuDAO.updateMenu(view);
	}

	public List<MenuView> findAllMenus(MenuView view) {
		List<Menu> menus = menuDAO.findAllMenus(view);
		if(menus == null){
			return new ArrayList<MenuView>(0);
		}
		MenuView _view = new MenuView();
		_view.setPageSize(100);
		List<Menu> allmenuLst = menuDAO.findAllMenus(_view);
		Map<String, String> parentMap = new HashMap<String, String>(allmenuLst==null?0:allmenuLst.size());
		for(Menu menu : allmenuLst){
			parentMap.put("P"+menu.getMenuid(), menu.getMenuname());
		}
		List<MenuView> views = new ArrayList<MenuView>(menus.size());
		for(Menu menu : menus){
			MenuView menuView = new MenuView();
			BeanUtils.copyProperties(menu, menuView);
			menuView.setParentname(parentMap.get("P"+menu.getParentid()));
			views.add(menuView);
		}
		return views;
	}

	public Integer countAllMenus(MenuView view) {
		return menuDAO.countAllMenus(view);
	}
 

	public Menu findNameById(MenuView view) {
		List<Menu> menus=menuDAO.findAllMenus(view);
		Menu menuu=new Menu();
		Map<Object,String> menuMap=new HashMap<Object,String>(menus.size());
		for(Menu menu:menus){
			menuMap.put('m'+menu.getParentid(),menu.getParentname());
		}
		menuu.setParentname(menuMap.get('m'+menuu.getMenuid()) ); 
		return menuu;
	}
	
	

	@Autowired
	private IMenuDAO menuDAO;
	
	

}
