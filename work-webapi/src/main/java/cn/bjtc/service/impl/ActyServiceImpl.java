package cn.bjtc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.bjtc.dao.IActivityDao;
import cn.bjtc.model.Activity;
import cn.bjtc.service.IActyService;
import cn.bjtc.view.ActivityView;

@Service("activityService")
public class ActyServiceImpl implements  IActyService {

	public int saveActy(ActivityView view) {
		 return actyDao.saveActy(view);
	}

	public int updateActy(ActivityView view) {
		return  actyDao.updateActy(view);
	}

	public List<Activity> findAllActys(ActivityView view) {
		return actyDao.findAllActys(view);
	}

	public Integer countAllActys(ActivityView view) {
		return actyDao.countAllActys(view);
	}
	
	@Autowired
	private IActivityDao  actyDao;

}
