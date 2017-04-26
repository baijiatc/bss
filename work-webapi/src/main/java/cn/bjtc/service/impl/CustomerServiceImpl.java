package cn.bjtc.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.bjtc.dao.ICustomerDao;
import cn.bjtc.model.Customer;
import cn.bjtc.model.Role;
import cn.bjtc.service.ICustomerService;
import cn.bjtc.view.CustomerView;
import cn.bjtc.view.RoleView;

@Service("customerService")
public class CustomerServiceImpl implements  ICustomerService {

	public List<CustomerView> findAllCusts(CustomerView view) {
		List<Customer> customers = customerDao.findAllCusts(view);
		if(customers == null || customers.size() <= 0){
			return new ArrayList<CustomerView>(0);
		}
		List<CustomerView> views = new ArrayList<CustomerView>(customers.size());
		for(Customer customer : customers){
			CustomerView customerView = new CustomerView();
			BeanUtils.copyProperties(customer, customerView);
			views.add(customerView);
		}
		return views;
	}


	public Integer countAllCusts(CustomerView view) {
		return customerDao.countAllCusts(view);			
	}
	
	@Autowired
	private ICustomerDao  customerDao;
	
}
