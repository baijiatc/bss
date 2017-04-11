package cn.bjtc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.bjtc.dao.IDictionaryDao;
import cn.bjtc.model.Dictionary;
import cn.bjtc.service.IDictService;
import cn.bjtc.view.DictionaryView;

@Service("dictionaryService")
public class DictServiceImpl  implements  IDictService{

	public int saveDict(DictionaryView view) {
		return dictionaryDao.saveDict(view);
	}

	public int updateDict(DictionaryView view) {
		return dictionaryDao.updateDict(view);
	}

	public List<Dictionary> findAllDicts(DictionaryView view) {
		return dictionaryDao.findAllDicts(view);
	}

	public Integer countAllDicts(DictionaryView view) {
		return dictionaryDao.countAllDicts(view);
	}

	@Autowired
	private  IDictionaryDao  dictionaryDao;
}
