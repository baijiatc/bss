package cn.bjtc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.bjtc.dao.IOrderDAO;
import cn.bjtc.model.Orders;
import cn.bjtc.service.IOrderService;
import cn.bjtc.view.OrderView;

@Service("orderService")
public class OrderServiceImpl implements IOrderService {

	public List<Orders> findAllOrder(OrderView view) {
		return OrderDAO.findAllOrder(view);
	}

	public Integer countAllOrder(OrderView view) {
		return OrderDAO.countAllOrder(view);
	}
	
	@Autowired
	private IOrderDAO OrderDAO;

}
