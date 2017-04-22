package cn.bjtc.dao.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import cn.bjtc.dao.IStockAlarmDAO;
import cn.bjtc.dao.mybatis.MyBatisDAO;
import cn.bjtc.model.StockAlarm;
import cn.bjtc.view.StockAlarmView;

@Component("stockAlarmDAO")
public class StockAlarmDAOImpl extends MyBatisDAO<StockAlarm, Integer> implements
		IStockAlarmDAO {

	public int saveStockAlarm(StockAlarmView view) {
		StockAlarm stockAlarm = new StockAlarm();
		BeanUtils.copyProperties(view, stockAlarm);
		return super.save("saveStockAlarm", stockAlarm);
	}

	public int updateStockAlarm(StockAlarmView view) {
		return super.update("updateStockAlarm", view);
	}

	public List<StockAlarm> findAllStockAlarms(StockAlarmView view) {
		return super.findByParam("findAllStockAlarms", view);
	}

	public Integer countAllStockAlarms(StockAlarmView view) {
		return super.countByParam("countAllStockAlarms", view);
	}

}
