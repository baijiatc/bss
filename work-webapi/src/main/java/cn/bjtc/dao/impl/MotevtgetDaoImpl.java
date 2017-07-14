package cn.bjtc.dao.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import cn.bjtc.dao.IMotevtgetDAO;
import cn.bjtc.dao.mybatis.MyBatisDAO;
import cn.bjtc.model.Motevtget;
import cn.bjtc.view.MotevtgetView;

@Component("motevtgetDao")
public class MotevtgetDaoImpl extends MyBatisDAO<Motevtget, Integer> implements
			IMotevtgetDAO{

	public int saveMotevtget(MotevtgetView view) {
		Motevtget Motevtget=new Motevtget();
		BeanUtils.copyProperties(view, Motevtget);;
		return super.save("saveMotevtget", Motevtget);
	}

	public List<Motevtget> findAllMotevtget(MotevtgetView view) {
		 return super.findByParam("findAllMotevtget", view);
	}
	public Integer countAllMotevtget(MotevtgetView view) {
		return super.countByParam("countAllMotevtget", view);
	}

	public int deleteMotevtget(Integer id) {
		return super.delete("deleteMotevtget", id);
	}

	public List<Motevtget> findAllltblname(MotevtgetView view) {
		return super.findByParam("findAllltblname", view);
	}

	public List<Motevtget> findAllrtblname(MotevtgetView view) {
		return super.findByParam("findAllrtblname", view);
	}
}
