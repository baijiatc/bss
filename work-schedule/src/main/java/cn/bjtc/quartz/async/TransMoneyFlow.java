package cn.bjtc.quartz.async;

import cn.bjtc.service.ITransService;
import cn.bjtc.tools.SpringUtil;

public class TransMoneyFlow implements IJob {

	public void execute() {
		ITransService transService = (ITransService) SpringUtil.getBean("transService");
		//transService.transMoneyFlows();
	}

}
