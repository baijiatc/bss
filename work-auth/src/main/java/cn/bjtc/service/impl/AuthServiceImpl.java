package cn.bjtc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.bjtc.dao.ILoginDAO;
import cn.bjtc.model.LoginUser;
import cn.bjtc.service.IAuthService;

@Service("authService")
public class AuthServiceImpl implements IAuthService {

	public LoginUser findUserByName(String username) {
		LoginUser loginUser = new LoginUser();
		List<LoginUser> loginUsers = loginDAO.findUserByName(username);
		if(loginUsers != null && loginUsers.size() > 0){
			loginUser = loginUsers.get(0);
		}
		return loginUser;
	}

	@Autowired
	private ILoginDAO loginDAO;
}
