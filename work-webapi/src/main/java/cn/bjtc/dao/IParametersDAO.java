package cn.bjtc.dao;

import java.util.List;

import cn.bjtc.model.Parameters;
import cn.bjtc.view.ParametersView;

public interface IParametersDAO {

	public int saveParameters(ParametersView view);
	public int updateParameters(ParametersView view);
    public List<Parameters> findAllParameterss(ParametersView view);
	public Integer countAllParameterss(ParametersView view);
}
