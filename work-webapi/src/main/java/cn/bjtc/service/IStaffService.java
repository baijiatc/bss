package cn.bjtc.service;

import java.util.List;

import cn.bjtc.view.StaffView;

public interface IStaffService {

	public int saveStaff(StaffView view);
	public int updateStaff(StaffView view);
	public List<StaffView> findAllStaff(StaffView view);
	public Integer countAllStaff(StaffView view);
}
