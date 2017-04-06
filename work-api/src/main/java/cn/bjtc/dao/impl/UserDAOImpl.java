package cn.bjtc.dao.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import cn.bjtc.dao.IUserDAO;
import cn.bjtc.dao.hibernate.HibernateDAO;
import cn.bjtc.model.User;

@Component("userDAO")
public class UserDAOImpl extends HibernateDAO<User,Integer> implements IUserDAO {

	public void saveUser(User user) {
		//super.save("saveUser", user);
	}

	public List<User> findAllUser() {
		return super.findAll("FROM User", null);
	}
	
}
