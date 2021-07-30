package co.jeju.jejuProject.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DataSource { // DAO
	private static DataSource dataSource = new DataSource(); // 싱글톤 클래스 생성
	private Connection conn;
	private String driver;
	private String url;
	private String user;
	private String password;
	
	private DataSource() {} // 외부에서 생성 못하도록 private로 생성
	
	public static DataSource getInstance() {
		return dataSource;
	}
	
	public Connection getConnection() {
		configure();
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	
	private void configure() {
		Properties properties = new Properties();
		String resource = getClass().getResource("/db.properties").getPath();
		
		try {
			properties.load(new FileReader(resource));
			driver = properties.getProperty("driver");
			url = properties.getProperty("url");
			user = properties.getProperty("user");
			password = properties.getProperty("password");
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}
