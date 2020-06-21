package mypkg;

import java.sql.*;
public class MyDao {
	Connection con=null;
	Statement st=null;
	static MyDao md=null;
	private MyDao() {}
	public static MyDao getObject() {
		if(md==null) {
			md=new MyDao();
		}
		return md;
	}
	public Statement getConnection()throws ClassNotFoundException,SQLException{
		Class.forName("com.mysql.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/myschema";
		String username="root";
		String password="Umair@786";
		con=DriverManager.getConnection(url, username, password);
		st=con.createStatement();
		return st;
	}

}
