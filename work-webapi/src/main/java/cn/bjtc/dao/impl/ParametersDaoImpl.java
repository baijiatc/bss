package cn.bjtc.dao.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import cn.bjtc.dao.IParametersDAO;
import cn.bjtc.dao.mybatis.MyBatisDAO;
import cn.bjtc.model.Parameters;
import cn.bjtc.view.ParametersView;

@Component("parametersDao")
public class ParametersDaoImpl extends MyBatisDAO<Parameters, Integer> implements
			IParametersDAO{

	public int saveParameters(ParametersView view) {
		Parameters Parameters=new Parameters();
		BeanUtils.copyProperties(view, Parameters);;
		return super.save("saveParameters", Parameters);
	}

	public int updateParameters(ParametersView view) {
		 return super.update("updateParameters", view);
	}

	public List<Parameters> findAllParameterss(ParametersView view) {
		 return super.findByParam("findAllParameters", view);
	}

	public Integer countAllParameterss(ParametersView view) {
		return super.countByParam("countAllParameters", view);
	}
    
	
}
