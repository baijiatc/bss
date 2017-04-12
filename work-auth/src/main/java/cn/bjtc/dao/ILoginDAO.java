package cn.bjtc.dao;

import java.util.List;

import cn.bjtc.model.LoginUser;

public interface ILoginDAO {
	public List<LoginUser> findUserByName(String username);
}
