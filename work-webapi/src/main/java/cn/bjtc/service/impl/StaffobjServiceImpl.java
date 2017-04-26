package cn.bjtc.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.bjtc.dao.IStaffobjDAO;
import cn.bjtc.model.Staffobj;
import cn.bjtc.model.Staffobj;
import cn.bjtc.service.IStaffobjService;
import cn.bjtc.view.StaffobjView;
import cn.bjtc.view.StaffobjView;

@Service("staffobjService")
public class StaffobjServiceImpl implements IStaffobjService {

	public int saveStaffobj(StaffobjView view) {
		return staffobjDAO.saveStaffobj(view);
	}

	public int updateStaffobj(StaffobjView view) {
		return staffobjDAO.updateStaffobj(view);
	}

	public List<StaffobjView> findAllStaffobj(StaffobjView view) {
		List<Staffobj> Staffobjs = staffobjDAO.findAllStaffobj(view);
		if(Staffobjs == null || Staffobjs.size() <= 0){
			return new ArrayList<StaffobjView>(0);
		}
		List<StaffobjView> views = new ArrayList<StaffobjView>(Staffobjs.size());
		for(Staffobj Staffobj : Staffobjs){
			StaffobjView StaffobjView = new StaffobjView();
			BeanUtils.copyProperties(Staffobj, StaffobjView);
			views.add(StaffobjView);
		}
		return views;
	}

	public Integer countAllStaffobj(StaffobjView view) {
		return staffobjDAO.countAllStaffobj(view);
	}
	
	@Autowired
	private IStaffobjDAO staffobjDAO;

}
