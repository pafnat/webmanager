package net.manager.dbhelpers;
import javax.servlet.*;

import net.manager.dbmodels.DBManager;
import net.manager.dbmodels.MySQLServerConnectionBehavior;
import net.manager.dbmodels.ServerConnectionBehavior;

public class DBManagerSetup implements ServletContextListener
{
	private DBManager dbm = null;

    public void contextDestroyed(ServletContextEvent arg0) {
		//cleanup the connection when the context is destroyed
		if (dbm != null)
		{
			if (dbm.isConnected())
			{
				dbm.closeConnection(false);
			}
		}
		dbm = null;
	}

	public void contextInitialized(ServletContextEvent sce) {
		//access the servlet context from the event argument (renamed sce)
		//get db con info from context init params
		ServletContext sc = sce.getServletContext();
		String uid = sc.getInitParameter("dbuserid");
		String pwd = sc.getInitParameter("dbuserpwd");
		String cat = sc.getInitParameter("dbinitcat");
		
		//set the scb for mySQL
		ServerConnectionBehavior scb =
				new MySQLServerConnectionBehavior(uid, pwd, cat);
		
		//create the manager
		dbm = new DBManager(scb);
		
		//put the manager into the servlet context attributes for global use in
		//the application
		sc.setAttribute("WorldDBManager", dbm);
		
		//System.out.println("WorldDBManager created and added to context");
	}
}
