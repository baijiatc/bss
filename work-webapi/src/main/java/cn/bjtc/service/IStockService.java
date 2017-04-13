package cn.bjtc.service;

import java.util.List;

import cn.bjtc.model.Stock;
import cn.bjtc.model.StockDet;
import cn.bjtc.view.StockDetView;
import cn.bjtc.view.StockView;

public interface IStockService {

	public List<Stock> findAllStocks(StockView view);
	public Integer countAllStocks(StockView view);
	
	public List<StockDet> findAllStockDets(StockDetView view);
	public Integer countAllStockDets(StockDetView view);
}
