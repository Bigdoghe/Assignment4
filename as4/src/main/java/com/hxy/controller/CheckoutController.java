package com.hxy.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hxy.model.Order;
import com.hxy.model.Product;
import com.hxy.model.User;
import com.hxy.services.CheckoutService;
import com.hxy.services.RegisterService;;

public class CheckoutController extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("checkout") == null) {
			int i = Integer.parseInt(request.getParameter("RemoveId"));
			double curmoney = Double.parseDouble(request.getParameter("Removepricetotal"));
			double tomoney = Double.parseDouble(request.getParameter("totalmoney"));
			tomoney = tomoney - curmoney;
			request.getSession().setAttribute("quantity" + i, 0);

			request.getSession().setAttribute("total", tomoney);
			request.getSession().setAttribute("pricetotal" + i, 0);
			response.sendRedirect("checkout.jsp");
		} 
		else {
			int orderlength = 0;
			orderlength = Integer.parseInt(request.getParameter("length"));
			int[] quantitylastarray = new int[orderlength];
			int[] productidarray = new int[orderlength];
			CheckoutService checkoutService = new CheckoutService();
			Order order = new Order();
			List<Order> list = new ArrayList<Order>();
			for (int i = 0; i < orderlength; i++) {
				quantitylastarray[i] = Integer.parseInt(request.getParameter("quantitycheck" + i));
				productidarray[i] = Integer.parseInt(request.getParameter("productid" + i));
				order = new Order(productidarray[i], quantitylastarray[i]);
				list.add(order);

			}
			checkoutService.insertOrder(list);
			response.sendRedirect("orderfinish.jsp");
		}

	}
}
