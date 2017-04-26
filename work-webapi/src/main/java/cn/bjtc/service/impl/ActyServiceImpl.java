package cn.bjtc.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.bjtc.dao.IActivityDao;
import cn.bjtc.model.Activity;
import cn.bjtc.model.Menu;
import cn.bjtc.service.IActyService;
import cn.bjtc.view.ActivityView;
import cn.bjtc.view.MenuView;

@Service("activityService")
public class ActyServiceImpl implements  IActyService {

	public int saveActy(ActivityView view) {
		 return actyDao.saveActy(view);
	}

	public int updateActy(ActivityView view) {
		return  actyDao.updateActy(view);
	}

	public List<ActivityView> findAllActys(ActivityView view) {
		List<Activity> acts = actyDao.findAllActys(view);
		if(acts == null ||acts.size() <= 0){
			return new ArrayList<ActivityView>(0);
		}
		List<ActivityView> views = new ArrayList<ActivityView>(acts.size());
		for(Activity act : acts){
			ActivityView actView = new ActivityView();
			BeanUtils.copyProperties(act, actView);
			views.add(actView);
		}
		return views;
	}


	public Integer countAllActys(ActivityView view) {
		return actyDao.countAllActys(view);
	}
	
	@Autowired
	private IActivityDao  actyDao;

}
