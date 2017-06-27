package cn.bjtc.service;

import java.util.List;
 
import cn.bjtc.view.MotJobView;

public interface IMtJobService {

	public List<MotJobView> findAllMJob(MotJobView view);
	public Integer countAllMJob(MotJobView view);
}
