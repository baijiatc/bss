package cn.bjtc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.bjtc.dao.IIndexesDAO;
import cn.bjtc.model.Indexes;
import cn.bjtc.service.IIndexesService;
import cn.bjtc.view.IndexesView;

@Service("indexesService")
public class IndexesServiceImpl implements IIndexesService {

	public int saveIndexes(IndexesView view) {
		return indexesDAO.saveIndexes(view);
	}

	public int updateIndexes(IndexesView view) {
		return indexesDAO.updateIndexes(view);
	}

	public List<Indexes> findAllIndexes(IndexesView view) {
		return indexesDAO.findAllIndexes(view);
	}

	public Integer countAllIndexes(IndexesView view) {
		return indexesDAO.countAllIndexes(view);
	}
	
	@Autowired
	private IIndexesDAO indexesDAO;

}
