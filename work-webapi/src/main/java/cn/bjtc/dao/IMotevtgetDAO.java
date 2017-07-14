package cn.bjtc.dao;

import java.util.List;

import cn.bjtc.model.Moteventscheme;
import cn.bjtc.model.Motevtget;
import cn.bjtc.view.MoteventschemeView;
import cn.bjtc.view.MotevtgetView;

public interface IMotevtgetDAO {
	public int saveMotevtget(MotevtgetView view);
	public int deleteMotevtget(Integer id);
	public List<Motevtget> findAllMotevtget(MotevtgetView view);
	public List<Motevtget> findAllltblname(MotevtgetView view);
	public List<Motevtget> findAllrtblname(MotevtgetView view);
	public Integer countAllMotevtget(MotevtgetView view);
}
