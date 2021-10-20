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
import dao.MedicineDAO;
import dao.UserDAO;
import model.Branch;
import model.Medicine;
import model.User;

@WebServlet("/medicine")
public class MedicineAdd extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Conn conn= new Conn();
		Connection dbConnection;
		dbConnection=conn.get_connection();
		MedicineDAO medDAO = new MedicineDAO(dbConnection);
		medDAO.del(req.getParameter("id"));
		resp.sendRedirect("registration/medicineRegister.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Conn conn= new Conn();
		Connection dbConnection;
		dbConnection=conn.get_connection();
		
		MedicineDAO medDAO = new MedicineDAO(dbConnection);
		
		Medicine medicine = new Medicine(0, req.getParameter("bname"), req.getParameter("mname"), req.getParameter("type"), Float.parseFloat(req.getParameter("uprice")), req.getParameter("remark"));
		PrintWriter out = resp.getWriter();
		int ret = medDAO.addData(medicine);
		
		if(ret!=0) {
			resp.sendRedirect("registration/medicineRegister.jsp");
			
		}else {
			resp.sendRedirect("registration/medicineRegister.jsp");
		}
	}
	

}
