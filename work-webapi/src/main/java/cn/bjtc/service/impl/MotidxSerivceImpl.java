package cn.bjtc.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.bjtc.dao.IMotidxDAO;
import cn.bjtc.model.Depart;
import cn.bjtc.model.Motidx;
import cn.bjtc.service.IMotidxService;
import cn.bjtc.view.DepartView;
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
		MotidxView motidxView = new MotidxView();
		motidxView.setPageSize(100);
		Map<String, String> tblMap = new HashMap<String, String>(Motidxs==null?0:Motidxs.size());
		List<Motidx> tbls = motidxDao.findAlltblname(motidxView);
		List<Motidx> cols = motidxDao.findAllcolname(motidxView);
		for(Motidx tbln : tbls){
			tblMap.put("t"+tbln.getTblid(), tbln.getTblname());
		}
		for(Motidx coln : cols){
			tblMap.put("c"+coln.getColid(), coln.getColname());
		}
		List<MotidxView> views = new ArrayList<MotidxView>(Motidxs.size());
		for(Motidx motidx : Motidxs){
			MotidxView MotidxView = new MotidxView();
			BeanUtils.copyProperties(motidx, MotidxView);
			MotidxView.setTblname((tblMap.get("t"+motidx.getTblid())));
			MotidxView.setColname((tblMap.get("c"+motidx.getColid())));
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
