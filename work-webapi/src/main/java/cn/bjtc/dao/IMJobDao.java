package cn.bjtc.dao;

import java.util.List;

 
import cn.bjtc.model.MotJob;
import cn.bjtc.view.MotJobView;

public interface IMJobDao {

	public List<MotJob> findAllMJob(MotJobView view);
	public Integer countAllMJob(MotJobView view);
}
