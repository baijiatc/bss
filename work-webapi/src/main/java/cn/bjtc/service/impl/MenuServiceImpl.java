package cn.bjtc.service.impl;

import java.util.ArrayList;
import java.util.List;

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
		List<MenuView> views = new ArrayList<MenuView>(menus.size());
		for(Menu menu : menus){
			MenuView menuView = new MenuView();
			BeanUtils.copyProperties(menu, menuView);
			views.add(menuView);
		}
		return views;
	}

	public Integer countAllMenus(MenuView view) {
		return menuDAO.countAllMenus(view);
	}
 

	@Autowired
	private IMenuDAO menuDAO;

}
