package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import model.User;


@WebServlet("/edituser")
public class UserUpdate extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Conn conn= new Conn();
		Connection dbConnection;
		dbConnection=conn.get_connection();
		
		UserDAO userDAO = new UserDAO(dbConnection);
		
		User newUser = new User(Integer.parseInt(req.getParameter("userid")),Integer.parseInt(req.getParameter("role")),req.getParameter("email"),req.getParameter("email"),req.getParameter("password"),Integer.parseInt(req.getParameter("branch")));
		PrintWriter out = resp.getWriter();
		out.print("ddddd");
		int ret = userDAO.updateUser(newUser);
		if(ret!=0) {
			resp.sendRedirect("registration/userRegister.jsp");
			
		}else {
			resp.sendRedirect("registration/userRegister.jsp");
		}
	}
	
	

}
