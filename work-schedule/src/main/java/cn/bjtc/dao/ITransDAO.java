package cn.bjtc.dao;

import java.util.List;

public interface ITransDAO {

	public void transCustomers();
	public void transShops();
	public void transMoneyFlows();
	public void transOrders();
	
	public List<?> monitorStock();
	
}
