package cn.bjtc.service;

import java.util.List;

import cn.bjtc.view.RegionView;

public interface IRegionService {
	public List<RegionView> findRegionByParent(Object parentid);
}
