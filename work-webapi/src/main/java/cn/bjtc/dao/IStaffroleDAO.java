package cn.bjtc.dao;

import cn.bjtc.model.Staffrole;



public interface IStaffroleDAO {
	public int createStaffrole(Staffrole staffrole);
	public int deleteById(Object staffid);
}
