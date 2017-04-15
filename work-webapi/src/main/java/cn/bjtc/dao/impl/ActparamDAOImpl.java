package cn.bjtc.dao.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import cn.bjtc.dao.IActparamDAO;
import cn.bjtc.dao.mybatis.MyBatisDAO;
import cn.bjtc.model.Actparam;
import cn.bjtc.view.ActparamView;

@Component("actparamDao")
public class ActparamDAOImpl extends MyBatisDAO<Actparam, Integer>
               implements  IActparamDAO{

	public int saveActparam(ActparamView view) {
		Actparam actparam=new Actparam();
		BeanUtils.copyProperties(view, actparam);
		return  super.save("saveActparam", actparam);
	}

	public int updateActparam(ActparamView view) {
		return super.update("updateActparam", view);
	}

	public List<Actparam> findAllActparams(ActparamView view) {
		return super.findByParam("findAllActparams", view);
	}

	public Integer countAllActparams(ActparamView view) {
		return  super.countByParam("countAllActparams", view);
	}
    
 
}
