package cn.bjtc.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.bjtc.dao.IMotSchemeDao;
import cn.bjtc.model.MotScheme;
import cn.bjtc.service.IMotSchemeService;
import cn.bjtc.view.MotSchemeView;

@Service("motSchemeService")
public class MotSchemeServiceImpl implements  IMotSchemeService {
 

	public int saveMotScheme(MotSchemeView view) {
		return motSchDao.saveMotScheme(view);
	}

	public int updateMotScheme(MotSchemeView view) {
		return motSchDao.updateMotScheme(view);
	}

	public List<MotSchemeView> findAllMotScheme(MotSchemeView view) {
		List<MotScheme> motSchs =motSchDao.findAllMotScheme(view);
		if(motSchs == null || motSchs.size() <= 0){
			return new ArrayList<MotSchemeView>(0);
		}
		List<MotSchemeView> views = new ArrayList<MotSchemeView>(motSchs.size());
		for(MotScheme motSch : motSchs){
			MotSchemeView motSchView = new MotSchemeView();
			BeanUtils.copyProperties(motSch, motSchView);
			views.add(motSchView);
		}
		return views;
	}
	 

	public Integer countAllMotScheme(MotSchemeView view) {
		return motSchDao.countAllMotScheme(view);
	}
 

//
//	public List<MotSchemeView> fAllMScByName(String schmname) {
//		
//		List<MotScheme> motSchs =motSchDao.fAllMScByName(schmname);
//		if(motSchs == null || motSchs.size() <= 0){
//			return new ArrayList<MotSchemeView>(0);
//		}
//		List<MotSchemeView> views = new ArrayList<MotSchemeView>(motSchs.size());
//		for(MotScheme motSch : motSchs){
//			MotSchemeView motSchView = new MotSchemeView();
//			BeanUtils.copyProperties(motSch, motSchView);
//			views.add(motSchView);
//		}
//		return views;
//	}
//	 
//	 
	
	@Autowired
	private IMotSchemeDao  motSchDao;
}
