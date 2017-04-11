package cn.bjtc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.bjtc.dao.IStaffobjDAO;
import cn.bjtc.model.Staffobj;
import cn.bjtc.service.IStaffobjService;
import cn.bjtc.view.StaffobjView;

@Service("staffobjService")
public class StaffobjServiceImpl implements IStaffobjService {

	public int saveStaffobj(StaffobjView view) {
		return staffobjDAO.saveStaffobj(view);
	}

	public int updateStaffobj(StaffobjView view) {
		return staffobjDAO.updateStaffobj(view);
	}

	public List<Staffobj> findAllStaffobj(StaffobjView view) {
		return staffobjDAO.findAllStaffobj(view);
	}

	public Integer countAllStaffobj(StaffobjView view) {
		return staffobjDAO.countAllStaffobj(view);
	}
	
	@Autowired
	private IStaffobjDAO staffobjDAO;

}
