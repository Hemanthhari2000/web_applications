
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Report
 */
@WebServlet("/Report")
public class Report extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Report() {
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
		String name1, cs;
		int sc, i = 0;
		try (PrintWriter out = response.getWriter()) {
			Class.forName(dbDRIVER);
			Connection con = DriverManager.getConnection(dbURL, dbUSER, dbPASS);
			Statement st = con.createStatement();
			String str = "Select * from mark";
			ResultSet rs = st.executeQuery(str);

			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Servlet Report</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>Exam Report</h1>");
			out.println("<table border='1'>");
			out.println("<tr><th>Student name</th>");
			out.println("<th>Score</th></tr>");
			out.println("<tr>");
			while (rs.next()) {
				name1 = rs.getString("name");
				sc = rs.getInt("Score");
				out.println("<td>" + name1 + "</td><td>" + sc + "</td>" + "</tr>");

			}
			out.println("</table>");
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
