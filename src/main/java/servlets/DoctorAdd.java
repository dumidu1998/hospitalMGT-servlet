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
import dao.PatientDAO;
import dao.UserDAO;
import model.Doctor;
import model.Patient;
import model.User;

@WebServlet("/patient")
public class DoctorAdd extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Conn conn= new Conn();
		Connection dbConnection;
		dbConnection=conn.get_connection();
		PatientDAO patientDAO = new PatientDAO(dbConnection);
		patientDAO.del(req.getParameter("id"));
		resp.sendRedirect("registration/patientRegister.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Conn conn= new Conn();
		Connection dbConnection;
		dbConnection=conn.get_connection();
		
		PatientDAO patientDAO = new PatientDAO(dbConnection);

		Patient newPatient = null;//new Patient(0, getServletName(), null, getServletInfo(), getServletInfo(), 0, getServletInfo(), getServletName(), getServletInfo())
		int ret = patientDAO.addData(newPatient);
		if(ret!=0) {
			resp.sendRedirect("registration/patientRegister.jsp");
			
		}else {
			resp.sendRedirect("registration/patientRegister.jsp");
		}
		
	}
	

}
