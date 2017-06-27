package cn.bjtc.dao.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import cn.bjtc.dao.IMJobDao;
import cn.bjtc.dao.mybatis.MyBatisDAO;
import cn.bjtc.model.MotJob;
import cn.bjtc.view.MotJobView;

@Component("motjobDao")
public class MtJobDaoImpl extends MyBatisDAO<MotJob, Integer>
              implements IMJobDao{

	public List<MotJob> findAllMJob(MotJobView view) {
		return super.findByParam("findAllMJob", view);
	}

	public Integer countAllMJob(MotJobView view) {
		return super.countByParam("countAllMJob", view);
	}

}
