package cn.bjtc.dao.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import cn.bjtc.dao.IApiDAO;
import cn.bjtc.dao.mybatis.MyBatisDAO;
import cn.bjtc.model.Api;
import cn.bjtc.view.ApiView;

@Component("apiDAO")
public class ApiDAOImpl extends MyBatisDAO<Api, Integer> implements IApiDAO {

	public int saveApi(ApiView view) {
		Api api = new Api();
		BeanUtils.copyProperties(view, api);
		return super.save("saveApi", api);
	}

	public int updateApi(ApiView view) {
		return super.update("updateApi", view);
	}

	public List<Api> findAllApis(ApiView view) {
		return super.findByParam("findAllApis", view);
	}

	public Integer countAllApis(ApiView view) {
		return super.countByParam("countAllApis", view);
	}

}
