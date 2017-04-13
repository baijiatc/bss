package cn.bjtc.dao.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import cn.bjtc.dao.IIdxrateDAO;
import cn.bjtc.dao.mybatis.MyBatisDAO;
import cn.bjtc.model.Idxparaminstance;
import cn.bjtc.view.IdxrateView;

@Component("idxrateDAO")
public class IdxrateDAOImpl extends MyBatisDAO<Idxparaminstance, Integer> implements
		IIdxrateDAO {

	public int saveIdxrate(IdxrateView view) {
		Idxparaminstance Idxrate = new Idxparaminstance();
		BeanUtils.copyProperties(view, Idxrate);
		return super.save("saveIdxrate", Idxrate);
	}

	public int updateIdxrate(IdxrateView view) {
		return super.update("updateIdxrate", view);
	}

	public List<Idxparaminstance> findAllIdxrate(IdxrateView view) {
		return super.findByParam("findAllIdxrate", view);
	}

	public Integer countAllIdxrate(IdxrateView view) {
		return super.countByParam("countAllIdxrate", view);
	}

}
