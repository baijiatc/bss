package cn.bjtc.service;

import java.util.List;

import cn.bjtc.view.MoteventView;

public interface IMoteventService {

	public int saveMotevent(MoteventView view);
	public int updateMotevent(MoteventView view);
	public List<MoteventView> findAllMotevent(MoteventView view);
	public Integer countAllMotevent(MoteventView view);
}
