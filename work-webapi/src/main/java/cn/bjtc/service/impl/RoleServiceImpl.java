package cn.bjtc.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	public List<RoleView> findAllRoleByStaffId(Object staffid) {
		RoleView view = new RoleView();
		view.setPageSize(100);
		List<Role> allRoles = roleDAO.findAllRoles(view);
		List<Role> staffRoles = roleDAO.findAllRoleByStaffId(staffid);
		Map<String,Role> staffRoleMap = new HashMap<String, Role>();
		for(Role role : staffRoles){
			staffRoleMap.put(role.getRolename(), role);
		}
		List<RoleView> views = new ArrayList<RoleView>(allRoles.size());
		for(Role role : allRoles){
			RoleView roleView = new RoleView();
			if(staffRoleMap.containsKey(role.getRolename())){
				roleView.setChecked(true);
			}
			BeanUtils.copyProperties(role, roleView);
			views.add(roleView);
		}
		return views;
	}

	@Autowired
	private IRoleDAO roleDAO;

}
