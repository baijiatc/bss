package cn.bjtc.dao;

import java.util.List;
import java.util.Map;

public interface IScheduleDAO {

	public List<Map<String, Object>> getQrtzTriggers();
	
	public Integer countQrtzTriggers();
}
