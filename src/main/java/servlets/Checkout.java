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

import dao.BillPaymentDAO;
import dao.LoginDAO;
import model.BillPayment;
import model.User;

@WebServlet("/checkout")
public class Checkout extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Conn conn = new Conn();
		Connection dbConnection;
		dbConnection = conn.get_connection();
		BillPaymentDAO billDAO = new BillPaymentDAO(dbConnection);
		
		billDAO.addData(new BillPayment(0, Integer.parseInt(req.getParameter("hosid")),Float.parseFloat(req.getParameter("docfee")), Float.parseFloat(req.getParameter("hosfee")), Float.parseFloat(req.getParameter("totalmed")), Float.parseFloat(req.getParameter("gtotal")), req.getParameter("remark")));

		resp.sendRedirect("home.jsp");
	}
}
