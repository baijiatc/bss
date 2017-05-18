package cn.bjtc.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.bjtc.dao.IOrderDAO;
import cn.bjtc.dao.IOrderDetDAO;
import cn.bjtc.dao.ISkuDAO;
import cn.bjtc.model.OrderDet;
import cn.bjtc.model.Orders;
import cn.bjtc.model.Sku;
import cn.bjtc.service.IOrderService;
import cn.bjtc.view.OrderDetView;
import cn.bjtc.view.OrderView;
import cn.bjtc.view.SkuView;

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
		List<OrderDet> orderDets = orderDetDAO.findAllOrderDets(view);
		if(orderDets == null || orderDets.size() <= 0){
			return new ArrayList<OrderDetView>(0);
		}
		List<OrderDetView> views = new ArrayList<OrderDetView>(orderDets.size());
		SkuView skuView = new SkuView();
		OrderView orderView = new OrderView();
		for(OrderDet orderDet : orderDets){
			OrderDetView orderDetView = new OrderDetView();
			BeanUtils.copyProperties(orderDet, orderDetView);
			orderView.setId(orderDet.getOrderid());
			skuView.setSourceid(orderDet.getSkuid());
			List<Orders> orders = orderDAO.findAllOrder(orderView);
			if(orders != null && orders.size() > 0){
				skuView.setFromsys(orders.get(0).getFromsys());
			}
			List<Sku> skus = skuDAO.findAllSkus(skuView);
			if(skus != null && skus.size() > 0){
				orderDetView.setSkuname(skus.get(0).getSkuname());
			}
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
	@Autowired
	private ISkuDAO skuDAO;

}
