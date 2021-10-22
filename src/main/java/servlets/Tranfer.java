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

import dao.BranchTransferDAO;
import dao.DoctorDAO;
import dao.LoginDAO;
import dao.PatientDAO;
import dao.PatientHospitalizationDAO;
import dao.UserDAO;
import model.BranchTransfer;
import model.Doctor;
import model.Patient;
import model.PatientHospitalization;
import model.User;

@WebServlet("/transfer")
public class Tranfer extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Conn conn = new Conn();
		Connection dbConnection;
		dbConnection = conn.get_connection();
		BranchTransferDAO transferDAO = new BranchTransferDAO(dbConnection);
		transferDAO.del(req.getParameter("id"));
		resp.sendRedirect("patientTransfer.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Conn conn = new Conn();
		Connection dbConnection;
		dbConnection = conn.get_connection();

		PatientHospitalizationDAO hospitalizationDAO = new PatientHospitalizationDAO(dbConnection);
		BranchTransferDAO transferDAO = new BranchTransferDAO(dbConnection);
		
		BranchTransfer branchtransfer = new BranchTransfer(0, Integer.parseInt(req.getParameter("patient")), req.getParameter("reason"), null, Integer.parseInt(req.getParameter("branch")), Integer.parseInt(req.getParameter("sbranch")), Integer.parseInt(req.getParameter("doctor")), null);
		
		int ret = transferDAO.addData(branchtransfer);
		hospitalizationDAO.updateBranch(Integer.parseInt(req.getParameter("patient")),Integer.parseInt(req.getParameter("branch")), Integer.parseInt(req.getParameter("doctor")));
		
		if (ret != 0) {
			resp.sendRedirect("patientTransfer.jsp");

		} else {
			resp.sendRedirect("patientTransfer.jsp");
		}

	}

}
