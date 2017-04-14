package cn.bjtc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.bjtc.dao.ISysParamDAO;
import cn.bjtc.model.SysParam;
import cn.bjtc.service.ISysParamService;
import cn.bjtc.view.SysParamView;

@Service("sysParamService")
public class SysParamServiceImpl implements ISysParamService {

	public int saveSysParam(SysParamView view) {
		return sysParamDAO.saveSysParam(view);
	}

	public int updateSysParam(SysParamView view) {
		return sysParamDAO.updateSysParam(view);
	}

	public List<SysParam> findAllSysParams(SysParamView view) {
		return sysParamDAO.findAllSysParams(view);
	}

	public Integer countAllSysParams(SysParamView view) {
		return sysParamDAO.countAllSysParams(view);
	}
	
	@Autowired
	private ISysParamDAO sysParamDAO;

}
