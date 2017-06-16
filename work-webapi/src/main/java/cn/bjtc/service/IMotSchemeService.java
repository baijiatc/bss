package cn.bjtc.service;

import java.util.List;

import cn.bjtc.model.MotScheme;
import cn.bjtc.view.MotSchemeView;

public interface IMotSchemeService {

	public int saveMotScheme(MotSchemeView  view);
	public int updateMotScheme(MotSchemeView view);
	public List<MotSchemeView> findAllMotScheme(MotSchemeView view);
	public Integer countAllMotScheme(MotSchemeView view);
}
