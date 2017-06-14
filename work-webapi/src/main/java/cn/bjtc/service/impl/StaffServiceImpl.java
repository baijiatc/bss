package cn.bjtc.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.bjtc.dao.IDepartDAO;
import cn.bjtc.dao.IStaffDAO;
import cn.bjtc.model.Depart;
import cn.bjtc.model.Staff;
import cn.bjtc.service.IStaffService;
import cn.bjtc.view.DepartView;
import cn.bjtc.view.StaffView;

@Service("staffService")
public class StaffServiceImpl implements IStaffService {

	public int saveStaff(StaffView view) {
		return staffDAO.saveStaff(view);
	}

	public int updateStaff(StaffView view) {
		return staffDAO.updateStaff(view);
	}

	public List<StaffView> findAllStaff(StaffView view) {
		List<Staff> staffs = staffDAO.findAllStaff(view);
		if(staffs == null || staffs.size() <= 0){
			return new ArrayList<StaffView>(0);
		}
		DepartView dpView = new DepartView();
		dpView.setPageSize(100);
		List<Depart> departs = departDAO.findAllDepart(dpView);
		Map<String, String> departMap = new HashMap<String,String>(departs == null ? 0 : departs.size());
		for(Depart depart : departs){
			departMap.put("d"+depart.getDepartid(), depart.getDepartname());
		}
		List<StaffView> views = new ArrayList<StaffView>(staffs.size());
		for(Staff staff : staffs){
			StaffView staffsView = new StaffView();
			BeanUtils.copyProperties(staff, staffsView);
			staffsView.setDepartname(departMap.get("d"+staff.getDepartid()));
			views.add(staffsView);
		}
		return views;
	}

	public Integer countAllStaff(StaffView view) {
		return staffDAO.countAllStaff(view);
	}
	
	@Autowired
	private IStaffDAO staffDAO;
	@Autowired
	private IDepartDAO departDAO;

}
