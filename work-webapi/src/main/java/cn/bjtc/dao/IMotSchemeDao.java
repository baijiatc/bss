package cn.bjtc.dao;

import java.util.List;

import cn.bjtc.model.MotScheme;
import cn.bjtc.view.MotSchemeView;

public interface IMotSchemeDao {

	public int saveMotScheme(MotSchemeView  view);
	public int updateMotScheme(MotSchemeView view);
	public List<MotScheme> findAllMotScheme(MotSchemeView view);
	public Integer countAllMotScheme(MotSchemeView view);
}
