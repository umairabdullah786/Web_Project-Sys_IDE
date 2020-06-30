package urlpkg;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import mypkg.*;
/**
 * Servlet implementation class InfoServlet
 */
@WebServlet("/info")
public class InfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			PrintWriter out=response.getWriter();
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>First page(PreServlet)</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<ul>");
			int ui=Integer.parseInt(request.getParameter("uid"));
			MyDao md=MyDao.getObject();
			Statement st=md.getConnection(request);
			String query="SELECT name,hometown,age FROM friends WHERE(uid='"+ui+"')";
			ResultSet rs=st.executeQuery(query);
			if(rs.next()) {
				out.println("<li>"+rs.getString("name")+"</li>");
				out.println("<li>"+rs.getString("hometown")+"</li>");
				out.println("<li>"+rs.getInt("age")+"</li>");
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
