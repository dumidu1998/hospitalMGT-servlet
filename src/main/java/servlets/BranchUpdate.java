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

@WebServlet("/editbranch")
public class BranchUpdate extends HttpServlet {


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Conn conn= new Conn();
		Connection dbConnection;
		dbConnection=conn.get_connection();
		
		BranchDAO branchDAO = new BranchDAO(dbConnection);
		
		Branch newBranch = new Branch(Integer.parseInt(req.getParameter("bid")),req.getParameter("bname"));
		PrintWriter out = resp.getWriter();
		int ret = branchDAO.updateUser(newBranch);
		if(ret!=0) {
			resp.sendRedirect("registration/branchRegister.jsp");
			
		}else {
			resp.sendRedirect("registration/branchRegister.jsp");
		}

	}

}
