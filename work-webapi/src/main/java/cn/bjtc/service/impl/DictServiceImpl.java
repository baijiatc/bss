package cn.bjtc.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.bjtc.dao.IDictionaryDao;
import cn.bjtc.model.Activity;
import cn.bjtc.model.Dictionary;
import cn.bjtc.service.IDictService;
import cn.bjtc.view.ActivityView;
import cn.bjtc.view.DictionaryView;

@Service("dictionaryService")
public class DictServiceImpl  implements  IDictService{

	public int saveDict(DictionaryView view) {
		return dictionaryDao.saveDict(view);
	}

	public int updateDict(DictionaryView view) {
		return dictionaryDao.updateDict(view);
	}

	public List<DictionaryView> findAllDicts(DictionaryView view) {
		List<Dictionary> dicts = dictionaryDao.findAllDicts(view);
		if(dicts == null ||dicts.size() <= 0){
			return new ArrayList<DictionaryView>(0);
		}
		List<DictionaryView> views = new ArrayList<DictionaryView>(dicts.size());
		for(Dictionary dict : dicts){
			DictionaryView dictView = new DictionaryView();
			BeanUtils.copyProperties(dict, dictView);
			views.add(dictView);
		}
		return views;
	}

	public Integer countAllDicts(DictionaryView view) {
		return dictionaryDao.countAllDicts(view);
	}

	@Autowired
	private  IDictionaryDao  dictionaryDao;
}
