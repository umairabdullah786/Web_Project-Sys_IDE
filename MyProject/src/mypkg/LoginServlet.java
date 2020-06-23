package mypkg;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			PrintWriter out=response.getWriter();
			String email=request.getParameter("email");
			String password=request.getParameter("pass");
			MyDao md=MyDao.getObject();
			Statement st=md.getConnection();
			String query_getpass="SELECT password FROM login_table WHERE (username='"+email+"')";
			ResultSet rs=st.executeQuery(query_getpass);
			if(rs.next()) {
				String passwordfromdb=rs.getString("password");
				if(password.equals(passwordfromdb)) {
					out.println("Welcome "+email);
				}else {
					out.println("Either email or password is wrong");
				}
			}else {
				out.println("User does not exist");
			}
				
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
