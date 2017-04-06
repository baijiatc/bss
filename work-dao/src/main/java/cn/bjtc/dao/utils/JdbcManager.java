package cn.bjtc.dao.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public final class JdbcManager {
	private final static String DEFAULT_HOST = "localhost";
	private final static String DEFAULT_PORT = "3306";
	private final static String DEFAULT_DBTYPE = "MYSQL";
	private DBConfig config;
	private ThreadLocal<Connection> connections = new ThreadLocal<Connection>();
	
	private void loadDriver(){
		try {
			Class.forName(DBChooser.chooseDBDriver(config.getDbType())) ;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void configure(String uname, String upass){
		configure(DEFAULT_DBTYPE,DEFAULT_HOST,DEFAULT_PORT,uname,upass);
	}
	
	public void configure(String dbType, String host, String port, String uname, String upass){
		config = new DBConfig();
		config.setDbType(dbType);
		config.setHost(host);
		config.setPort(port);
		config.setUname(uname);
		config.setUpass(upass);
	}
	
	private void connect(){
		if(config == null){
			configure("root","root");
		}
		try {
			loadDriver();
			String url = String.format(DBChooser.chooseDBUrl(config.getDbType()), config.getHost(),config.getPort(),config.getDbname());
			Connection conn = DriverManager.getConnection(url, config.getUname(), config.getUpass());
			connections.set(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Object> select(String sql){
		if(connections.get() == null){
			connect();
		}
		Connection conn = connections.get();
		return null;
	}
	
	public void save(String sql){
		if(connections.get() == null){
			connect();
		}
		Connection conn = connections.get();
	}
	
	public static JdbcManager getInstance(){
		return JdbcManagerHolder.INSTANCE;
	}
	
	private JdbcManager(){}
	private static final class JdbcManagerHolder{
		static JdbcManager INSTANCE = new JdbcManager();
	}
}
