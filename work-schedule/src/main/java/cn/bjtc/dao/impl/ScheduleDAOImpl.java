package cn.bjtc.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import cn.bjtc.dao.IScheduleDAO;
import cn.bjtc.dao.jdbc.spring.SpringJdbcDAO;

@Component("scheduleDAO")
public class ScheduleDAOImpl extends SpringJdbcDAO<Map<String, Object>, Integer> implements
		IScheduleDAO {

	public List<Map<String, Object>> getQrtzTriggers() {
		String sql = "SELECT * FROM qrtz_triggers;";
		return super.findAll(sql, null);
	}

}
