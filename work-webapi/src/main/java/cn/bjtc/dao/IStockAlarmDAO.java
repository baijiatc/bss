package cn.bjtc.dao;

import java.util.List;

import cn.bjtc.model.StockAlarm;
import cn.bjtc.view.StockAlarmView;

public interface IStockAlarmDAO {

	public int saveStockAlarm(StockAlarmView view);
	public int updateStockAlarm(StockAlarmView view);
	public List<StockAlarm> findAllStockAlarms(StockAlarmView view);
	public Integer countAllStockAlarms(StockAlarmView view);
}
