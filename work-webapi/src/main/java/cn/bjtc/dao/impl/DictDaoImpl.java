package cn.bjtc.dao.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import cn.bjtc.dao.IDictionaryDao;
import cn.bjtc.dao.mybatis.MyBatisDAO;
import cn.bjtc.model.Dictionary;
import cn.bjtc.view.DictionaryView;

@Component("dictDao")
public class DictDaoImpl extends MyBatisDAO<Dictionary, Integer> implements
             IDictionaryDao{

	public int saveDict(DictionaryView view) {
		Dictionary dict=new Dictionary();
		BeanUtils.copyProperties(view, dict);;
		return super.save("saveDict", dict);
	}

	public int updateDict(DictionaryView view) {
		 return super.update("updateDict", view);
	}

	public List<Dictionary> findAllDicts(DictionaryView view) {
		 return super.findByParam("findAllDicts", view);
	}

	public Integer countAllDicts(DictionaryView view) {
		return super.countByParam("countAllDicts", view);
	}
    
	
}
