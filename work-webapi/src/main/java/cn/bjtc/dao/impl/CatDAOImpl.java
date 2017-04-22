package cn.bjtc.dao.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.bjtc.dao.ICatDAO;
import cn.bjtc.dao.mybatis.MyBatisDAO;
import cn.bjtc.model.Category;
import cn.bjtc.view.CatView;

@Component("catDao")
public class CatDAOImpl extends MyBatisDAO<Category, Integer>
			implements ICatDAO{

	public int saveCat(CatView view) {
		Category cat=new Category();
		BeanUtils.copyProperties(view, cat);
		return super.save("saveCat", cat);
	}

	public int updateCat(CatView view) {
		return super.update("updateCat", view);
	}

	public List<Category> findAllCats(CatView view) {
		return super.findByParam("findAllCats", view);
	}

	public Integer countAllCats(CatView view) {
		return super.countByParam("countAllCats", view);
	}

	
	@Autowired
	private ICatDAO catDao;
	
	
	
}
