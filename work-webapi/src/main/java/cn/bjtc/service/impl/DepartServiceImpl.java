package cn.bjtc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.bjtc.dao.IDepartDAO;
import cn.bjtc.model.Depart;
import cn.bjtc.service.IDepartService;
import cn.bjtc.view.DepartView;


@Service("departService")
public class DepartServiceImpl implements IDepartService {

	public int saveDepart(DepartView view) {
		return departDAO.saveDepart(view);
	}

	public int updateDepart(DepartView view) {
		return departDAO.updateDepart(view);
	}

	public List<Depart> findAllDepart(DepartView view) {
		return departDAO.findAllDepart(view);
	}

	public Integer countAllDepart(DepartView view) {
		return departDAO.countAllDepart(view);
	}
	
	@Autowired
	private IDepartDAO departDAO;

}
