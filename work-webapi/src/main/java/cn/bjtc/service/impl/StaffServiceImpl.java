package cn.bjtc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.bjtc.dao.IStaffDAO;
import cn.bjtc.model.Staff;
import cn.bjtc.service.IStaffService;
import cn.bjtc.view.StaffView;

@Service("staffService")
public class StaffServiceImpl implements IStaffService {

	public int saveStaff(StaffView view) {
		return staffDAO.saveStaff(view);
	}

	public int updateStaff(StaffView view) {
		return staffDAO.updateStaff(view);
	}

	public List<Staff> findAllStaff(StaffView view) {
		return staffDAO.findAllStaff(view);
	}

	public Integer countAllStaff(StaffView view) {
		return staffDAO.countAllStaff(view);
	}
	
	@Autowired
	private IStaffDAO staffDAO;

}
