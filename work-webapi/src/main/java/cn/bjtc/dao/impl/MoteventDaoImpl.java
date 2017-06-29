package cn.bjtc.dao.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import cn.bjtc.dao.IMoteventDAO;
import cn.bjtc.dao.mybatis.MyBatisDAO;
import cn.bjtc.model.Motevent;
import cn.bjtc.view.MoteventView;

@Component("moteventDao")
public class MoteventDaoImpl extends MyBatisDAO<Motevent, Integer> implements
			IMoteventDAO{

	public int saveMotevent(MoteventView view) {
		Motevent Motevent=new Motevent();
		BeanUtils.copyProperties(view, Motevent);;
		return super.save("saveMotevent", Motevent);
	}

	public int updateMotevent(MoteventView view) {
		 return super.update("updateMotevent", view);
	}

	public List<Motevent> findAllMotevent(MoteventView view) {
		 return super.findByParam("findAllMotevent", view);
	}

	public Integer countAllMotevent(MoteventView view) {
		return super.countByParam("countAllMotevent", view);
	}
}
