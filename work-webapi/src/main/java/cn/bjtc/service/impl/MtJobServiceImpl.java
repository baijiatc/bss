package cn.bjtc.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.bjtc.dao.IMJobDao;
import cn.bjtc.model.MotJob;
import cn.bjtc.service.IMtJobService;
import cn.bjtc.view.MotJobView;

@Service("mtjobService")
public class MtJobServiceImpl implements IMtJobService{

	public List<MotJobView> findAllMJob(MotJobView view) {
		List<MotJob> jobs =mJobDao.findAllMJob(view);
		if(jobs == null || jobs.size() <= 0){
			return new ArrayList<MotJobView>(0);
		}
		List<MotJobView> views = new ArrayList<MotJobView>(jobs.size());
		for(MotJob job : jobs){
			MotJobView jobview = new MotJobView();
			BeanUtils.copyProperties(job, jobview);
			views.add(jobview);
		}
		return views;
	}

	public Integer countAllMJob(MotJobView view) {
		return mJobDao.countAllMJob(view);
	}
	@Autowired
	private IMJobDao mJobDao;
}
