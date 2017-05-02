package cn.bjtc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.bjtc.dao.ITransDAO;
import cn.bjtc.service.ITransService;

@Service("transService")
public class TransServiceImpl implements ITransService {

	public void transCustomers() {
		transDAO.transCustomers();
	}

	public void transShops() {
		transDAO.transShops();
	}

	public void transMoneyFlows() {
		transDAO.transMoneyFlows();
	}
	
	public void transOrders() {
		transDAO.transOrders();
	}

	@Autowired
	private ITransDAO transDAO;

}
