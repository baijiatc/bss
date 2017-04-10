package cn.bjtc.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.bjtc.model.Api;
import cn.bjtc.service.IApiService;
import cn.bjtc.view.ApiView;

public class StartupBean {

	public void init(){
		initApiMap();
	}
	
	private void initApiMap(){
		ApiView view = new ApiView();
		view.setApist(1);
		view.setPageSize(Integer.MAX_VALUE);
		List<Api> apis = apiService.findAllApis(view);
		for(Api api : apis){
			ApiManager.API_MAP.put(api.getCode(), api.getApiurl());
		}
	}
	
	@Autowired
	private IApiService apiService;
}
