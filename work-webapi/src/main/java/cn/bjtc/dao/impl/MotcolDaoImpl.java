package cn.bjtc.dao.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import cn.bjtc.dao.IMotcolDAO;
import cn.bjtc.dao.mybatis.MyBatisDAO;
import cn.bjtc.model.Motcol;
import cn.bjtc.view.MotcolView;

@Component("motcolDao")
public class MotcolDaoImpl extends MyBatisDAO<Motcol, Integer> implements
			IMotcolDAO{

	public List<Motcol> findAllMotcol(MotcolView view) {
		return super.findByParam("findAllMotcol", view);
	}
}
