package cn.bjtc.service;

import java.util.List;

import cn.bjtc.model.Idxparam;
import cn.bjtc.view.IdxparamView;

public interface IIdxparamService {

	public int saveIdxparam(IdxparamView view);
	public int updateIdxparam(IdxparamView view);
	public List<Idxparam> findAllIdxparam(IdxparamView view);
	public Integer countAllIdxparam(IdxparamView view);
}
