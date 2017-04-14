package cn.bjtc.service;

import java.util.List;

import cn.bjtc.model.SysParam;
import cn.bjtc.view.SysParamView;

public interface ISysParamService {

	public int saveSysParam(SysParamView view);
	public int updateSysParam(SysParamView view);
	public List<SysParam> findAllSysParams(SysParamView view);
	public Integer countAllSysParams(SysParamView view);
	
}
