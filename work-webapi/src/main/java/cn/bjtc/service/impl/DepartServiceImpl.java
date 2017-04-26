package cn.bjtc.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.bjtc.dao.IDepartDAO;
import cn.bjtc.model.Depart;
import cn.bjtc.model.Depart;
import cn.bjtc.service.IDepartService;
import cn.bjtc.view.DepartView;
import cn.bjtc.view.DepartView;


@Service("departService")
public class DepartServiceImpl implements IDepartService {

	public int saveDepart(DepartView view) {
		return departDAO.saveDepart(view);
	}

	public int updateDepart(DepartView view) {
		return departDAO.updateDepart(view);
	}

	public List<DepartView> findAllDepart(DepartView view) {
		List<Depart> Departs = departDAO.findAllDepart(view);
		if(Departs == null || Departs.size() <= 0){
			return new ArrayList<DepartView>(0);
		}
		List<DepartView> views = new ArrayList<DepartView>(Departs.size());
		for(Depart Depart : Departs){
			DepartView DepartView = new DepartView();
			BeanUtils.copyProperties(Depart, DepartView);
			views.add(DepartView);
		}
		return views;
	}

	public Integer countAllDepart(DepartView view) {
		return departDAO.countAllDepart(view);
	}
	
	@Autowired
	private IDepartDAO departDAO;

}
