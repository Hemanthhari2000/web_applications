
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StudentForm
 */
@WebServlet("/StudentForm")
public class StudentForm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StudentForm() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	final String resContentType = "text/html;charset=UTF-8";

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType(resContentType);
		try (PrintWriter out = response.getWriter()) {
			String sub1, sub2, sub3 = null;
			String name = request.getParameter("name");
			String rollno = request.getParameter("roll");
			String regno = request.getParameter("regno");
			String dept = request.getParameter("dept");
			String dob = request.getParameter("dob");
			String sem = request.getParameter("semester");
			String mail = request.getParameter("mail");
			sub1 = request.getParameter("gt");
			sub2 = request.getParameter("gis");
			sub3 = request.getParameter("evs");

			System.out.println(sem);

			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Student Registration Details</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h2>Student Registration Details</h2><hr>");
			out.println("<table><tr><td><h3>Student Name</h3></td><td>" + name + "</td></tr>");
			out.println("<tr><td><h3>Roll Number</h3></td><td>" + rollno + "</td></tr>");
			out.println("<tr><td><h3>Register Number</h3></td><td>" + regno + "</td></tr>");
			out.println("<tr><td><h3>Department</td><td></h3>" + dept + "</td></tr>");
			out.println("<tr><td><h3>Date of Birth</h3></td><td>" + dob + "</td></tr>");
			out.println("<tr><td><h3>Email Id</h3></td><td>" + mail + "</td></tr>");
			out.println("<tr><td><h3>Current Semester</h3></td><td>" + sem + "</td></tr>");
			out.println("<tr><td><h3>Subjects</td></h3>");

			if (sub1 != null)
				out.println("<td>" + sub1 + "</td></tr>");
			if (sub2 != null)
				out.println("<tr><td></td><td>" + sub2 + "</td></tr>");
			if (sub3 != null)
				out.println("<tr><td></td><td>" + sub3 + "</td></tr>");
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
