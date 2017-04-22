package cn.bjtc.dao;

import java.util.List;

import cn.bjtc.model.Factor;
import cn.bjtc.view.FactorView;

public interface IFactorDAO {

	public int saveFactor(FactorView view);
	public int updateFactor(FactorView view);
	public List<Factor> findAllFactors(FactorView view);
	public Integer countAllFactors(FactorView view);
}
