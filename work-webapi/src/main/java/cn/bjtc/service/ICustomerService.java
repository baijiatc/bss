package cn.bjtc.service;

import java.util.List;

import cn.bjtc.model.Customer;
import cn.bjtc.view.CustomerView;

public interface ICustomerService {
 
	public List<Customer> findAllCusts(CustomerView view);
	public Integer countAllCusts(CustomerView view);
}
