package cn.bjtc.dao.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import cn.bjtc.dao.IMenuDAO;
import cn.bjtc.dao.mybatis.MyBatisDAO;
import cn.bjtc.model.Menu;

@Component("menuDAO")
public class MenuDAOImpl extends MyBatisDAO<Menu,Integer> implements IMenuDAO {

	public void saveMenu(Menu menu) {
		super.save("saveMenu", menu);
	}

	public List<Menu> findMenuByParam(Object parameter) {
		return super.findByParam("findMenuByParam", parameter);
	}

	public Integer countMenuByParam(Object parameter) {
		return super.countByParam("countMenuByParam", parameter);
	}

}
