
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Exam
 */
@WebServlet("/Exam")
public class Exam extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Exam() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String name, pass;
		try (PrintWriter out = response.getWriter()) {
			name = request.getParameter("uname");
			pass = request.getParameter("pass");
			Cookie ck = new Cookie("unmae", name);
			response.addCookie(ck);
			if (pass.equals("test")) {
				out.println("<h1>Welocme " + name + "!!!!</h1>");
				out.println("<form action='questions.html'>");
				out.println("<input type='submit' value='Take Test'>");
				out.println("</form>");
			} else {
				out.println("<h3>Invalid password</h3>");
			}
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Servlet exam</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("</body>");
			out.println("</html>");
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

}
