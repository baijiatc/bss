package cn.bjtc.dao.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import cn.bjtc.dao.IStockDetDAO;
import cn.bjtc.dao.mybatis.MyBatisDAO;
import cn.bjtc.model.StockDet;
import cn.bjtc.view.StockDetView;

@Component("stockDetDAO")
public class StockDetDAOImpl extends MyBatisDAO<StockDet, Integer> implements
		IStockDetDAO {

	public List<StockDet> findAllStockDets(StockDetView view) {
		return super.findByParam("findAllStockDets", view);
	}

	public Integer countAllStockDets(StockDetView view) {
		return super.countByParam("countAllStockDets", view);
	}

}
