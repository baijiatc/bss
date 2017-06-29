package cn.bjtc.dao;

import java.util.List;

import cn.bjtc.model.Depart;
import cn.bjtc.model.Motidx;
import cn.bjtc.view.DepartView;
import cn.bjtc.view.MotidxView;


public interface IMotidxDAO {

	public int saveMotidx(MotidxView view);
	public int updateMotidx(MotidxView view);
	public List<Motidx> findAllMotidx(MotidxView view);
	public List<Motidx> findAlltblname(MotidxView view);
	public List<Motidx> findAllcolname(MotidxView view);
	public Integer countAllMotidx(MotidxView view);
	 
} 
