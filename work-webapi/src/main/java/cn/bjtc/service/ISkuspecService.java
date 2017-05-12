package cn.bjtc.service;

public interface ISkuspecService {
	public int createSkuspec(Object skuid, Object specids,Object specvalue);
	public int deleteById(Object skuid);
}
