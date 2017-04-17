package cn.bjtc.service;

import java.util.List;

import cn.bjtc.model.ElemPriv;
import cn.bjtc.model.MenuPriv;
import cn.bjtc.model.Privilege;
import cn.bjtc.view.PrivilegeView;

public interface IPrivilegeService {

	public int savePriv(PrivilegeView view);
	public int updatePriv(PrivilegeView view);
	public List<Privilege> findAllPrivs(PrivilegeView view);
	public Integer countAllPrivs(PrivilegeView view);
	
	public int deleteRoleAllPriv(Object roleid);
	public int saveRolePriv(Object roleid,Object menuids, Object elemids);
	
	public int deleteStaffAllPriv(Object staffid);
	public int saveStaffPriv(Object staffid,Object menuids, Object elemids);
	
	public List<MenuPriv> findAllMenuPrivs();
	public List<ElemPriv> findAllElemPrivs();
	
	public List<Object> loadObjectPriv(Object objid, Object isRole);
}
