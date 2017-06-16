package cn.bjtc.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.bjtc.dao.IMotidxDAO;
import cn.bjtc.model.Motidx;
import cn.bjtc.service.IMotidxService;
import cn.bjtc.view.MotidxView;

@Service("motidxService")
public class MotidxSerivceImpl implements  IMotidxService{

	public int saveMotidx(MotidxView view) {
		return motidxDao.saveMotidx(view) ;
	}

	public int updateMotidx(MotidxView view) {
		return motidxDao.updateMotidx(view);
	}

	public List<MotidxView> findAllMotidx(MotidxView view) {
		List<Motidx> Motidxs = motidxDao.findAllMotidx(view);
		if(Motidxs == null || Motidxs.size() <= 0){
			return new ArrayList<MotidxView>(0);
		}
		List<MotidxView> views = new ArrayList<MotidxView>(Motidxs.size());
		for(Motidx Motidx : Motidxs){
			MotidxView MotidxView = new MotidxView();
			BeanUtils.copyProperties(Motidx, MotidxView);
			views.add(MotidxView);
		}
		return views;
	}


	public Integer countAllMotidx(MotidxView view) {
		return motidxDao.countAllMotidx(view);
	}

   @Autowired
   private IMotidxDAO motidxDao;
	
}
