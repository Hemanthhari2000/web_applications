
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

/**
 * Servlet implementation class Search
 */
@WebServlet("/Search")
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Search() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException, ClassNotFoundException, SQLException {
		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = response.getWriter()) {
			String num = request.getParameter("search");
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookdb", "root", "Hemanth@1234");
			String str = "select BookName, Author, Price from bookdb.books where ISBN =?";
			PreparedStatement st = con.prepareStatement(str);
			st.setString(1, num);
			ResultSet rs = st.executeQuery();
			ResultSetMetaData rsm = (ResultSetMetaData) rs.getMetaData();
			out.println("<fieldset style='width:20%'><legend><b>BOOK DETAILS</b></legend> <table>");
			while (rs.next()) {
				out.println("<tr><td><b>Book Name</b></td><td>" + rs.getString(1) + "</td></tr>");
				out.println("<tr><td><b>Author</b></td><td>" + rs.getString(2) + "</td></tr>");
				out.println("<tr><td><b>Book Price</b></td><td>" + rs.getInt(3) + "</td></tr>");
			}
			out.println("</table></fieldset>");
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Book Details</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<form action='book.jsp'>");
			out.println("<input type='submit' value='BACK'>");
			out.println("</form>");
			out.println("</body>");
			out.println("</html>");
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (ClassNotFoundException | IOException | ServletException | SQLException e) {
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
		} catch (ClassNotFoundException | IOException | ServletException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
