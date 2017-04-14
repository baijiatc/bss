package cn.bjtc.dao.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import cn.bjtc.dao.ILoginDAO;
import cn.bjtc.dao.mybatis.MyBatisDAO;
import cn.bjtc.model.LoginUser;

@Component("loginDAO")
public class LoginDAOImpl extends MyBatisDAO<LoginUser,Integer> implements ILoginDAO {

	public List<LoginUser> findUserByName(String username) {
		return super.findByParam("findUserByName", username);
	}

}
