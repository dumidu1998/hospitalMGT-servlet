package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DoctorDAO;
import dao.PatientDAO;
import dao.UserDAO;
import model.Doctor;
import model.Patient;
import model.User;


@WebServlet("/editpatient")
public class PatientUpdate extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Conn conn= new Conn();
		Connection dbConnection;
		dbConnection=conn.get_connection();
		
		PatientDAO patientDAO = new PatientDAO(dbConnection);
		Patient newPatient = new Patient(Integer.parseInt(req.getParameter("userid")), req.getParameter("name"), Date.valueOf(req.getParameter("dob")), req.getParameter("gender"), req.getParameter("nic"),Integer.parseInt(req.getParameter("age")), req.getParameter("address"), req.getParameter("contact"), req.getParameter("email"));
		int ret = patientDAO.updateUser(newPatient);
		if(ret!=0) {
			resp.sendRedirect("registration/patientRegister.jsp");
			
		}else {
			resp.sendRedirect("registration/patientRegister.jsp");
		}
	}
	
	

}
