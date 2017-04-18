package cn.bjtc.service;

import java.util.List;

import cn.bjtc.model.Moneyflow;
import cn.bjtc.view.MoneyflowView;

public interface IMoneyflowService {

	public List<Moneyflow> findAllMoneyflow(MoneyflowView view);
	public Integer countAllMoneyflow(MoneyflowView view);
}
