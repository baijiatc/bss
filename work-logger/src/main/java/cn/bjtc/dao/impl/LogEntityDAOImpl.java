package cn.bjtc.dao.impl;

import org.springframework.stereotype.Component;

import cn.bjtc.dao.ILogEntityDAO;
import cn.bjtc.dao.mybatis.MyBatisDAO;
import cn.bjtc.model.LogEntity;

@Component("logEntityDAO")
public class LogEntityDAOImpl extends MyBatisDAO<LogEntity, Integer> implements
		ILogEntityDAO {

	public int saveLogEntity(LogEntity log) {
		return super.save("saveLogEntity", log);
	}

}
