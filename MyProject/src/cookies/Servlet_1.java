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
 * Servlet implementation class Servlet_1
 */
@WebServlet("/se1")
public class Servlet_1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet_1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String faname=request.getParameter("faname");
		String laname=request.getParameter("laname");
		/*Cookie ck1=new Cookie("fn",faname);
		Cookie ck2=new Cookie("ln",laname);
		response.addCookie(ck1);
		response.addCookie(ck2);*/
		
		HttpSession session=request.getSession();
		session.setAttribute("fn", faname);
		session.setAttribute("ln", laname);
		
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"UTF-8\">");
		out.println("<title>Insert title here</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<form action='se2' method='get' >");
		out.println("<ul>");
		out.println("<li>Please Fill Data For Servlet2 Here</li>\n");
		out.println("<li><input type=\"text\" name=\"age\" placeholder=\"Age\"/><li>");
		out.println("<li><input type=\"text\" name=\"college\" placeholder=\"College\"/><li>");
		out.println("<li><input type=\"submit\" value=\"Submit\"/></li>");
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
