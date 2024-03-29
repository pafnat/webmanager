package net.manager.dbmodels;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySQLServerConnectionBehavior
	extends DBUserInfo
	implements ServerConnectionBehavior
{
	public MySQLServerConnectionBehavior()
	{
		super();
	}
	
	public MySQLServerConnectionBehavior(String uid, String pwd
			, String cat)
	{
		super(uid, pwd, cat);
	}

	public Connection getConnection() {
		try
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection cn = DriverManager.getConnection(getConnectionURL());
			return cn;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

	public String getConnectionURL() {
		return String.format("jdbc:mysql://localhost/%s"
				+ "?user=%s&password=%s"
				, getCatalog()
				, getUserID()
				, getPassword());
	}

	public String getConnectionDetails() {
		return "MySQL Database Connection to " 
					+ getCatalog();
	}

	public String getTablesSchemaQuery() {
		return "select table_name from information_schema.tables "
					+ "where table_schema = " + getCatalog();
	}
}
