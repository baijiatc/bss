package cn.bjtc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.bjtc.dao.IMenuDAO;
import cn.bjtc.model.Menu;
import cn.bjtc.service.IMenuService;

@Service("menuService")
public class MenuServiceImpl implements IMenuService {
	
	@Autowired
	private IMenuDAO menuDAO;

	public List<Menu> findActMenus() {
		return null;
	}

}
