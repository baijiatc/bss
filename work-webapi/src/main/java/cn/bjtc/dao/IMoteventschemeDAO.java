package cn.bjtc.dao;

import java.util.List;

import cn.bjtc.model.Moteventscheme;
import cn.bjtc.view.MoteventschemeView;

public interface IMoteventschemeDAO {

	public int saveMoteventscheme(MoteventschemeView view);
	public int deleteMoteventscheme(Integer id);
	public List<Moteventscheme> findAllMoteventscheme(MoteventschemeView view);
	public Integer countAllMoteventscheme(MoteventschemeView view);
}
