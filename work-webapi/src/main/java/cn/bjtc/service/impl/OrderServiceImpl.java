package cn.bjtc.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.bjtc.dao.IOrderDAO;
import cn.bjtc.model.Orders;
import cn.bjtc.service.IOrderService;
import cn.bjtc.view.OrderView;

@Service("orderService")
public class OrderServiceImpl implements IOrderService {

	public List<OrderView> findAllOrder(OrderView view) {
		List<Orders> Orders = orderDAO.findAllOrder(view);
		if(Orders == null || Orders.size() <= 0){
			return new ArrayList<OrderView>(0);
		}
		List<OrderView> views = new ArrayList<OrderView>(Orders.size());
		for(Orders Order : Orders){
			OrderView OrderView = new OrderView();
			BeanUtils.copyProperties(Order, OrderView);
			views.add(OrderView);
		}
		return views;
	}

	public Integer countAllOrder(OrderView view) {
		return orderDAO.countAllOrder(view);
	}
	
	@Autowired
	private IOrderDAO orderDAO;

}
