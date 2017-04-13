package cn.bjtc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.bjtc.dao.IStockDAO;
import cn.bjtc.dao.IStockDetDAO;
import cn.bjtc.model.Stock;
import cn.bjtc.model.StockDet;
import cn.bjtc.service.IStockService;
import cn.bjtc.view.StockDetView;
import cn.bjtc.view.StockView;

@Service("stockService")
public class StockServiceImpl implements IStockService {

	public List<Stock> findAllStocks(StockView view) {
		return stockDAO.findAllStocks(view);
	}

	public Integer countAllStocks(StockView view) {
		return stockDAO.countAllStocks(view);
	}

	public List<StockDet> findAllStockDets(StockDetView view) {
		return stockDetDAO.findAllStockDets(view);
	}

	public Integer countAllStockDets(StockDetView view) {
		return stockDetDAO.countAllStockDets(view);
	}
	
	@Autowired
	private IStockDAO stockDAO;
	@Autowired
	private IStockDetDAO stockDetDAO;

}
