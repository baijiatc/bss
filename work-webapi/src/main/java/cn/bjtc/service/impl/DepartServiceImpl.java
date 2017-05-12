package cn.bjtc.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		DepartView DepartView = new DepartView();
		DepartView.setPageSize(100);
		Map<String, String> parentMap = new HashMap<String, String>(Departs==null?0:Departs.size());
		List<Depart> departs = departDAO.findAllDepart(DepartView);
		List<Depart> staffnames = departDAO.findAllDepartStaff(DepartView);
		for(Depart Depart : departs){
				parentMap.put("P"+Depart.getDepartid(), Depart.getDepartname());
		}
		for(Depart staffname : staffnames){
			parentMap.put("k"+staffname.getLeader(), staffname.getStaffname());
		}
		List<DepartView> views = new ArrayList<DepartView>(Departs.size());
			for(Depart depart : Departs){
				DepartView departView = new DepartView();
				BeanUtils.copyProperties(depart, departView);
				departView.setStaffname(parentMap.get("k"+depart.getLeader()));
				departView.setParentStr(parentMap.get("P"+depart.getParentid()));
				views.add(departView);
			}
		return views;
	}
	
	public Integer countAllDepart(DepartView view) {
		return departDAO.countAllDepart(view);
	}
	
	@Autowired
	private IDepartDAO departDAO;
}
