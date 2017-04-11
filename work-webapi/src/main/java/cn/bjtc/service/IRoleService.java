package cn.bjtc.service;

import java.util.List;

import cn.bjtc.model.Role;
import cn.bjtc.view.RoleView;

public interface IRoleService {

	public int saveRole(RoleView view);
	public int updateRole(RoleView view);
	public List<Role> findAllRoles(RoleView view);
	public Integer countAllRoles(RoleView view);
}
