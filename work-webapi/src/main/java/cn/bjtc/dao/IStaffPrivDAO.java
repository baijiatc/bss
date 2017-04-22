package cn.bjtc.dao;

import cn.bjtc.model.StaffPriv;

public interface IStaffPrivDAO {
	
	public int saveStaffPriv(StaffPriv staffPriv);
	public int deleteStaffAllPriv(Object staffid);
}
