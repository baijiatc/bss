package cn.bjtc.service;

import java.util.List;

import cn.bjtc.model.Orders;
import cn.bjtc.view.OrderView;

public interface IOrderService {

	public List<OrderView> findAllOrder(OrderView view);
	public Integer countAllOrder(OrderView view);
}
