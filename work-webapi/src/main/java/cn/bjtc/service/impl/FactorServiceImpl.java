package cn.bjtc.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.bjtc.dao.IFactorDAO;
import cn.bjtc.model.Factor;
import cn.bjtc.service.IFactorService;
import cn.bjtc.view.FactorView;

@Service("factorService")
public class FactorServiceImpl implements IFactorService {

	public int saveFactor(FactorView view) {
		return factorDAO.saveFactor(view);
	}

	public int updateFactor(FactorView view) {
		return factorDAO.updateFactor(view);
	}

	public List<FactorView> findAllFactors(FactorView view) {
		List<Factor> factors = factorDAO.findAllFactors(view);
		if(factors == null || factors.size() <= 0){
			return new ArrayList<FactorView>(0);
		}
		List<FactorView> views = new ArrayList<FactorView>(factors.size());
		for(Factor factor : factors){
			FactorView factorView = new FactorView();
			BeanUtils.copyProperties(factor, factorView);
			views.add(factorView);
		}
		return views;
	}

	public Integer countAllFactors(FactorView view) {
		return factorDAO.countAllFactors(view);
	}
	
	@Autowired
	private IFactorDAO factorDAO;

}
