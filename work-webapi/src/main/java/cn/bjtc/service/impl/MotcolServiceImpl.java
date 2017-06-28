package cn.bjtc.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.bjtc.dao.IMotcolDAO;
import cn.bjtc.model.Motcol;
import cn.bjtc.service.IMotcolService;
import cn.bjtc.view.MotcolView;

@Service("motcolService")
public class MotcolServiceImpl implements  IMotcolService {
 
	public List<MotcolView> findAllMotcol(MotcolView view) {
		List<Motcol> motcol =motcolDao.findAllMotcol(view);
		if(motcol == null || motcol.size() <= 0){
			return new ArrayList<MotcolView>(0);
		}
		List<MotcolView> views = new ArrayList<MotcolView>(motcol.size());
		for(Motcol motSch : motcol){
			MotcolView motSchView = new MotcolView();
			BeanUtils.copyProperties(motSch, motSchView);
			views.add(motSchView);
		}
		return views;
	}
	@Autowired
	private IMotcolDAO  motcolDao;
	
}
