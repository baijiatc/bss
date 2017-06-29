package cn.bjtc.dao;

import java.util.List;

import cn.bjtc.model.Motevent;
import cn.bjtc.view.MoteventView;

public interface IMoteventDAO {

	public int saveMotevent(MoteventView view);
	public int updateMotevent(MoteventView view);
	public List<Motevent> findAllMotevent(MoteventView view);
	public Integer countAllMotevent(MoteventView view);
}
