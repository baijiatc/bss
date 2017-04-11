package cn.bjtc.service;

import java.util.List;

import cn.bjtc.model.Staffobj;
import cn.bjtc.view.StaffobjView;

public interface IStaffobjService {

	public int saveStaffobj(StaffobjView view);
	public int updateStaffobj(StaffobjView view);
	public List<Staffobj> findAllStaffobj(StaffobjView view);
	public Integer countAllStaffobj(StaffobjView view);
}
