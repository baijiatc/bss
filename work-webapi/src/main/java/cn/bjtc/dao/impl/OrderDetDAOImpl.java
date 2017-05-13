package cn.bjtc.dao.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import cn.bjtc.dao.IOrderDetDAO;
import cn.bjtc.dao.mybatis.MyBatisDAO;
import cn.bjtc.model.OrderDet;
import cn.bjtc.view.OrderDetView;

@Component("orderDetDAO")
public class OrderDetDAOImpl extends MyBatisDAO<OrderDet, Integer> implements
		IOrderDetDAO {

	public List<OrderDet> findAllOrderDets(OrderDetView view) {
		return super.findByParam("findAllOrderDets", view);
	}

	public Integer countAllOrderDets(OrderDetView view) {
		return super.countByParam("countAllOrderDets", view);
	}

	public List<OrderDet> findAllskuNameById(OrderDetView view) {
		return super.findByParam("findAllskuNameById", view);
	}

}
