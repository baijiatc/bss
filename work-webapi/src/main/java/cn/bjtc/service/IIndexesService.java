package cn.bjtc.service;

import java.util.List;

import cn.bjtc.model.Indexes;
import cn.bjtc.view.IndexesView;

public interface IIndexesService {

	public int saveIndexes(IndexesView view);
	public int updateIndexes(IndexesView view);
	public List<Indexes> findAllIndexes(IndexesView view);
	public Integer countAllIndexes(IndexesView view);
}
