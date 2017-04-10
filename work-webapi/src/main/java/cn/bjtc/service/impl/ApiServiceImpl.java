package cn.bjtc.service.impl;

import java.util.List;

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

	public List<Api> findAllApis(ApiView view) {
		return apiDAO.findAllApis(view);
	}

	public Integer countAllApis(ApiView view) {
		return apiDAO.countAllApis(view);
	}
	
	@Autowired
	private IApiDAO apiDAO;

}
