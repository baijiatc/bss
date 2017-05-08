package cn.bjtc.service;

import java.util.List;

import cn.bjtc.model.Parameters;
import cn.bjtc.view.ParametersView;

public interface IParametersService {

	public int saveParameters(ParametersView view);
	public int updateParameters(ParametersView view);
    public List<ParametersView> findAllParameterss(ParametersView view);
	public Integer countAllParameterss(ParametersView view);
	
	public List<ParametersView> findAllParameterByProductId(Object productid);
}
