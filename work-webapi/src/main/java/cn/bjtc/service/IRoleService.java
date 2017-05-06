package cn.bjtc.service;

import java.util.List;

import cn.bjtc.view.RoleView;

public interface IRoleService {

	public int saveRole(RoleView view);
	public int updateRole(RoleView view);
	public List<RoleView> findAllRoles(RoleView view);
	public Integer countAllRoles(RoleView view);
	
	public List<RoleView> findAllRoleByStaffId(Object staffid);
}
