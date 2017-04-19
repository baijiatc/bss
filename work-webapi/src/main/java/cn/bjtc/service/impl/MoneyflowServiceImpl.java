package cn.bjtc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.bjtc.dao.IMoneyflowDAO;
import cn.bjtc.model.Moneyflow;
import cn.bjtc.service.IMoneyflowService;
import cn.bjtc.view.MoneyflowView;

@Service("moneyflowService")
public class MoneyflowServiceImpl implements IMoneyflowService {

	public List<Moneyflow> findAllMoneyflow(MoneyflowView view) {
		return moneyflowDAO.findAllMoneyflow(view);
	}

	public Integer countAllMoneyflow(MoneyflowView view) {
		return moneyflowDAO.countAllMoneyflow(view);
	}
	
	@Autowired
	private IMoneyflowDAO moneyflowDAO;

}
