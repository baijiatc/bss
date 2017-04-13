package cn.bjtc.dao.dynamic;

public class DynamicDataSourceHolder {
	public static final ThreadLocal<String> holder = new ThreadLocal<String>();
	
	public static void putDataSource(String name) {
		holder.set(name);
	}
	
	public static String getDataSouce() {
		return holder.get();
	}
}
