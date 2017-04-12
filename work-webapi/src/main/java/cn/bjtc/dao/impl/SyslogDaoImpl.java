package cn.bjtc.dao.impl;

import java.util.List;

import org.springframework.stereotype.Component;
 
import cn.bjtc.dao.ISyslogDao;
import cn.bjtc.dao.mybatis.MyBatisDAO;
import cn.bjtc.model.Syslog;
import cn.bjtc.view.SyslogView;


@Component("syslogDao")
public class SyslogDaoImpl extends MyBatisDAO<Syslog, Integer>  implements
            ISyslogDao{

	public List<Syslog> findAllSys(SyslogView view) {
		return super.findByParam("findAllSys", view);
	}

	public Integer countAllSys(SyslogView view) {
		return  super.countByParam("countAllSys",view);
	}

	 

 
 
}
