package cn.bjtc.dao.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
 
import cn.bjtc.dao.IActruleDAO;
import cn.bjtc.dao.mybatis.MyBatisDAO;
import cn.bjtc.model.Actrule;
import cn.bjtc.view.ActruleView;

@Component("actruleDao")
public  class ActruleDAOImpl extends MyBatisDAO<Actrule, Integer> 
              implements  IActruleDAO{

	public int saveActrule(ActruleView view) {
		Actrule actrule=new Actrule();
		BeanUtils.copyProperties(view, actrule);
		return super.save("saveActrule", actrule);
	}

	public int updateActrule(ActruleView view) {
		return super.update("updateActrule", view);
	}

	public List<Actrule> findAllActrules(ActruleView view) {
		return super.findByParam("findAllActrules", view);
	}

	public Integer countAllActrules(ActruleView view) {
		return super.countByParam("countAllActrules", view);
	}

	
	
	
	
	
	
	
	
}
