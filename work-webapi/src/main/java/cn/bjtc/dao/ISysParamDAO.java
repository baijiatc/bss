package cn.bjtc.dao;

import java.util.List;

import cn.bjtc.model.SysParam;
import cn.bjtc.view.SysParamView;

public interface ISysParamDAO {

	public int saveSysParam(SysParamView view);
	public int updateSysParam(SysParamView view);
	public List<SysParam> findAllSysParams(SysParamView view);
	public Integer countAllSysParams(SysParamView view);
}
