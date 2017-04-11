package cn.bjtc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.bjtc.dao.ISyslogDao;
import cn.bjtc.model.Syslog;
import cn.bjtc.service.ISyslogService;
import cn.bjtc.view.SyslogView;
 

@Service("syslogService")
public class SyslogServiceImpl  implements  ISyslogService{

	public List<Syslog> findAllSys(SyslogView view) {
		return syslogDao.findAllSys(view);
	}

	public Integer countAllSys(SyslogView view) {
		return syslogDao.countAllSys(view);
	}
	
	
	@Autowired
	private ISyslogDao syslogDao;

 
	
	
}
