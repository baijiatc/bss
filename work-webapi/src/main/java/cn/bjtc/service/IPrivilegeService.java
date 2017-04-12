package cn.bjtc.service;

import java.util.List;

import cn.bjtc.model.Privilege;
import cn.bjtc.view.PrivilegeView;

public interface IPrivilegeService {

	public int savePriv(PrivilegeView view);
	public int updatePriv(PrivilegeView view);
	public List<Privilege> findAllPrivs(PrivilegeView view);
	public Integer countAllPrivs(PrivilegeView view);
}
