package cn.bjtc.dao.impl;

import org.springframework.stereotype.Component;

import cn.bjtc.dao.ISkuspecDAO;
import cn.bjtc.dao.mybatis.MyBatisDAO;
import cn.bjtc.model.Skuspec;

@Component("skuspecDAO")
public class SkuspecDAOImpl extends MyBatisDAO<Skuspec, Integer> implements
		ISkuspecDAO {


	public int deleteById(Object skuid) {
		return super.delete("delectBySkuId", skuid);
	}

	public int createSkuspec(Skuspec skuspec) {
		return super.save("createSkuspec", skuspec);
	}
	
}
