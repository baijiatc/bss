package cn.bjtc.dao.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import cn.bjtc.dao.ISysParamDAO;
import cn.bjtc.dao.mybatis.MyBatisDAO;
import cn.bjtc.model.SysParam;
import cn.bjtc.view.SysParamView;

@Component("sysParamDAO")
public class SysParamDAOImpl extends MyBatisDAO<SysParam, Integer> implements
		ISysParamDAO {

	public int saveSysParam(SysParamView view) {
		SysParam sysparam = new SysParam();
		BeanUtils.copyProperties(view, sysparam);
		return super.save("saveSysParam", sysparam);
	}

	public int updateSysParam(SysParamView view) {
		return super.update("updateSysParam", view);
	}

	public List<SysParam> findAllSysParams(SysParamView view) {
		return super.findByParam("findAllSysParams", view);
	}

	public Integer countAllSysParams(SysParamView view) {
		return super.countByParam("countAllSysParams", view);
	}

}
