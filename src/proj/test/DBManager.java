package proj.test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBManager {
	public static Connection getConnection(){
		Connection cn=null;
		try{
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			DataSource ds =(DataSource) envContext.lookup("jdbc/myoracle");
			cn=ds.getConnection();
		}catch(Exception e){
			e.printStackTrace();
		}
		return cn;
	}

		public static void close(Connection cn,Statement ps, ResultSet rs){
			try{
				rs.close();
				ps.close();
				cn.close();
				
			}catch (Exception e) {
				// TODO: handle exception
			e.printStackTrace();
			}
		}
		public static void close(Connection cn, Statement ps){
			try{
				
				ps.close();
				cn.close();
				
			}catch (Exception e) {
				// TODO: handle exception
			e.printStackTrace();
			}
}
}