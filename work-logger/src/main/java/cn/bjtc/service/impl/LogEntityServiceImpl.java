package cn.bjtc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.bjtc.dao.ILogEntityDAO;
import cn.bjtc.model.LogEntity;
import cn.bjtc.service.ILogEntityService;

@Service("logEntityService")
public class LogEntityServiceImpl implements ILogEntityService {

	public int saveLogEntity(LogEntity log) {
		return logEntityDAO.saveLogEntity(log);
	}
	
	@Autowired
	private ILogEntityDAO logEntityDAO;

}
