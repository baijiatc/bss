package cn.bjtc.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.bjtc.dao.IDictionaryDao;
import cn.bjtc.model.Activity;
import cn.bjtc.model.Dictionary;
import cn.bjtc.model.Menu;
import cn.bjtc.service.IDictService;
import cn.bjtc.view.ActivityView;
import cn.bjtc.view.DictionaryView;
import cn.bjtc.view.MenuView;

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
		
		DictionaryView view1 = new DictionaryView();
		view1.setPageSize(100);
		List<Dictionary> alldictLst = dictionaryDao.findAllDicts(view1);
		Map<String, String> dictMap = new HashMap<String, String>(alldictLst==null?0:alldictLst.size());
		for(Dictionary dict : alldictLst){
			dictMap.put("d"+dict.getDictid(), dict.getDictname());
		}
		List<DictionaryView> views = new ArrayList<DictionaryView>(dicts.size());
		for(Dictionary dict : dicts){
			DictionaryView dictView = new DictionaryView();
			BeanUtils.copyProperties(dict, dictView);
			if (dict.getDicttype() == 0) {
				dictView.setDtname("定义类型");
			}else{
				dictView.setDtname(dictMap.get("d"+dict.getDicttype()));
			}
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
