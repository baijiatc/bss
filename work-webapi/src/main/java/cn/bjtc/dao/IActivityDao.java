package cn.bjtc.dao;

import java.util.List;

import cn.bjtc.model.Activity;
import cn.bjtc.view.ActivityView;

public interface IActivityDao {

	public int saveActy(ActivityView  view);
	public int updateActy(ActivityView view);
	public List<Activity> findAllActys(ActivityView view);
	public Integer countAllActys(ActivityView view);
}
