package cn.bjtc.service;

import java.util.List;

import cn.bjtc.model.OrderDet;
import cn.bjtc.view.OrderView;
import cn.bjtc.view.OrderDetView;

public interface IOrderService {

	public List<OrderView> findAllOrder(OrderView view);
	public Integer countAllOrder(OrderView view);
	
	public List<OrderDetView> findAllOrderDets(OrderDetView view);
	public Integer countAllOrderDets(OrderDetView view);
}
