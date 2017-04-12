package cn.bjtc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.bjtc.dao.IIdxparamDAO;
import cn.bjtc.model.Idxparam;
import cn.bjtc.service.IIdxparamService;
import cn.bjtc.view.IdxparamView;

@Service("IdxparamService")
public class IdxparamServiceImpl implements IIdxparamService {

	public int saveIdxparam(IdxparamView view) {
		return idxparamDAO.saveIdxparam(view);
	}

	public int updateIdxparam(IdxparamView view) {
		return idxparamDAO.updateIdxparam(view);
	}

	public List<Idxparam> findAllIdxparam(IdxparamView view) {
		return idxparamDAO.findAllIdxparam(view);
	}

	public Integer countAllIdxparam(IdxparamView view) {
		return idxparamDAO.countAllIdxparam(view);
	}
	
	@Autowired
	private IIdxparamDAO idxparamDAO;

}
