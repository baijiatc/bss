package cn.bjtc.service;

import java.util.List;

import cn.bjtc.view.FactorView;

public interface IFactorService {

	public int saveFactor(FactorView view);
	public int updateFactor(FactorView view);
	public List<FactorView> findAllFactors(FactorView view);
	public Integer countAllFactors(FactorView view);
}
