package cn.bjtc.dao.impl;



import org.springframework.stereotype.Component;

import cn.bjtc.dao.IStaffroleDAO;
import cn.bjtc.dao.mybatis.MyBatisDAO;
import cn.bjtc.model.Staffrole;

@Component("StaffroleDAO")
public class StaffroleDAOImpl extends MyBatisDAO<Staffrole, Integer> implements
		IStaffroleDAO {


	public int deleteById(Object staffid) {
		return super.delete("delectById", staffid);
	}

	public int createStaffrole(Staffrole staffrole) {
		return super.save("createStaffrole", staffrole);
	}
	
}
