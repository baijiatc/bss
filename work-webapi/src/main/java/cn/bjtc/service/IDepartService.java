package cn.bjtc.service;

import java.util.List;
import cn.bjtc.model.Depart;
import cn.bjtc.view.DepartView;

public interface IDepartService {

	public int saveDepart(DepartView view);
	public int updateDepart(DepartView view);
	public List<Depart> findAllDepart(DepartView view);
	public Integer countAllDepart(DepartView view);
}
