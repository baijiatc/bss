package cn.bjtc.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.bjtc.dao.IRegionDAO;
import cn.bjtc.model.Region;
import cn.bjtc.service.IRegionService;
import cn.bjtc.view.RegionView;

@Service("regionService")
public class RegionServiceImpl implements IRegionService {

	public List<RegionView> findRegionByParent(Object parentid) {
		List<Region> regions = regionDAO.findRegionByParent(parentid);
		if(regions == null || regions.size() <= 0){
			return new ArrayList<RegionView>(0);
		}
		List<RegionView> views = new ArrayList<RegionView>(regions.size());
		for(Region region : regions){
			RegionView view = new RegionView();
			BeanUtils.copyProperties(region, view);
			views.add(view);
		}
		return views;
	}

	@Autowired
	private IRegionDAO regionDAO;
}
