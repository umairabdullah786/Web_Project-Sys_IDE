package work;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Serv1
 */
@WebServlet("/serv1")
public class Serv1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Serv1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			PrintWriter out=response.getWriter();
			String fname=request.getParameter("fname");
			String lname=request.getParameter("lname");
			
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Insert title here</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<form action='serv2' method='post' >");
			out.println("<ul>");
			out.println("<li>Please Fill Data For Servlet2 Here</li>\n");
			out.println("<li><input type=\"hidden\" name=\"fname\" value='"+fname+"'/><li>");
			out.println("<li><input type=\"hidden\" name=\"lname\" value='"+lname+"'/><li>");
			out.println("<li><input type=\"text\" name=\"age\" placeholder=\"Age\"/><li>");
			out.println("<li><input type=\"text\" name=\"college\" placeholder=\"College\"/><li>");
			out.println("<li><input type=\"submit\" value=\"Login\"/></li>");
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
