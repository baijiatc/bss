package cn.bjtc.load;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.bjtc.api.ApiManager;
import cn.bjtc.model.Api;
import cn.bjtc.model.SysParam;
import cn.bjtc.service.IApiService;
import cn.bjtc.service.ISysParamService;
import cn.bjtc.tools.ApplicationDataManager;
import cn.bjtc.view.ApiView;
import cn.bjtc.view.SysParamView;

public class StartupLoader {
	
	public void init(){
		initApiMap();
		initSysParam();
	}
	
	public void initApiMap(){
		ApiView view = new ApiView();
		view.setApist(1);
		view.setPageSize(Integer.MAX_VALUE);
		List<Api> apis = apiService.findAllApis(view);
		for(Api api : apis){
			ApiManager.API_MAP.put(api.getCode(), api.getApiurl());
		}
	}
	
	public void initSysParam(){
		SysParamView view = new SysParamView();
		view.setPageSize(Integer.MAX_VALUE);
		List<SysParam> sysParams = sysParmService.findAllSysParams(view);
		for(SysParam sysParam : sysParams){
			ApplicationDataManager.SYSPARAMS.put(sysParam.getCode(), sysParam.getParamvalue());
		}
	}
	
	@Autowired
	private IApiService apiService;
	@Autowired
	private ISysParamService sysParmService;
}
