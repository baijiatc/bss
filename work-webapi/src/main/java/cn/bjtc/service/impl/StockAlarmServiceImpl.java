package cn.bjtc.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.bjtc.dao.IStockAlarmDAO;
import cn.bjtc.model.StockAlarm;
import cn.bjtc.service.IStockAlarmService;
import cn.bjtc.view.StockAlarmView;

@Service("stockAlarmService")
public class StockAlarmServiceImpl implements IStockAlarmService {

	public int saveStockAlarm(StockAlarmView view) {
		return stockAlarmDAO.saveStockAlarm(view);
	}

	public int updateStockAlarm(StockAlarmView view) {
		return stockAlarmDAO.updateStockAlarm(view);
	}

	public List<StockAlarmView> findAllStockAlarms(StockAlarmView view) {
		List<StockAlarm> stockAlarms = stockAlarmDAO.findAllStockAlarms(view);
		if(stockAlarms == null || stockAlarms.size() <= 0){
			return new ArrayList<StockAlarmView>(0);
		}
		List<StockAlarmView> views = new ArrayList<StockAlarmView>(stockAlarms.size());
		for(StockAlarm stockAlarm : stockAlarms){
			StockAlarmView stockAlarmView = new StockAlarmView();
			BeanUtils.copyProperties(stockAlarm, stockAlarmView);
			views.add(stockAlarmView);
		}
		return views;
	}

	public Integer countAllStockAlarms(StockAlarmView view) {
		return stockAlarmDAO.countAllStockAlarms(view);
	}
	
	@Autowired
	private IStockAlarmDAO stockAlarmDAO;

}
