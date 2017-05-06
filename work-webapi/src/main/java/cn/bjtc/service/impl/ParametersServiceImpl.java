package cn.bjtc.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.druid.mock.MockParameterMetaData.Parameter;

import cn.bjtc.dao.IParametersDAO;
import cn.bjtc.model.Parameters;
import cn.bjtc.model.Parameters;
import cn.bjtc.model.ProdParm;
import cn.bjtc.service.IParametersService;
import cn.bjtc.view.ParametersView;
import cn.bjtc.view.ParametersView;
import cn.bjtc.view.ProdParmView;

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
 



	public List<ParametersView> findAllParameterByProductId(Object productid) {
		ParametersView view = new ParametersView();
		view.setPageSize(100);
		List<Parameters> allParms =parametersDAO.findAllParameterss(view);
		List<Parameters>  parameters = parametersDAO.findAllParameterByProductId(productid);
		Map<String,Parameters> parametersMap = new HashMap<String, Parameters>();
		for(Parameters parameter : parameters){
			parametersMap.put( parameter.getParamname(),parameter );
		}
		List<ParametersView> views = new ArrayList<ParametersView>(allParms.size());
		for(Parameters parameter : allParms){
			ParametersView  parametersView = new ParametersView();
			if(parametersMap.containsKey(parameter.getParamname())){
				parametersView.setChecked(true);
			}
			BeanUtils.copyProperties(parameter, parametersView);
			views.add(parametersView);
		}
		return views;
	}

	@Autowired
	private IParametersDAO parametersDAO;

}
