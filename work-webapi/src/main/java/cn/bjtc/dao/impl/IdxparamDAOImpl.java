package cn.bjtc.dao.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import cn.bjtc.dao.IIdxparamDAO;
import cn.bjtc.dao.mybatis.MyBatisDAO;
import cn.bjtc.model.Idxparam;
import cn.bjtc.view.IdxparamView;

@Component("idxparamDAO")
public class IdxparamDAOImpl extends MyBatisDAO<Idxparam, Integer> implements
		IIdxparamDAO {

	public int saveIdxparam(IdxparamView view) {
		Idxparam Idxparam = new Idxparam();
		BeanUtils.copyProperties(view, Idxparam);
		return super.save("saveIdxparam", Idxparam);
	}

	public int updateIdxparam(IdxparamView view) {
		return super.update("updateIdxparam", view);
	}

	public List<Idxparam> findAllIdxparam(IdxparamView view) {
		return super.findByParam("findAllIdxparam", view);
	}

	public Integer countAllIdxparam(IdxparamView view) {
		return super.countByParam("countAllIdxparam", view);
	}

}
