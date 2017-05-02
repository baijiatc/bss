package cn.bjtc.quartz.async;

import cn.bjtc.service.ITransService;
import cn.bjtc.tools.SpringUtil;

public class TransOrder implements IJob {

	public void execute() {
		ITransService transService = (ITransService) SpringUtil.getBean("transService");
		//transService.transOrders();
	}

}
