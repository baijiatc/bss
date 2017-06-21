package cn.bjtc.service;

import java.util.List;

import cn.bjtc.model.Idxparaminstance;
import cn.bjtc.view.MotidxView;

public interface IMotidxService {

	public int saveMotidx(MotidxView view);
	public int updateMotidx(MotidxView view);
	public List<MotidxView> findAllMotidx(MotidxView view);
	public Integer countAllMotidx(MotidxView view);
}
