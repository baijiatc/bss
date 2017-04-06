package cn.bjtc.dao;

import java.util.List;

import cn.bjtc.model.Menu;

public interface IMenuDAO {

	public void saveMenu(Menu menu);
	
	public List<Menu> findMenuByParam(Object parameter);
	
	public Integer countMenuByParam(Object parameter);
}
