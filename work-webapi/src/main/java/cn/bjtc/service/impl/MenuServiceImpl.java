package cn.bjtc.service.impl;

import java.util.List;

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

	public List<Menu> findAllMenus(MenuView view) {
		return menuDAO.findAllMenus(view);
	}

	public Integer countAllMenus(MenuView view) {
		return menuDAO.countAllMenus(view);
	}
 

	@Autowired
	private IMenuDAO menuDAO;

}
