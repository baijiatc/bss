package cn.bjtc.dao.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import cn.bjtc.dao.IMoteventattachDAO;
import cn.bjtc.dao.mybatis.MyBatisDAO;
import cn.bjtc.model.Moteventattach;
import cn.bjtc.view.MoteventattachView;

@Component("moteventattachDao")
public class MoteventattachDAOImpl extends MyBatisDAO<Moteventattach, Integer> implements
			IMoteventattachDAO{

	public int saveMoteventattach(MoteventattachView view) {
		Moteventattach moteventattach=new Moteventattach();
		BeanUtils.copyProperties(view, moteventattach);;
		return super.save("saveMoteventattach", moteventattach);
	}

	public int updateMoteventattach(MoteventattachView view) {
		 return super.update("updateMoteventattach", view);
	}

	public List<Moteventattach> findAllMoteventattach(MoteventattachView view) {
		 return super.findByParam("findAllMoteventattach", view);
	}

	public Integer countAllMoteventattach(MoteventattachView view) {
		return super.countByParam("countAllMoteventattach", view);
	}
}
