package cn.bjtc.dao.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import cn.bjtc.dao.IFactorDAO;
import cn.bjtc.dao.mybatis.MyBatisDAO;
import cn.bjtc.model.Factor;
import cn.bjtc.view.FactorView;

@Component("factorDAO")
public class FactorDAOImpl extends MyBatisDAO<Factor, Integer> implements
		IFactorDAO {

	public int saveFactor(FactorView view) {
		Factor factor = new Factor();
		BeanUtils.copyProperties(view, factor);
		return super.save("saveFactor", factor);
	}

	public int updateFactor(FactorView view) {
		return super.update("updateFactor", view);
	}

	public List<Factor> findAllFactors(FactorView view) {
		return super.findByParam("findAllFactors", view);
	}

	public Integer countAllFactors(FactorView view) {
		return super.countByParam("countAllFactors", view);
	}

}
