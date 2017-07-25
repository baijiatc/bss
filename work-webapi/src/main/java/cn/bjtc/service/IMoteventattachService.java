package cn.bjtc.service;

import java.util.List;

import cn.bjtc.view.MoteventattachView;

public interface IMoteventattachService {

	public int saveMoteventattach(MoteventattachView view);
	public int updateMoteventattach(MoteventattachView view);
	public List<MoteventattachView> findAllMoteventattach(MoteventattachView view);
	public Integer countAllMoteventattach(MoteventattachView view);
}
