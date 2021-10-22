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
import dao.StockDAO;
import dao.UserDAO;
import model.Branch;
import model.Medicine;
import model.Stock;
import model.User;

@WebServlet("/stock")
public class StockAdd extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Conn conn = new Conn();
		Connection dbConnection;
		dbConnection = conn.get_connection();
		StockDAO stockDAO = new StockDAO(dbConnection);
		stockDAO.del(req.getParameter("id"));
		resp.sendRedirect("stockmgmt.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Conn conn = new Conn();
		Connection dbConnection;
		dbConnection = conn.get_connection();

		StockDAO stockDAO = new StockDAO(dbConnection);
		Stock stock = new Stock(0, Integer.parseInt(req.getParameter("medicine")),
				Integer.parseInt(req.getParameter("qty")), Float.parseFloat(req.getParameter("uprice")),
				Float.parseFloat(req.getParameter("total")), Integer.parseInt(req.getParameter("branch")));
		int ret = stockDAO.addData(stock);

		if (ret != 0) {
			resp.sendRedirect("stockmgmt.jsp");

		} else {
			resp.sendRedirect("stockmgmt.jsp");
		}
	}

}
