package cn.bjtc.service;

import java.util.List;

import cn.bjtc.model.Actawards;
import cn.bjtc.view.ActawardsView;

public interface IActawardsService {

	public int saveActawards(ActawardsView view);
	public int updateActawards(ActawardsView view);
	public List<Actawards> findAllActawards(ActawardsView view);
	public Integer countAllActawards(ActawardsView view);
}
