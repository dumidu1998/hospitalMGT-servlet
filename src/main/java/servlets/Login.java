package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.LoginDAO;
import model.User;

@WebServlet("/login")
public class Login extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Conn conn = new Conn();
		Connection dbConnection;
		dbConnection = conn.get_connection();

		LoginDAO loginDAO = new LoginDAO(dbConnection);
		PrintWriter out = resp.getWriter();

		String email = req.getParameter("email");
		String pass = req.getParameter("pass");

		User user = loginDAO.checkLogin(email, pass);

		if (user != null) {
			System.out.println(user.getUserId());

			HttpSession session = req.getSession();

			session.setAttribute("email", user.getEmail());
			session.setAttribute("role", user.getRole());
			session.setAttribute("branch_id", user.getBranchId());
			session.setAttribute("user_id", user.getUserId());

			resp.sendRedirect("home.jsp");
		} else {
			resp.sendRedirect("index.jsp?invaliddata=1");
		}
	}
}
