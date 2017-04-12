package cn.bjtc.quartz.async;

public class TransCustomer implements IJob {

	public void execute() {
		System.out.println("执行客户数据传输!!!");
	}

}
