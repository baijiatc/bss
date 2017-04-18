package cn.bjtc.dao;

import java.util.List;

import cn.bjtc.model.Orders;
import cn.bjtc.view.ActparamView;
import cn.bjtc.view.OrderView;

public interface IOrderDAO {
	public List<Orders> findAllOrder(OrderView view);
	public Integer countAllOrder(OrderView view);
}
