package cn.bjtc.service.impl;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.bjtc.dao.IMotevtelmDAO;
import cn.bjtc.model.Motevtelm;
import cn.bjtc.service.IMotevtelmService;
import cn.bjtc.view.MotevtelmView;

@Service("motevtelmService")
public class MotevtelmServiceImpl  implements  IMotevtelmService{

	public int saveMotevtelm(MotevtelmView view) {
		 return motevtelmDao.saveMotevtelm(view);
	}

	public List<MotevtelmView> findAllMotevtelm(MotevtelmView view) {
		List<Motevtelm> Motevtelms =motevtelmDao.findAllMotevtelm(view);
		if(Motevtelms == null || Motevtelms.size() <= 0){
			return new ArrayList<MotevtelmView>(0);
		}
		List<MotevtelmView> views = new ArrayList<MotevtelmView>(Motevtelms.size());
		for(Motevtelm Motevtelm : Motevtelms){
			MotevtelmView MotevtelmView = new MotevtelmView();
			BeanUtils.copyProperties(Motevtelm, MotevtelmView);
			views.add(MotevtelmView);
		}
		return views;
	}
	public Integer countAllMotevtelm(MotevtelmView view) {
		return motevtelmDao.countAllMotevtelm(view);
	}
	public int deleteMotevtelm(Integer id) {
		return motevtelmDao.deleteMotevtelm(id);
	}

	@Autowired
	private IMotevtelmDAO motevtelmDao;

}
