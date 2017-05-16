package cn.bjtc.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.bjtc.dao.ISkuDAO;
import cn.bjtc.dao.IStockDAO;
import cn.bjtc.dao.IStockDetDAO;
import cn.bjtc.model.Sku;
import cn.bjtc.model.Stock;
import cn.bjtc.model.StockDet;
import cn.bjtc.service.IStockService;
import cn.bjtc.view.SkuView;
import cn.bjtc.view.StockDetView;
import cn.bjtc.view.StockView;

@Service("stockService")
public class StockServiceImpl implements IStockService {

	public List<StockView> findAllStocks(StockView view) {
		List<Stock> stocks = stockDAO.findAllStocks(view);
		if(stocks == null || stocks.size()<=0){
			return new ArrayList<StockView>(0);
		}
		SkuView skuView = new SkuView();
		skuView.setPageSize(10);
		skuView.setFromsys(2);//财务系统
		List<StockView> views = new ArrayList<StockView>(stocks.size());
		for(Stock stock : stocks){
			StockView stockView = new StockView();
			BeanUtils.copyProperties(stock, stockView);
			skuView.setSourceid(stockView.getSkuid());
			List<Sku> skus = skuDAO.findAllSkus(skuView);
			if(skus !=null && skus.size()>0){
				stockView.setSkuname(skus.get(0).getSkuname());
			}
			views.add(stockView);
		}
		return views;
	}

	public Integer countAllStocks(StockView view) {
		return stockDAO.countAllStocks(view);
	}

	public List<StockDetView> findAllStockDets(StockDetView view) {
		List<StockDet> stockDets = stockDetDAO.findAllStockDets(view);
		if(stockDets == null || stockDets.size() <= 0){
			return new ArrayList<StockDetView>(0);
		}
		List<StockDetView> views = new ArrayList<StockDetView>(stockDets.size());
		for(StockDet stockDet : stockDets){
			StockDetView stockDetView = new StockDetView();
			BeanUtils.copyProperties(stockDet, stockDetView);
			views.add(stockDetView);
		}
		return views;
	}

	public Integer countAllStockDets(StockDetView view) {
		return stockDetDAO.countAllStockDets(view);
	}
	
	@Autowired
	private IStockDAO stockDAO;
	@Autowired
	private IStockDetDAO stockDetDAO;
	@Autowired
	private ISkuDAO skuDAO;

}
