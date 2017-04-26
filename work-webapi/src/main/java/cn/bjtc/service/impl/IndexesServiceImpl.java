package cn.bjtc.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
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

	public List<IndexesView> findAllIndexes(IndexesView view) {
		List<Indexes> Indexess = indexesDAO.findAllIndexes(view);
		if(Indexess == null || Indexess.size() <= 0){
			return new ArrayList<IndexesView>(0);
		}
		List<IndexesView> views = new ArrayList<IndexesView>(Indexess.size());
		for(Indexes Indexes : Indexess){
			IndexesView IndexesView = new IndexesView();
			BeanUtils.copyProperties(Indexes, IndexesView);
			views.add(IndexesView);
		}
		return views;
	}

	public Integer countAllIndexes(IndexesView view) {
		return indexesDAO.countAllIndexes(view);
	}
	
	@Autowired
	private IIndexesDAO indexesDAO;

}
