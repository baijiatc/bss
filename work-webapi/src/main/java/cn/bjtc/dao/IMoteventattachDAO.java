package cn.bjtc.dao;

import java.util.List;

import cn.bjtc.model.Moteventattach;
import cn.bjtc.view.MoteventattachView;

public interface IMoteventattachDAO {

	public int saveMoteventattach(MoteventattachView view);
	public int updateMoteventattach(MoteventattachView view);
	public List<Moteventattach> findAllMoteventattach(MoteventattachView view);
	public Integer countAllMoteventattach(MoteventattachView view);
}
