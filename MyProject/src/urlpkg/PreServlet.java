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
 * Servlet implementation class PreServlet
 */
@WebServlet("/pre")
public class PreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PreServlet() {
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
			MyDao md=MyDao.getObject();
			Statement st=md.getConnection();
			String query="SELECT uid,name FROM friends";
			ResultSet rs=st.executeQuery(query);
			while(rs.next()){
				out.println("<li><a href='info?uid="+rs.getInt("uid")+"'>"+rs.getString("name")+"</a></li>");
			}
			out.println("</ul>");
			out.println("</form>");
			out.println("</body>");
			out.println("</html>");
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
