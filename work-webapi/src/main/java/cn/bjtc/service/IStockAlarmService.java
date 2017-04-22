package cn.bjtc.service;

import java.util.List;
import cn.bjtc.view.StockAlarmView;

public interface IStockAlarmService {

	public int saveStockAlarm(StockAlarmView view);
	public int updateStockAlarm(StockAlarmView view);
	public List<StockAlarmView> findAllStockAlarms(StockAlarmView view);
	public Integer countAllStockAlarms(StockAlarmView view);
}
