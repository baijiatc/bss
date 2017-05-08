package cn.bjtc.dao.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import cn.bjtc.dao.ITransDAO;
import cn.bjtc.dao.mybatis.MyBatisDAO;

@Component("transDAO")
public class TransDAOImpl extends MyBatisDAO<Object, Integer> implements ITransDAO {

	public void transCustomers() {
		String statement = "TransJob.transCustomers";
		super.callProcedrue(statement, null);
	}

	public void transShops() {
		String statement = "TransJob.transShops";
		super.callProcedrue(statement, null);
	}

	public void transMoneyFlows() {
		String statement = "TransJob.transMoneyFlows";
		super.callProcedrue(statement, null);
	}

	public void transOrders() {
		String statement = "TransJob.transOrders";
		super.callProcedrue(statement, null);
	}

	public List<?> monitorStock() {
		String statement = "TransJob.monitorStock";
		return super.callProcedrueWithResult(statement, null);
	}

}
