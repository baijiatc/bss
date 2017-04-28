package cn.bjtc.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.bjtc.dao.ICatDAO;
import cn.bjtc.model.Category;
import cn.bjtc.model.Role;
import cn.bjtc.service.ICatService;
import cn.bjtc.view.CatView;
import cn.bjtc.view.RoleView;

@Service("catService")
public class CatSerivceImpl implements  ICatService{

	public int saveCat(CatView view) {
		return catDao.saveCat(view) ;
	}

	public int updateCat(CatView view) {
		return catDao.updateCat(view);
	}

	public List<CatView> findAllCats(CatView view) {
		List<Category> cats = catDao.findAllCats(view);
		if(cats == null || cats.size() <= 0){
			return new ArrayList<CatView>(0);
		}
		List<CatView> views = new ArrayList<CatView>(cats.size());
		for(Category cat : cats){
			CatView catView = new CatView();
			BeanUtils.copyProperties(cat, catView);
			views.add(catView);
		}
		return views;
	}


	public Integer countAllCats(CatView view) {
		return catDao.countAllCats(view);
	}

   @Autowired
   private ICatDAO catDao;
	
}
