package cn.bjtc.dao;

import java.util.List;

import cn.bjtc.model.StockDet;
import cn.bjtc.view.StockDetView;

public interface IStockDetDAO {
	public List<StockDet> findAllStockDets(StockDetView view);
	public Integer countAllStockDets(StockDetView view);
}
