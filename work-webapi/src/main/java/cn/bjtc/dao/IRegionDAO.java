package cn.bjtc.dao;

import java.util.List;

import cn.bjtc.model.Region;

public interface IRegionDAO {
	public List<Region> findRegionByParent(Object parentid);
}
