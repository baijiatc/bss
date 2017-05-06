package cn.bjtc.dao;

import cn.bjtc.model.Skuspec;

public interface ISkuspecDAO {
	public int createSkuspec(Skuspec skuspec);
	public int deleteById(Object skuid);
}
