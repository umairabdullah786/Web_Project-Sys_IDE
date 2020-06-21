package mypkg;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			PrintWriter out=response.getWriter();
			String username=request.getParameter("uname");
			String password=request.getParameter("pass");
			int gender=Integer.parseInt(request.getParameter("gender"));
			String[] hobbies=request.getParameterValues("hobbies");
			StringBuilder sb=new StringBuilder();
			int i=0;
			for(;i<hobbies.length-1;i++) {
				sb.append(hobbies[i]+",");
			}
			sb.append(hobbies[i]);
			String date=request.getParameter("date");
			String month=request.getParameter("month");
			String year=request.getParameter("year");  //yyyy-mm-dd
			String dob=year+"-"+month+"-"+date;
			String why=request.getParameter("comments");
			MyDao md=MyDao.getObject();
			Statement st=md.getConnection();
			String query_login="INSERT INTO login_table(username,password,status) VALUES('"+username+"','"+password+"',0)";
			String query_user="INSERT INTO user_table(user_id,gender,hobbies,dob,description,username) VALUES(3003,'"+gender+"','"+sb.toString()+"','"+dob+"','"+why+"','"+username+"')";
			st.execute(query_login);
			st.execute(query_user);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
