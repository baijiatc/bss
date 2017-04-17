package cn.bjtc.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.bjtc.dao.IPasswdDAO;
import cn.bjtc.service.IPasswdService;
import cn.bjtc.view.PasswdView;

@Service("passwdService")
public class PasswdServiceImpl implements IPasswdService {

	public int updatePasswd(PasswdView view) {
		return passwdDAO.updatePasswd(view);
	}
	@Autowired
	private IPasswdDAO passwdDAO;

}
