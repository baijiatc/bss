package cn.bjtc.dao.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import cn.bjtc.dao.IRoleDAO;
import cn.bjtc.dao.mybatis.MyBatisDAO;
import cn.bjtc.model.Role;
import cn.bjtc.view.RoleView;

@Component("roleDAO")
public class RoleDAOImpl extends MyBatisDAO<Role, Integer> implements
		IRoleDAO {

	public int saveRole(RoleView view) {
		Role role = new Role();
		BeanUtils.copyProperties(view, role);
		return super.save("saveRole", role);
	}

	public int updateRole(RoleView view) {
		return super.update("updateRole", view);
	}

	public List<Role> findAllRoles(RoleView view) {
		return super.findByParam("findAllRoles", view);
	}

	public Integer countAllRoles(RoleView view) {
		return super.countByParam("countAllRoles", view);
	}

}
