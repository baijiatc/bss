package cn.bjtc.dao.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import cn.bjtc.dao.IMotevtelmDAO;
import cn.bjtc.dao.mybatis.MyBatisDAO;
import cn.bjtc.model.Motevtelm;
import cn.bjtc.view.MotevtelmView;

@Component("motevtelmDao")
public class MotevtelmDaoImpl extends MyBatisDAO<Motevtelm, Integer> implements
			IMotevtelmDAO{

	public int saveMotevtelm(MotevtelmView view) {
		Motevtelm Motevtelm=new Motevtelm();
		BeanUtils.copyProperties(view, Motevtelm);;
		return super.save("saveMotevtelm", Motevtelm);
	}

	public List<Motevtelm> findAllMotevtelm(MotevtelmView view) {
		 return super.findByParam("findAllMotevtelm", view);
	}
	public Integer countAllMotevtelm(MotevtelmView view) {
		return super.countByParam("countAllMotevtelm", view);
	}

	public int deleteMotevtelm(Integer id) {
		return super.delete("deleteMotevtelm", id);
	}

}
