package cn.bjtc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.bjtc.dao.ISpecDAO;
import cn.bjtc.model.Spec;
import cn.bjtc.service.ISpecService;
import cn.bjtc.view.SpecView;

@Service("specService")
public class SpecServiceImpl implements ISpecService {


	public int saveSpec(SpecView view) {
		return specDAO.saveSpec(view);
	}

	public int updateSpec(SpecView view) {
		return  specDAO.updateSpec(view);
	}

	public List<Spec> findAllSpecs(SpecView view) {
		return specDAO.findAllSpecs(view);
	}

	public Integer countAllSpecs(SpecView view) {
		return specDAO.countAllSpecs(view);
	}
 

	@Autowired
	private ISpecDAO specDAO;

}
