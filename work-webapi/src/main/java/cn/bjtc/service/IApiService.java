package cn.bjtc.service;

import java.util.List;

import cn.bjtc.model.Api;
import cn.bjtc.view.ApiView;

public interface IApiService {

	public int saveApi(ApiView view);
	public int updateApi(ApiView view);
	public List<Api> findAllApis(ApiView view);
	public Integer countAllApis(ApiView view);
}
