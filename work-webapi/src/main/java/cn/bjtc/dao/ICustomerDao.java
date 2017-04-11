package cn.bjtc.dao;

import java.util.List;

import cn.bjtc.model.Customer;
import cn.bjtc.view.CustomerView;

/**
 * 
 * @author xinxinx
 *
 */
public interface  ICustomerDao {
  public List<Customer> findAllCusts(CustomerView view);
  public Integer countAllCusts(CustomerView view);
	
	
	
	
	
	
	
	
	
	
	
}
