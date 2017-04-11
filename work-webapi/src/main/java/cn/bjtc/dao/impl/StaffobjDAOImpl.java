package cn.bjtc.dao.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import cn.bjtc.dao.IStaffobjDAO;
import cn.bjtc.dao.mybatis.MyBatisDAO;
import cn.bjtc.model.Staffobj;
import cn.bjtc.view.StaffobjView;

@Component("staffobjDAO")
public class StaffobjDAOImpl extends MyBatisDAO<Staffobj, Integer> implements
		IStaffobjDAO {

	public int saveStaffobj(StaffobjView view) {
		Staffobj staffobj = new Staffobj();
		BeanUtils.copyProperties(view, staffobj);
		return super.save("saveStaffobj", staffobj);
	}

	public int updateStaffobj(StaffobjView view) {
		return super.update("updateStaffobj", view);
	}

	public List<Staffobj> findAllStaffobj(StaffobjView view) {
		return super.findByParam("findAllStaffobj", view);
	}

	public Integer countAllStaffobj(StaffobjView view) {
		return super.countByParam("countAllStaffobj", view);
	}

}
