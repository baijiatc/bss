package cn.bjtc.dao.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import cn.bjtc.dao.ISpecDAO;
import cn.bjtc.dao.mybatis.MyBatisDAO;
import cn.bjtc.model.Role;
import cn.bjtc.model.Spec;
import cn.bjtc.view.SpecView;

@Component("specDao")
public class SpecDaoImpl extends MyBatisDAO<Spec, Integer> implements
			ISpecDAO{

	public int saveSpec(SpecView view) {
		Spec Spec=new Spec();
		BeanUtils.copyProperties(view, Spec);;
		return super.save("saveSpec", Spec);
	}

	public int updateSpec(SpecView view) {
		 return super.update("updateSpec", view);
	}

	public List<Spec> findAllSpecs(SpecView view) {
		 return super.findByParam("findAllSpec", view);
	}

	public Integer countAllSpecs(SpecView view) {
		return super.countByParam("countAllSpec", view);
	}
	public List<Spec> findAllSpecBySkuId(Object skuid) {
		return super.findByParam("findAllSpecBySkuId", skuid);
	}
	
}
