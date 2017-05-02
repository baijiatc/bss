package cn.bjtc.quartz.async;

import cn.bjtc.service.ITransService;
import cn.bjtc.tools.SpringUtil;

public class TransCustomer implements IJob {

	public void execute() {
		try {
			ITransService transService = (ITransService) SpringUtil.getBean("transService");
			//transService.transCustomers();
			//transService.transShops();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
