package cn.bjtc.dao;

import java.util.List;

import cn.bjtc.model.User;

public interface IUserDAO {

	public void saveUser(User user);
	
	public List<User> findAllUser();
}
