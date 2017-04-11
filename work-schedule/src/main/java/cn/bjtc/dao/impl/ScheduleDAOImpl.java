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

	public Integer countQrtzTriggers() {
		String sql = "SELECT count(*) as qrtzcount FROM qrtz_triggers;";
		List<Map<String, Object>> countMapList= super.findAll(sql, null);
		if(countMapList == null || countMapList.size() == 0){
			return 0;
		}
		Map<String, Object> countMap = countMapList.get(0);
		if(countMap.isEmpty()){
			return 0;
		}
		try {
			return countMap.get("qrtzcount") == null?0:Integer.parseInt(countMap.get("qrtzcount").toString());
		} catch (Exception e) {
			return 0;
		}
	}

}
