package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DoctorDAO;
import dao.LoginDAO;
import dao.UserDAO;
import model.Doctor;
import model.User;

@WebServlet("/doctor")
public class PatientAdd extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Conn conn= new Conn();
		Connection dbConnection;
		dbConnection=conn.get_connection();
		DoctorDAO doctorDAO = new DoctorDAO(dbConnection);
		doctorDAO.del(req.getParameter("id"));
		resp.sendRedirect("registration/doctorRegister.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Conn conn= new Conn();
		Connection dbConnection;
		dbConnection=conn.get_connection();
		
		DoctorDAO doctorDAO = new DoctorDAO(dbConnection);

		Doctor newDoctor = new Doctor(0,Integer.parseInt(req.getParameter("branch")) , req.getParameter("name"), req.getParameter("specialization"), req.getParameter("gender"), req.getParameter("nic"), req.getParameter("eq"), req.getParameter("pq"), req.getParameter("address"), req.getParameter("contact"), req.getParameter("email"));
		PrintWriter out = resp.getWriter();
		int ret = doctorDAO.addData(newDoctor);
		if(ret!=0) {
			resp.sendRedirect("registration/doctorRegister.jsp");
			
		}else {
			resp.sendRedirect("registration/doctorRegister.jsp");
		}
		
	}
	

}
