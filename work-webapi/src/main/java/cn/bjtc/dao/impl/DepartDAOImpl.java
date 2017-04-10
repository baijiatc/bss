package cn.bjtc.dao.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import cn.bjtc.dao.IDepartDAO;
import cn.bjtc.dao.mybatis.MyBatisDAO;
import cn.bjtc.model.Depart;
import cn.bjtc.view.DepartView;

@Component("departDAO")
public class DepartDAOImpl extends MyBatisDAO<Depart, Integer> implements
		IDepartDAO {

	public int saveDepart(DepartView view) {
		Depart dept = new Depart();
		BeanUtils.copyProperties(view, dept);
		return super.save("saveDepart", dept);
	}

	public int updateDepart(DepartView view) {
		return super.update("updateDepart", view);
	}

	public List<Depart> findAllDepart(DepartView view) {
		return super.findByParam("findAllDepart", view);
	}

	public Integer countAllDepart(DepartView view) {
		return super.countByParam("countAllDepart", view);
	}
}
