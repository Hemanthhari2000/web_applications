
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class cart
 */
@WebServlet("/cart")
public class cart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public cart() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @throws IOException
	 * @throws SQLException
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws IOException, SQLException {
		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = response.getWriter()) {
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Servlet Cart</title>");
			out.println("</head>");
			out.println("<body>");
			String pid = request.getParameter("pid");
			String qty = request.getParameter("qty");
			String submit = request.getParameter("submit");
			String list = request.getParameter("list");
			if (submit != null) {
				Cookie ck1 = new Cookie(pid, qty);
				response.addCookie(ck1);
				response.sendRedirect("ShoppingCart");
			}
			if (list != null) {
				Cookie ck1[] = request.getCookies();
				out.print("<h1>Your Cart Details</h1>");
				Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/tcs04", "tcs04", "tcs04");
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery("select * from product");
				String[][] product = new String[10][3];
				int i = 0;
				int j = 0;
				while (rs.next()) {
					product[i][j++] = rs.getString(1);
					product[i][j++] = rs.getString(2);
					product[i][j] = rs.getString(3);
					i++;
					j = 0;
				}
				String price = null;
				String name = null;
				int amount = 0;
				out.println("<table border=1>");
				out.println(
						"<tr><th>S.No</th><th>Product ID</th><th>Product Name</th><th>Unit Price</th><th>Quantity</th><th>Amount</th><tr>");
				for (i = 1; i < ck1.length; i++) {
					String pname = ck1[i].getName();
					String qtys = ck1[i].getValue();
					for (int k = 0; k < 4; k++) {
						String s1 = product[k][0];
						if (s1.equals(pname)) {
							price = product[k][2];
							name = product[k][1];
							int q = Integer.parseInt(qtys);
							int p = Integer.parseInt(price);
							amount = amount + q * p;
							out.print("<tr><td>" + i + "</td><td>" + pname + "</td><td>" + name + "</td><td>" + price
									+ "</td> <td>" + q + "</td><td>" + q * p + "</td></tr>");
							break;
						}
					}
				}
				out.println("</table>");
				out.println("<h2>Total Amount:" + amount + "</h2>");
			}
			out.println("</body>");
			out.println("</html>");
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (IOException | SQLException e) {
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
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
