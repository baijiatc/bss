package cn.bjtc.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.bjtc.dao.IOrderDAO;
import cn.bjtc.dao.IOrderDetDAO;
import cn.bjtc.model.Depart;
import cn.bjtc.model.Orders;
import cn.bjtc.model.OrderDet;
import cn.bjtc.service.IOrderService;
import cn.bjtc.view.DepartView;
import cn.bjtc.view.OrderView;
import cn.bjtc.view.OrderDetView;

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
	
	public List<OrderDetView> findAllOrderDets(OrderDetView view) {
		List<OrderDet> orderDets = orderDetDAO.findAllskuNameById(view);
		if(orderDets == null || orderDets.size() <= 0){
			return new ArrayList<OrderDetView>(0);
		}
		OrderDetView OrderDetView = new OrderDetView();
		OrderDetView.setPageSize(100);
		Map<String, String> parentMap = new HashMap<String, String>(orderDets==null?0:orderDets.size());
		List<OrderDet> oDets = orderDetDAO.findAllskuNameById(OrderDetView);
		for(OrderDet oDet : oDets){
			parentMap.put("P"+oDet.getSkuid(), oDet.getSkuname());
	}
		List<OrderDetView> views = new ArrayList<OrderDetView>(orderDets.size());
		for(OrderDet orderDet : orderDets){
			OrderDetView orderDetView = new OrderDetView();
			BeanUtils.copyProperties(orderDet, orderDetView);
			orderDetView.setSkuname(parentMap.get("P"+orderDet.getSkuid()));
			views.add(orderDetView);
		}
		return views;
	}

	public Integer countAllOrderDets(OrderDetView view) {
		return orderDetDAO.countAllOrderDets(view);
	}
	
	@Autowired
	private IOrderDAO orderDAO;
	@Autowired
	private IOrderDetDAO orderDetDAO;

}
