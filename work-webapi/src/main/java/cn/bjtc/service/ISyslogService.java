package cn.bjtc.service;

import java.util.List;

import cn.bjtc.model.Syslog;
import cn.bjtc.view.SyslogView;
 

 
public interface ISyslogService {
	public List<Syslog> findAllSys(SyslogView view);
	public Integer countAllSys(SyslogView view);	
		
	
}
