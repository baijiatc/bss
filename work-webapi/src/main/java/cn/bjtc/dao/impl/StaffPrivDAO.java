package cn.bjtc.dao.impl;

import org.springframework.stereotype.Component;

import cn.bjtc.dao.IStaffPrivDAO;
import cn.bjtc.dao.mybatis.MyBatisDAO;
import cn.bjtc.model.StaffPriv;

@Component("staffPrivDAO")
public class StaffPrivDAO extends MyBatisDAO<StaffPriv, Integer> implements IStaffPrivDAO {

	public int saveStaffPriv(StaffPriv staffPriv) {
		return super.save("saveStaffPriv", staffPriv);
	}

	public int deleteStaffAllPriv(Object staffid) {
		return super.delete("deleteStaffAllPriv", staffid);
	}

}
