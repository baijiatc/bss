package cn.bjtc.dao;

import java.util.List;

import cn.bjtc.model.Idxparam;
import cn.bjtc.view.IdxparamView;

public interface IIdxparamDAO {
	public int saveIdxparam(IdxparamView view);
	public int updateIdxparam(IdxparamView view);
	public List<Idxparam> findAllIdxparam(IdxparamView view);
	public Integer countAllIdxparam(IdxparamView view);
}
