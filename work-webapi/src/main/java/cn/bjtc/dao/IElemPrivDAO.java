package cn.bjtc.dao;

import java.util.List;

import cn.bjtc.model.ElemPriv;

public interface IElemPrivDAO {
	
	public List<ElemPriv> findAllElemPrivs();
	public List<ElemPriv> findElemPrivByRole(Object roleid);
	public List<ElemPriv> findElemPrivByStaff(Object staffid);
	public List<ElemPriv> findStaffRoleElemPriv(Object staffid);
}
