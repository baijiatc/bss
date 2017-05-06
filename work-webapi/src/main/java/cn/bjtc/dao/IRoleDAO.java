package cn.bjtc.dao;

import java.util.List;

import cn.bjtc.model.Role;
import cn.bjtc.view.RoleView;

public interface IRoleDAO {

	public int saveRole(RoleView view);
	public int updateRole(RoleView view);
	public List<Role> findAllRoles(RoleView view);
	public Integer countAllRoles(RoleView view);
	
	public List<Role> findAllRoleByStaffId(Object staffid);
}
