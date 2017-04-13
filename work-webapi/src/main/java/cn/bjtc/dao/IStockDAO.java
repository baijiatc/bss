package cn.bjtc.dao;

import java.util.List;

import cn.bjtc.model.Stock;
import cn.bjtc.view.StockView;

public interface IStockDAO {

	public List<Stock> findAllStocks(StockView view);
	public Integer countAllStocks(StockView view);
}
