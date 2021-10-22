package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.LoginDAO;
import dao.MedicineDAO;
import dao.MedicineIssueDAO;
import dao.StockDAO;
import model.MedicineIssue;
import model.User;

@WebServlet("/issuemedicine")
public class IssueMedicine extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Conn conn = new Conn();
		Connection dbConnection;
		dbConnection = conn.get_connection();

		MedicineDAO medDAO = new MedicineDAO(dbConnection);
		StockDAO stockDAO =new StockDAO(dbConnection);
		
		MedicineIssueDAO medIssueDAO =new MedicineIssueDAO(dbConnection);
		MedicineIssue medicineIssue = new MedicineIssue(0, Integer.parseInt(req.getParameter("hosid")), Integer.parseInt(req.getParameter("stockid")), Integer.parseInt(req.getParameter("qty")));
		
		int ret = medIssueDAO.addData(medicineIssue);
		
		
		if (ret != 0) {
			resp.sendRedirect("payment/payment1.jsp?id="+req.getParameter("hosid"));

		} else {
			resp.sendRedirect("payment/payment1.jsp?id="+req.getParameter("hosid"));
		}
		
		
		
		
	}
}
