package cn.bjtc.service;

import java.util.List;

public interface ITransService {

	public void transCustomers();
	public void transShops();
	public void transMoneyFlows();
	public void transOrders();
	
	public List<?> monitorStock();
	
}
