package cn.bjtc.dao.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import cn.bjtc.dao.IIndexesDAO;
import cn.bjtc.dao.mybatis.MyBatisDAO;
import cn.bjtc.model.Indexes;
import cn.bjtc.view.IndexesView;

@Component("indexesDAO")
public class IndexesDAOImpl extends MyBatisDAO<Indexes, Integer> implements
		IIndexesDAO {

	public int saveIndexes(IndexesView view) {
		Indexes Indexes = new Indexes();
		BeanUtils.copyProperties(view, Indexes);
		return super.save("saveIndexes", Indexes);
	}

	public int updateIndexes(IndexesView view) {
		return super.update("updateIndexes", view);
	}

	public List<Indexes> findAllIndexes(IndexesView view) {
		return super.findByParam("findAllIndexes", view);
	}

	public Integer countAllIndexes(IndexesView view) {
		return super.countByParam("countAllIndexes", view);
	}

}
