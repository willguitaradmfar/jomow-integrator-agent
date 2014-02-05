package br.com.jomow.integratorMDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Connector {
	private String driver = "sun.jdbc.odbc.JdbcOdbcDriver";
	private String url;

	public Connector() {
	}
	
	public Connector(String table) {
		this.url = "jdbc:odbc:"+table;
	}

	public Connection getConnection() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {		
			Class.forName(getDriver()).newInstance();
			Connection con = DriverManager.getConnection(getUrl(), "", "");
			return con;		
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	
}
