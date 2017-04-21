package cn.bjtc.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.bjtc.dao.IElementDAO;
import cn.bjtc.model.Element;
import cn.bjtc.service.IElementService;
import cn.bjtc.view.ElementView;

@Service("elemService")
public class ElementServiceImpl implements IElementService {

	public int saveElement(ElementView view) {
		return elemDAO.saveElement(view);
	}

	public int updateElement(ElementView view) {
		return elemDAO.updateElement(view);
	}

	public List<ElementView> findAllElements(ElementView view) {
		List<Element> elems = elemDAO.findAllElements(view);
		if(elems == null || elems.size() <= 0){
			return new ArrayList<ElementView>(0);
		}
		List<ElementView> views = new ArrayList<ElementView>(elems.size());
		for(Element elem : elems){
			ElementView elemView = new ElementView();
			BeanUtils.copyProperties(elem, elemView);
			views.add(elemView);
		}
		return views;
	}

	public Integer countAllElements(ElementView view) {
		return elemDAO.countAllElements(view);
	}
	
	public List<ElementView> findElementsByMenuId(Object menuid) {
		List<Element> elems = elemDAO.findElementsByMenuId(menuid);
		if(elems == null || elems.size() <= 0){
			return new ArrayList<ElementView>(0);
		}
		List<ElementView> views = new ArrayList<ElementView>(elems.size());
		for(Element elem : elems){
			ElementView elemView = new ElementView();
			BeanUtils.copyProperties(elem, elemView);
			views.add(elemView);
		}
		return views;
	}

	@Autowired
	private IElementDAO elemDAO;

}
