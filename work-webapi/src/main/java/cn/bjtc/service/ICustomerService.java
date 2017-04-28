package cn.bjtc.service;

import java.util.List;


import cn.bjtc.view.CustomerView;

public interface ICustomerService {
 
	public List<CustomerView> findAllCusts(CustomerView view);
	public Integer countAllCusts(CustomerView view);
}
