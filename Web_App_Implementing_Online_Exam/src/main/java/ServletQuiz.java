
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletQuiz
 */
@WebServlet("/ServletQuiz")
public class ServletQuiz extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletQuiz() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	private String dbURL = "jdbc:mysql://localhost:3306/examdb";
	private String dbUSER = "root";
	private String dbPASS = "root";
	private String dbDRIVER = "com.mysql.jdbc.Driver";

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ClassNotFoundException, SQLException {
		response.setContentType("text/html;charset=UTF-8");
		String solution;
		int score = 0;
		try (PrintWriter out = response.getWriter()) {
			Class.forName(dbDRIVER);
			Connection con = DriverManager.getConnection(dbURL, dbUSER, dbPASS);
			String ins = "insert into examdb.mark values(?,?)";
			PreparedStatement st = con.prepareStatement(ins);

			Cookie[] ck = request.getCookies();
			String nme = ck[0].getValue();

			solution = request.getParameter("1");
			if (solution.equals("False")) {
				score = score + 1;
			}
			solution = request.getParameter("2");
			if (solution.equals("False")) {
				score = score + 1;
			}
			solution = request.getParameter("3");
			if (solution.equals("True")) {
				score = score + 1;
			}
			solution = request.getParameter("4");
			if (solution.equals("True")) {
				score = score + 1;
			}
			solution = request.getParameter("5");
			if (solution.equals("False")) {
				score = score + 1;
			}

			double percent = (score / 5) * 100.0;
			out.println("<h1>Hi, " + nme + " Your score is " + percent + "%</h1>");
			if (percent > 80.0) {
				out.println("<h1 style='color: green;'>Congratulations!!!!</h1>");
				out.println("<h1>You have secured more than 80%</h1>");
			}
			st.setString(1, nme);
			st.setInt(2, score);
			st.executeUpdate();
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Servlet ServletQuiz</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<form action='Report'>");
			out.println("<input type='submit' value='View Report'>");
			out.println("</form>");
			out.println("</body>");
			out.println("</html>");
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
