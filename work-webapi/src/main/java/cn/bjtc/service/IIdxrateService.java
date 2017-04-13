package cn.bjtc.service;

import java.util.List;

import cn.bjtc.model.Idxparaminstance;
import cn.bjtc.view.IdxrateView;

public interface IIdxrateService {

	public int saveIdxrate(IdxrateView view);
	public int updateIdxrate(IdxrateView view);
	public List<Idxparaminstance> findAllIdxrate(IdxrateView view);
	public Integer countAllIdxrate(IdxrateView view);
}
