package cn.bjtc.dao;

import java.util.List;

import cn.bjtc.model.OrderDet;
import cn.bjtc.view.OrderDetView;

public interface IOrderDetDAO {
	public List<OrderDet> findAllOrderDets(OrderDetView view);
	public Integer countAllOrderDets(OrderDetView view);
}
