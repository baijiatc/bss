package cn.bjtc.dao;

import java.util.List;

import cn.bjtc.model.Motevtelm;
import cn.bjtc.view.MotevtelmView;

public interface IMotevtelmDAO {
	public int saveMotevtelm(MotevtelmView view);
	public int deleteMotevtelm(Integer id);
	public List<Motevtelm> findAllMotevtelm(MotevtelmView view);
	public Integer countAllMotevtelm(MotevtelmView view);
}
