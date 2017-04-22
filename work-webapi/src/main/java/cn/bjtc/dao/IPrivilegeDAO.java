package cn.bjtc.dao;

import java.util.List;

import cn.bjtc.model.Privilege;
import cn.bjtc.view.PrivilegeView;

public interface IPrivilegeDAO {
	public int savePriv(PrivilegeView view);
	public int updatePriv(PrivilegeView view);
	public List<Privilege> findAllPrivs(PrivilegeView view);
	public Integer countAllPrivs(PrivilegeView view);
	
	public List<Privilege> findCurrentUserPrivs(Object uid);
}
