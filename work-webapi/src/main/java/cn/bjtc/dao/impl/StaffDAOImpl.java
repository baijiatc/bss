package cn.bjtc.dao.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import cn.bjtc.dao.IStaffDAO;
import cn.bjtc.dao.mybatis.MyBatisDAO;
import cn.bjtc.model.Staff;
import cn.bjtc.view.StaffView;

@Component("staffDAO")
public class StaffDAOImpl extends MyBatisDAO<Staff, Integer> implements
		IStaffDAO {

	public int saveStaff(StaffView view) {
		Staff staff = new Staff();
		BeanUtils.copyProperties(view, staff);
		return super.save("saveStaff", staff);
	}

	public int updateStaff(StaffView view) {
		return super.update("updateStaff", view);
	}

	public List<Staff> findAllStaff(StaffView view) {
		return super.findByParam("findAllStaff", view);
	}

	public Integer countAllStaff(StaffView view) {
		return super.countByParam("countAllStaff", view);
	}

}
