package cn.bjtc.service;

import cn.bjtc.model.LoginUser;

public interface IAuthService {

	public LoginUser findUserByName(String username);
}
