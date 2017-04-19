package cn.bjtc.dao.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import cn.bjtc.dao.IMoneyflowDAO;
import cn.bjtc.dao.mybatis.MyBatisDAO;
import cn.bjtc.model.Moneyflow;
import cn.bjtc.view.MoneyflowView;

@Component("moneyflowDAO")
public class MoneyflowDAOImpl extends MyBatisDAO<Moneyflow, Integer> implements
		IMoneyflowDAO {

	public List<Moneyflow> findAllMoneyflow(MoneyflowView view) {
		return super.findByParam("findAllMoneyflow", view);
	}

	public Integer countAllMoneyflow(MoneyflowView view) {
		return super.countByParam("countAllMoneyflow", view);
	}

}
