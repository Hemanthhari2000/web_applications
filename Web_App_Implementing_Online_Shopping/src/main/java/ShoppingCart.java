
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
 * Servlet implementation class ShoppingCart
 */
@WebServlet("/ShoppingCart")
public class ShoppingCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShoppingCart() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = response.getWriter()) {
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Servlet ShoppingCart</title>");
			out.println("</head>");
			out.println("<body><form action=Cart>");
			out.println("<h1>Product Details</h1>");
			out.println("<table border=1>");
			out.println("<tr><th>Product ID</th><th>Product Name</th><th>Unit Price</th></tr>");
			Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/tcs04", "tcs04", "tcs04");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from product");
			String pid = null;
			String pname = null;
			String price = null;
			while (rs.next()) {
				pid = rs.getString(1);
				pname = rs.getString(2);
				price = rs.getString(3);
				out.println("<tr><td>" + pid + "</td>");
				out.println("<td>" + pname + "</td>");
				out.println("<td>" + price + "</td></tr>");
			}
			out.println("</table>");
			out.println("<br><br><br>");
			out.println("<h2>Shopping cart</h2><table>");
			out.println("<tr><td>Enter the product id</td>");
			out.println("<td><input type='text' name='pid'/></td></tr>");
			out.println("<tr><td>Quantity</td>");
			out.println("<td><input type='text' name='qty'/></td></tr></table>");
			out.print("<input type='submit' name='submit' value='Submit'/>");
			out.println("<input type='submit' name='list' value='List'/>");
			out.println("</body>");
			out.println("</html>");
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (ServletException | IOException | SQLException e) {
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
		} catch (ServletException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
