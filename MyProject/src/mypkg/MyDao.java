package mypkg;

import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
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
	public Statement getConnection(HttpServletRequest request)throws ClassNotFoundException,SQLException{
		String cname=request.getServletContext().getInitParameter("classname");
		String url=request.getServletContext().getInitParameter("url");
		String username=request.getServletContext().getInitParameter("username");
		String password=request.getServletContext().getInitParameter("password");
		Class.forName(cname);
		con=DriverManager.getConnection(url, username, password);
		st=con.createStatement();
		return st;
	}

}
