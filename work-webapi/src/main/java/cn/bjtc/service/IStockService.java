package cn.bjtc.service;

import java.util.List;

import cn.bjtc.model.Stock;
import cn.bjtc.model.StockDet;
import cn.bjtc.view.StockDetView;
import cn.bjtc.view.StockView;

public interface IStockService {

	public List<StockView> findAllStocks(StockView view);
	public Integer countAllStocks(StockView view);
	
	public List<StockDetView> findAllStockDets(StockDetView view);
	public Integer countAllStockDets(StockDetView view);
}
