package cn.bjtc.dao.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import cn.bjtc.dao.IMenuPrivDAO;
import cn.bjtc.dao.mybatis.MyBatisDAO;
import cn.bjtc.model.MenuPriv;

@Component("menuPrivDAO")
public class MenuPrivDAO extends MyBatisDAO<MenuPriv, Integer> implements IMenuPrivDAO {

	public List<MenuPriv> findAllMenuPrivs() {
		return super.findByParam("findAllMenuPrivs", null);
	}

	public List<MenuPriv> findMenuPrivByRole(Object roleid) {
		return super.findByParam("findMenuPrivByRole", roleid);
	}

	public List<MenuPriv> findMenuPrivByStaff(Object staffid) {
		return super.findByParam("findMenuPrivByStaff", staffid);
	}

	public List<MenuPriv> findStaffRoleMenuPriv(Object staffid) {
		return super.findByParam("findStaffRoleMenuPriv", staffid);
	}

}
