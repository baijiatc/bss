package cn.bjtc.dao.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import cn.bjtc.dao.IMenuDAO;
import cn.bjtc.dao.mybatis.MyBatisDAO;
import cn.bjtc.model.Menu;
import cn.bjtc.view.MenuView;

@Component("menuDAO")
public class MenuDAOImpl extends MyBatisDAO<Menu,Integer> implements IMenuDAO {

	public int saveMenu(MenuView view) {
		Menu menu=new Menu();
		BeanUtils.copyProperties(view, menu);
		return super.save("saveMenu", menu);
	}

	public int updateMenu(MenuView view) {
		return super.update("updateMenu", view);
	}

	public List<Menu> findAllMenus(MenuView view) {
		return super.findByParam("findAllMenus", view);
	}

	public Integer countAllMenus(MenuView view) {
		return super.countByParam("countAllMenus", view);
	}

	 
}
