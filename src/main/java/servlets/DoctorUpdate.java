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
import dao.UserDAO;
import model.Doctor;
import model.User;


@WebServlet("/editdoctor")
public class DoctorUpdate extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Conn conn= new Conn();
		Connection dbConnection;
		dbConnection=conn.get_connection();
		
		DoctorDAO doctorDAO = new DoctorDAO(dbConnection);
		
		Doctor newDoctor = new Doctor(Integer.parseInt(req.getParameter("userid")), Integer.parseInt(req.getParameter("branch")),req.getParameter("name"),req.getParameter("specialization"),req.getParameter("gender"),req.getParameter("nic"),req.getParameter("eq"),req.getParameter("pq"),req.getParameter("address"),req.getParameter("contact"),req.getParameter("email") );
		int ret = doctorDAO.updateUser(newDoctor);
		if(ret!=0) {
			resp.sendRedirect("registration/doctorRegister.jsp");
			
		}else {
			resp.sendRedirect("registration/doctorRegister.jsp");
		}
	}
	
	

}
