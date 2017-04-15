package cn.bjtc.quartz.async;

public class TransMoneyFlow implements IJob {

	public void execute() {
		System.out.println("执行资金流水数据传输!!!");
	}

}
