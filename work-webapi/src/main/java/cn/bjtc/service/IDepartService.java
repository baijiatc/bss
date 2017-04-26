package cn.bjtc.service;

import java.util.List;
import cn.bjtc.view.DepartView;

public interface IDepartService {

	public int saveDepart(DepartView view);
	public int updateDepart(DepartView view);
	public List<DepartView> findAllDepart(DepartView view);
	public Integer countAllDepart(DepartView view);
}
