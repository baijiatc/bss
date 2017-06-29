package cn.bjtc.dao.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import cn.bjtc.dao.IMottblDAO;
import cn.bjtc.dao.mybatis.MyBatisDAO;
import cn.bjtc.model.Mottbl;
import cn.bjtc.view.MottblView;

@Component("mottblDao")
public class MottblDaoImpl extends MyBatisDAO<Mottbl, Integer> implements
			IMottblDAO{

	public List<Mottbl> findAllMottbl(MottblView view) {
		return super.findByParam("findAllMottbl", view);
	}

}
