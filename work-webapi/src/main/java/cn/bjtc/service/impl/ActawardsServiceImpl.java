package cn.bjtc.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.bjtc.dao.IActawardsDAO;
import cn.bjtc.model.Actawards;
import cn.bjtc.service.IActawardsService;
import cn.bjtc.view.ActawardsView;

@Service("actawardsService")
public class ActawardsServiceImpl implements  IActawardsService{

	public int saveActawards(ActawardsView view) {
		 return actawardsDao.saveActawards(view);
	}

	public int updateActawards(ActawardsView view) {
		return actawardsDao.updateActawards(view);
	}

	public List<Actawards> findAllActawards(ActawardsView view) {
		return actawardsDao.findAllActawards(view);
	}

	public Integer countAllActawards(ActawardsView view) {
		return actawardsDao.countAllActawards(view);
	}

	
	@Autowired
	private IActawardsDAO actawardsDao;
}
