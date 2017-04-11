package cn.bjtc.dao;

import java.util.List;

import cn.bjtc.model.Dictionary;
import cn.bjtc.view.DictionaryView;

public interface IDictionaryDao {
	public int saveDict(DictionaryView view);
	public int updateDict(DictionaryView view);
	public List<Dictionary> findAllDicts(DictionaryView view);
	public Integer countAllDicts(DictionaryView view);
	

}
