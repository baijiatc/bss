package cn.bjtc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.bjtc.dao.IPrivilegeDAO;
import cn.bjtc.model.Privilege;
import cn.bjtc.service.IPrivilegeService;
import cn.bjtc.view.PrivilegeView;

@Service("privilegeService")
public class PrivilegeServiceImpl implements IPrivilegeService {

	public int savePriv(PrivilegeView view) {
		return privilegeDAO.savePriv(view);
	}

	public int updatePriv(PrivilegeView view) {
		return privilegeDAO.updatePriv(view);
	}

	public List<Privilege> findAllPrivs(PrivilegeView view) {
		return privilegeDAO.findAllPrivs(view);
	}

	public Integer countAllPrivs(PrivilegeView view) {
		return privilegeDAO.countAllPrivs(view);
	}
	
	@Autowired
	private IPrivilegeDAO privilegeDAO;

}
