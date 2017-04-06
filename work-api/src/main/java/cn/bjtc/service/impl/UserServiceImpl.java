package cn.bjtc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.bjtc.dao.IUserDAO;
import cn.bjtc.model.User;
import cn.bjtc.service.IUserService;

@Service("userService")
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserDAO userDAO;
	
	public void saveUser(User user) {
		userDAO.saveUser(user);
	}

	public List<User> findAllUser() {
		return userDAO.findAllUser();
	}

}
