package cn.bjtc.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.bjtc.dao.IActruleDAO;
import cn.bjtc.model.Actrule;
import cn.bjtc.service.IActruleService;
import cn.bjtc.view.ActruleView;

@Service("actruleService")
public class ActruleServiceImpl implements  IActruleService{

	public int saveActrule(ActruleView view) {
		 return actruleDao.saveActrule(view);
	}

	public int updateActrule(ActruleView view) {
		return actruleDao.updateActrule(view);
	}

	public List<Actrule> findAllActrules(ActruleView view) {
		return actruleDao.findAllActrules(view);
	}

	public Integer countAllActrules(ActruleView view) {
		return actruleDao.countAllActrules(view);
	}

	
	@Autowired
	private IActruleDAO actruleDao;
}
