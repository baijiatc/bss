package cn.bjtc.dao;

import java.util.List;

import cn.bjtc.model.MenuPriv;

public interface IMenuPrivDAO {
	
	public List<MenuPriv> findAllMenuPrivs();
	public List<MenuPriv> findMenuPrivByRole(Object roleid);
	public List<MenuPriv> findMenuPrivByStaff(Object staffid);
	public List<MenuPriv> findStaffRoleMenuPriv(Object staffid);
}
