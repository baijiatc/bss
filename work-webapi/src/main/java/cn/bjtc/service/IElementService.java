package cn.bjtc.service;

import java.util.List;

import cn.bjtc.view.ElementView;

public interface IElementService {

	public int saveElement(ElementView view);
	public int updateElement(ElementView view);
	public List<ElementView> findAllElements(ElementView view);
	public Integer countAllElements(ElementView view);
	public List<ElementView> findElementsByMenuId(Object menuid);
}
