package cn.bjtc.service;

import java.util.List;

import cn.bjtc.view.MotevtgetView;

public interface IMotevtgetService {

	public int saveMotevtget(MotevtgetView view);
	public int deleteMotevtget(Integer id);
	public List<MotevtgetView> findAllMotevtget(MotevtgetView view);
	public Integer countAllMotevtget(MotevtgetView view);
}
