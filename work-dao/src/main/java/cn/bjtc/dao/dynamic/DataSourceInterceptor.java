package cn.bjtc.dao.dynamic;

import org.aspectj.lang.JoinPoint;

public class DataSourceInterceptor {

	public void setMaster(JoinPoint jp){
		DynamicDataSourceHolder.putDataSource("master");
	}
	
	public void setSlave(JoinPoint jp){
		DynamicDataSourceHolder.putDataSource("slave");
	}
}
