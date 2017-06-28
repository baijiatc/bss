package cn.bjtc.service;

import java.util.List;

import cn.bjtc.view.MoteventschemeView;

public interface IMoteventschemeService {

	public int saveMoteventscheme(MoteventschemeView view);
	public int deleteMoteventscheme(Integer id);
	public List<MoteventschemeView> findAllMoteventscheme(MoteventschemeView view);
	public Integer countAllMoteventscheme(MoteventschemeView view);
}
