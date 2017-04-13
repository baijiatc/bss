package cn.bjtc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.bjtc.dao.IIdxrateDAO;
import cn.bjtc.model.Idxparaminstance;
import cn.bjtc.service.IIdxrateService;
import cn.bjtc.view.IdxrateView;

@Service("IdxrateService")
public class IdxrateServiceImpl implements IIdxrateService {

	public int saveIdxrate(IdxrateView view) {
		return idxrateDAO.saveIdxrate(view);
	}

	public int updateIdxrate(IdxrateView view) {
		return idxrateDAO.updateIdxrate(view);
	}

	public List<Idxparaminstance> findAllIdxrate(IdxrateView view) {
		return idxrateDAO.findAllIdxrate(view);
	}

	public Integer countAllIdxrate(IdxrateView view) {
		return idxrateDAO.countAllIdxrate(view);
	}
	
	@Autowired
	private IIdxrateDAO idxrateDAO;

}
