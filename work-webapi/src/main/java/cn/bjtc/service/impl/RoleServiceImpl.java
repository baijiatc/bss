package cn.bjtc.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
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

	public List<RoleView> findAllRoles(RoleView view) {
		List<Role> roles = roleDAO.findAllRoles(view);
		if(roles == null || roles.size() <= 0){
			return new ArrayList<RoleView>(0);
		}
		List<RoleView> views = new ArrayList<RoleView>(roles.size());
		for(Role role : roles){
			RoleView roleView = new RoleView();
			BeanUtils.copyProperties(role, roleView);
			views.add(roleView);
		}
		return views;
	}

	public Integer countAllRoles(RoleView view) {
		return roleDAO.countAllRoles(view);
	}
	
	@Autowired
	private IRoleDAO roleDAO;

}
