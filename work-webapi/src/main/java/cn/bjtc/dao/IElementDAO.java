package cn.bjtc.dao;

import java.util.List;

import cn.bjtc.model.Element;
import cn.bjtc.view.ElementView;

public interface IElementDAO {

	public int saveElement(ElementView view);
	public int updateElement(ElementView view);
    public List<Element> findAllElements(ElementView view);
	public Integer countAllElements(ElementView view);
	public List<Element> findElementsByMenuId(Object menuid);
}
