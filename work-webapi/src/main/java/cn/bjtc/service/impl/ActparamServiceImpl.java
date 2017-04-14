package cn.bjtc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.bjtc.dao.IActparamDAO;
import cn.bjtc.model.Actparam;
import cn.bjtc.service.IActparamService;
import cn.bjtc.view.ActparamView;

@Service("actparamService")
public class ActparamServiceImpl implements IActparamService {

	public int saveActparam(ActparamView view) {
		 return actparamDao.saveActparam(view);
	}

	public int updateActparam(ActparamView view) {
		return actparamDao.updateActparam(view);
	}

	public List<Actparam> findAllActparams(ActparamView view) {
		return actparamDao.findAllActparams(view);
	}

	public Integer countAllActparams(ActparamView view) {
		return actparamDao.countAllActparams(view);
	}

	@Autowired
	private IActparamDAO actparamDao;
}
