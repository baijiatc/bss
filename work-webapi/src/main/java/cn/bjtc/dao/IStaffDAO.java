package cn.bjtc.dao;

import java.util.List;

import cn.bjtc.model.Privilege;
import cn.bjtc.model.Staff;
import cn.bjtc.view.PrivilegeView;
import cn.bjtc.view.StaffView;

public interface IStaffDAO {
	public int saveStaff(StaffView view);
	public int updateStaff(StaffView view);
	public List<Staff> findAllStaff(StaffView view);
	public List<Staff> findAllDepartName(StaffView view);
	public Integer countAllStaff(StaffView view);
}
