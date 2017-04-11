package cn.bjtc.service;

import java.util.List;

import cn.bjtc.model.Dictionary;
import cn.bjtc.view.DictionaryView;

public interface IDictService {

	public int saveDict(DictionaryView  view);
	public int updateDict(DictionaryView view);
	public List<Dictionary> findAllDicts(DictionaryView view);
	public Integer countAllDicts(DictionaryView view);
}
