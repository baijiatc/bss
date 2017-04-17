package cn.bjtc.service;

import java.util.List;

import cn.bjtc.view.MenuView;

public interface IMenuService {

	public int saveMenu(MenuView view);
	public int updateMenu(MenuView view);
    public List<MenuView> findAllMenus(MenuView view);
	public Integer countAllMenus(MenuView view);
}
