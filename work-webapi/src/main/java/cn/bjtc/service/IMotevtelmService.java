package cn.bjtc.service;

import java.util.List;

import cn.bjtc.view.MotevtelmView;

public interface IMotevtelmService {

	public int saveMotevtelm(MotevtelmView view);
	public int deleteMotevtelm(Integer id);
	public List<MotevtelmView> findAllMotevtelm(MotevtelmView view);
	public Integer countAllMotevtelm(MotevtelmView view);
}
