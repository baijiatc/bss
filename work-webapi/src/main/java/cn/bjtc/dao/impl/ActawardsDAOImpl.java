package cn.bjtc.dao.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import cn.bjtc.dao.IActawardsDAO;
import cn.bjtc.dao.mybatis.MyBatisDAO;
import cn.bjtc.model.Actawards;
import cn.bjtc.view.ActawardsView;

@Component("actawardsDao")
public  class ActawardsDAOImpl extends MyBatisDAO<Actawards, Integer> 
              implements  IActawardsDAO{

	public int saveActawards(ActawardsView view) {
		Actawards actawards=new Actawards();
		BeanUtils.copyProperties(view, actawards);
		return super.save("saveActawards", actawards);
	}

	public int updateActawards(ActawardsView view) {
		return super.update("updateActawards", view);
	}

	public List<Actawards> findAllActawards(ActawardsView view) {
		return super.findByParam("findAllActawards", view);
	}

	public Integer countAllActawards(ActawardsView view) {
		return super.countByParam("countAllActawards", view);
	}

	
	
	
	
	
	
	
	
}
