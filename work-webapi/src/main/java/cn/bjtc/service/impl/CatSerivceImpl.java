package cn.bjtc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.bjtc.dao.ICatDAO;
import cn.bjtc.model.Category;
import cn.bjtc.service.ICatService;
import cn.bjtc.view.CatView;

@Service("catService")
public class CatSerivceImpl implements  ICatService{

	public int saveCat(CatView view) {
		return catDao.saveCat(view) ;
	}

	public int updateCat(CatView view) {
		return catDao.updateCat(view);
	}

	public List<Category> findAllCats(CatView view) {
		return catDao.findAllCats(view);
	}

	public Integer countAllCats(CatView view) {
		return catDao.countAllCats(view);
	}

   @Autowired
   private ICatDAO catDao;
	
}
