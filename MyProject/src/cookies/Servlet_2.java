package cookies;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Servlet_2
 */
@WebServlet("/se2")
public class Servlet_2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet_2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		int age=Integer.parseInt(request.getParameter("age"));
		String college=request.getParameter("college");
		
		//Cookies Method to get data in a text form to fetch data from 1 servlet to another 
		
		/*Cookie[] cka=request.getCookies();*/
		
		HttpSession session=request.getSession(false);
			
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Insert data for 2nd Servlet here</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<ul>");
		out.println("<li>"+age+"</li>");
		out.println("<li>"+college+"</li>");
		out.println("<li>"+session.getAttribute("fn")+"</li>");
		out.println("<li>"+session.getAttribute("ln")+"</li>");
		/*for(int i=0;i<cka.length;i++) {
			out.println("<li>"+cka[i].getValue()+"</li>");
		}*/
		out.println("</ul>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
