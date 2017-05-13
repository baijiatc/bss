package cn.bjtc.dao;

import java.util.List;

import cn.bjtc.model.Depart;
import cn.bjtc.view.DepartView;

public interface IDepartDAO {
	public int saveDepart(DepartView view);
	public int updateDepart(DepartView view);
	public List<Depart> findAllDepart(DepartView view);
	public List<Depart> findAllDepartStaff(DepartView view);
	public Integer countAllDepart(DepartView view);
}
