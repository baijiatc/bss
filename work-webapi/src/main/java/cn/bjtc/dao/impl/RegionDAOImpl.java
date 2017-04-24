package cn.bjtc.dao.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import cn.bjtc.dao.IRegionDAO;
import cn.bjtc.dao.mybatis.MyBatisDAO;
import cn.bjtc.model.Region;

@Component("regionDAO")
public class RegionDAOImpl extends MyBatisDAO<Region, Integer> implements
		IRegionDAO {

	public List<Region> findRegionByParent(Object parentid) {
		return super.findByParam("findRegionByParent", parentid);
	}

}
