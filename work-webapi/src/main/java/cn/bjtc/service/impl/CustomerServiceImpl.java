package cn.bjtc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.bjtc.dao.ICustomerDao;
import cn.bjtc.model.Customer;
import cn.bjtc.service.ICustomerService;
import cn.bjtc.view.CustomerView;

@Service("customerService")
public class CustomerServiceImpl implements  ICustomerService {

	public List<Customer> findAllCusts(CustomerView view) {
		 return customerDao.findAllCusts(view);
	}


	public Integer countAllCusts(CustomerView view) {
		return customerDao.countAllCusts(view);			
	}
	
	@Autowired
	private ICustomerDao  customerDao;
	
}
