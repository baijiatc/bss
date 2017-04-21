package cn.bjtc.dao.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import cn.bjtc.dao.IElementDAO;
import cn.bjtc.dao.mybatis.MyBatisDAO;
import cn.bjtc.model.Element;
import cn.bjtc.view.ElementView;

@Component("elemDAO")
public class ElementDAOImpl extends MyBatisDAO<Element, Integer> implements
		IElementDAO {

	public int saveElement(ElementView view) {
		Element role = new Element();
		BeanUtils.copyProperties(view, role);
		return super.save("saveElement", role);
	}

	public int updateElement(ElementView view) {
		return super.update("updateElement", view);
	}

	public List<Element> findAllElements(ElementView view) {
		return super.findByParam("findAllElements", view);
	}

	public Integer countAllElements(ElementView view) {
		return super.countByParam("countAllElements", view);
	}

	public List<Element> findElementsByMenuId(Object menuid) {
		return super.findByParam("findElementsByMenuId", menuid);
	}

}
