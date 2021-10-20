package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BranchDAO;
import dao.UserDAO;
import model.Branch;
import model.User;

@WebServlet("/branch")
public class BranchAdd extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Conn conn= new Conn();
		Connection dbConnection;
		dbConnection=conn.get_connection();
		BranchDAO branchDAO = new BranchDAO(dbConnection);
		branchDAO.del(req.getParameter("id"));
		resp.sendRedirect("registration/branchRegister.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Conn conn= new Conn();
		Connection dbConnection;
		dbConnection=conn.get_connection();
		
		BranchDAO branchDAO = new BranchDAO(dbConnection);
		
		Branch newBranch = new Branch(0,req.getParameter("bname"));
		PrintWriter out = resp.getWriter();
		int ret = branchDAO.addData(newBranch);
		
		if(ret!=0) {
			resp.sendRedirect("registration/branchRegister.jsp");
			
		}else {
			resp.sendRedirect("registration/branchRegister.jsp");
		}
	}
	

}
