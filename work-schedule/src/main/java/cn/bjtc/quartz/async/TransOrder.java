package cn.bjtc.quartz.async;

public class TransOrder implements IJob {

	public void execute() {
		System.out.println("执行订单数据传输!!!");
	}

}
