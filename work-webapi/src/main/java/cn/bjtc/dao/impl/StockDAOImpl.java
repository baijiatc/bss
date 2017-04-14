package cn.bjtc.dao.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import cn.bjtc.dao.IStockDAO;
import cn.bjtc.dao.mybatis.MyBatisDAO;
import cn.bjtc.model.Stock;
import cn.bjtc.view.StockView;

@Component("stockDAO")
public class StockDAOImpl extends MyBatisDAO<Stock, Integer> implements
		IStockDAO {

	public List<Stock> findAllStocks(StockView view) {
		return super.findByParam("findAllStocks", view);
	}

	public Integer countAllStocks(StockView view) {
		return super.countByParam("countAllStocks", view);
	}

}
