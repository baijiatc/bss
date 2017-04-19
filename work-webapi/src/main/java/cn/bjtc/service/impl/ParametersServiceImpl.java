package cn.bjtc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.bjtc.dao.IParametersDAO;
import cn.bjtc.model.Parameters;
import cn.bjtc.service.IParametersService;
import cn.bjtc.view.ParametersView;

@Service("parametersService")
public class ParametersServiceImpl implements IParametersService {


	public int saveParameters(ParametersView view) {
		return parametersDAO.saveParameters(view);
	}

	public int updateParameters(ParametersView view) {
		return  parametersDAO.updateParameters(view);
	}

	public List<Parameters> findAllParameterss(ParametersView view) {
		return parametersDAO.findAllParameterss(view);
	}

	public Integer countAllParameterss(ParametersView view) {
		return parametersDAO.countAllParameterss(view);
	}
 

	@Autowired
	private IParametersDAO parametersDAO;

}
