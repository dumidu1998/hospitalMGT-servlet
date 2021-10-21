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
import dao.LoginDAO;
import dao.PatientDAO;
import dao.PatientHospitalizationDAO;
import dao.UserDAO;
import model.Doctor;
import model.Patient;
import model.PatientHospitalization;
import model.User;

@WebServlet("/hospitalize")
public class Hospitalization extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Conn conn = new Conn();
		Connection dbConnection;
		dbConnection = conn.get_connection();
		PatientHospitalizationDAO hospitalizationDAO = new PatientHospitalizationDAO(dbConnection);
		hospitalizationDAO.del(req.getParameter("id"));
		resp.sendRedirect("hospitalization.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Conn conn = new Conn();
		Connection dbConnection;
		dbConnection = conn.get_connection();

		PatientHospitalizationDAO hospitalizationDAO = new PatientHospitalizationDAO(dbConnection);
		
		PatientHospitalization hospitalization = new PatientHospitalization(0, Integer.parseInt(req.getParameter("patient")), req.getParameter("reason"), Integer.parseInt(req.getParameter("doctor")), null, null, Integer.parseInt(req.getParameter("ward")), 0, req.getParameter("remarks"), Integer.parseInt(req.getParameter("branch")));

		int ret = hospitalizationDAO.addData(hospitalization);
		
		if (ret != 0) {
			resp.sendRedirect("hospitalization.jsp");

		} else {
			resp.sendRedirect("hospitalization.jsp");
		}

	}

}
