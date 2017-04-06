package cn.bjtc.service;

import java.util.List;

import cn.bjtc.model.User;

public interface IUserService {
	public void saveUser(User user);
	public List<User> findAllUser();
}
