package cn.bjtc.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.bjtc.dao.IParametersDAO;
import cn.bjtc.model.Parameters;
import cn.bjtc.model.Parameters;
import cn.bjtc.service.IParametersService;
import cn.bjtc.view.ParametersView;
import cn.bjtc.view.ParametersView;

@Service("parametersService")
public class ParametersServiceImpl implements IParametersService {


	public int saveParameters(ParametersView view) {
		return parametersDAO.saveParameters(view);
	}

	public int updateParameters(ParametersView view) {
		return  parametersDAO.updateParameters(view);
	}

	public List<ParametersView> findAllParameterss(ParametersView view) {
		List<Parameters> Parameterss = parametersDAO.findAllParameterss(view);
		if(Parameterss == null || Parameterss.size() <= 0){
			return new ArrayList<ParametersView>(0);
		}
		List<ParametersView> views = new ArrayList<ParametersView>(Parameterss.size());
		for(Parameters Parameters : Parameterss){
			ParametersView ParametersView = new ParametersView();
			BeanUtils.copyProperties(Parameters, ParametersView);
			views.add(ParametersView);
		}
		return views;
	}

	public Integer countAllParameterss(ParametersView view) {
		return parametersDAO.countAllParameterss(view);
	}
 

	@Autowired
	private IParametersDAO parametersDAO;

}
