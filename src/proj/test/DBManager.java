package proj.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBManager {
	
	public static Connection getConnection() {
		Connection cn = null;
		try {
			//Class.forName("net.sf.log4jdbc.DriverSpy");
			Class.forName("oracle.jdbc.OracleDriver");
			//String url="jdbc:log4jdbc:oracle:thin:@70.12.50.62:1521:xe";
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			String uid="bigdata";
			String pwd="bigdata";
			cn=DriverManager.getConnection(url,uid,pwd);
//			Context initContext = new InitialContext();
//			Context envContext = (Context) initContext.lookup("java:/comp/env");
//			DataSource ds = (DataSource) envContext.lookup("jdbc/mydbcp");
//			cn = ds.getConnection();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cn;
	}

	public static void close(Connection cn, PreparedStatement ps, ResultSet rs) {
		try {
			rs.close();
			ps.close();
			cn.close();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public static void close(Connection cn, PreparedStatement ps) {
		try {
			ps.close();
			cn.close();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}