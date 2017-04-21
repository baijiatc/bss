package cn.bjtc.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.bjtc.dao.IApiDAO;
import cn.bjtc.model.Api;
import cn.bjtc.service.IApiService;
import cn.bjtc.view.ApiView;

@Service("apiService")
public class ApiServiceImpl implements IApiService {

	public int saveApi(ApiView view) {
		return apiDAO.saveApi(view);
	}

	public int updateApi(ApiView view) {
		return apiDAO.updateApi(view);
	}

	public List<ApiView> findAllApis(ApiView view) {
		List<Api> apis = apiDAO.findAllApis(view);
		if(apis == null){
			return new ArrayList<ApiView>(0);
		}
		List<ApiView> views = new ArrayList<ApiView>(apis.size());
		for(Api api : apis){
			ApiView apiView = new ApiView();
			BeanUtils.copyProperties(api, apiView);
			views.add(apiView);
		}
		return views;
	}

	public Integer countAllApis(ApiView view) {
		return apiDAO.countAllApis(view);
	}
	
	@Autowired
	private IApiDAO apiDAO;

}
