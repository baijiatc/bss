package cn.bjtc.dao.impl;

import org.springframework.stereotype.Component;

import cn.bjtc.dao.IPasswdDAO;
import cn.bjtc.dao.mybatis.MyBatisDAO;
import cn.bjtc.model.Passwd;
import cn.bjtc.view.PasswdView;

@Component("passwdDAO")
public class PasswdDAOImpl extends MyBatisDAO<Passwd, Integer> implements
		IPasswdDAO {

	public int updatePasswd(PasswdView view) {
		return super.update("updatePasswd", view);
	}
}
