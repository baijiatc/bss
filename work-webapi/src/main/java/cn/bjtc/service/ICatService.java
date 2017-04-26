package cn.bjtc.service;

import java.util.List;

import cn.bjtc.view.CatView;

public interface ICatService {

	public int saveCat(CatView view);
	public int updateCat(CatView view);
	public List<CatView> findAllCats(CatView view);
	public Integer countAllCats(CatView view);
}
