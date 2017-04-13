package cn.bjtc.dao.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import cn.bjtc.dao.IActivityDao;
import cn.bjtc.dao.mybatis.MyBatisDAO;
import cn.bjtc.model.Activity;
import cn.bjtc.view.ActivityView;

@Component("activityDao")
public class ActyDaoImpl  extends MyBatisDAO<Activity, Integer> implements
               IActivityDao{

	public int saveActy(ActivityView view) {
		Activity acty=new Activity();
		BeanUtils.copyProperties(view, acty);
		return super.save("saveActy", acty);
	}

	public int updateActy(ActivityView view) {
		 return super.update("updateActy", view);
	}

	public List<Activity> findAllActys(ActivityView view) {
		return  super.findByParam("findAllActys", view);
	}

	public Integer countAllActys(ActivityView view) {
		return super.countByParam("countAllActys", view);
	}

}
