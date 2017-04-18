package cn.bjtc.dao.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import cn.bjtc.dao.IOrderDAO;
import cn.bjtc.dao.mybatis.MyBatisDAO;
import cn.bjtc.model.Orders;
import cn.bjtc.view.OrderView;

@Component("orderDAO")
public class OrderDAOImpl extends MyBatisDAO<Orders, Integer> implements
		IOrderDAO {

	public List<Orders> findAllOrder(OrderView view) {
		return super.findByParam("findAllOrder", view);
	}

	public Integer countAllOrder(OrderView view) {
		return super.countByParam("countAllOrder", view);
	}

}
