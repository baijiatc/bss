package cn.bjtc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.bjtc.dao.IRoleDAO;
import cn.bjtc.model.Role;
import cn.bjtc.service.IRoleService;
import cn.bjtc.view.RoleView;

@Service("roleService")
public class RoleServiceImpl implements IRoleService {

	public int saveRole(RoleView view) {
		return roleDAO.saveRole(view);
	}

	public int updateRole(RoleView view) {
		return roleDAO.updateRole(view);
	}

	public List<Role> findAllRoles(RoleView view) {
		return roleDAO.findAllRoles(view);
	}

	public Integer countAllRoles(RoleView view) {
		return roleDAO.countAllRoles(view);
	}
	
	@Autowired
	private IRoleDAO roleDAO;

}
