package cn.bjtc.dao.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import cn.bjtc.dao.ICustomerDao;
import cn.bjtc.dao.mybatis.MyBatisDAO;
import cn.bjtc.model.Customer;
import cn.bjtc.view.CustomerView;

@Component("customerDao")
public class CustomerDaoImpl extends MyBatisDAO<Customer, Integer> implements
     ICustomerDao{

	public List<Customer> findAllCusts(CustomerView view) {
		return super.findByParam("findAllCusts", view);
	}

	public Integer countAllCusts(CustomerView view) {
		return super.countByParam("countAllCusts", view);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
