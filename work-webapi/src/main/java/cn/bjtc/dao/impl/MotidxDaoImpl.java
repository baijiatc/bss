package cn.bjtc.dao.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import cn.bjtc.dao.IMotidxDAO;
import cn.bjtc.dao.mybatis.MyBatisDAO;
import cn.bjtc.model.Motidx;
import cn.bjtc.view.MotidxView;

@Component("motidxDao")
public class MotidxDaoImpl extends MyBatisDAO<Motidx, Integer> implements
			IMotidxDAO{

	public int saveMotidx(MotidxView view) {
		Motidx Motidx=new Motidx();
		BeanUtils.copyProperties(view, Motidx);;
		return super.save("saveMotidx", Motidx);
	}

	public int updateMotidx(MotidxView view) {
		 return super.update("updateMotidx", view);
	}

	public List<Motidx> findAllMotidx(MotidxView view) {
		 return super.findByParam("findAllMotidx", view);
	}

	public Integer countAllMotidx(MotidxView view) {
		return super.countByParam("countAllMotidx", view);
	}

	public List<Motidx> findAlltblname(MotidxView view) {
		return super.findByParam("findAlltblname", view);
	}

	public List<Motidx> findAllcolname(MotidxView view) {
		return super.findByParam("findAllcolname", view);
	}


}
