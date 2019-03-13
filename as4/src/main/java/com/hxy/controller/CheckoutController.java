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
import com.hxy.services.ProductService;
import com.hxy.services.RegisterService;;

public class CheckoutController extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("addition")!=null) {
			String productname = request.getParameter("Addname");
			int i = Integer.parseInt(request.getParameter("AddId"));
			int quantityold = Integer.parseInt(request.getParameter("quantity"));
			double total = (double) request.getSession().getAttribute("total");
			System.out.println("add"+i);

			System.out.println(request.getParameter("add"+i));
			int quantity = Integer.parseInt(request.getParameter("add"+i));	
			ProductService ProductService = new ProductService();
			Product product = new Product();
			product = ProductService.getProductByProductName(productname);
			double price = product.getPrice();
			request.getSession().setAttribute("quantity" + i, quantity);
			double priceproduct = price*quantity;
			total = total+priceproduct;
			request.getSession().setAttribute("total", total);
			request.getSession().setAttribute("pricetotal" + i, priceproduct);
			response.sendRedirect("checkout.jsp");
			
		}
		else if (request.getParameter("checkout") == null) {
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
			String username = request.getParameter("username");
			orderlength = Integer.parseInt(request.getParameter("length"));
			int[] quantitylastarray = new int[orderlength];
			int[] productidarray = new int[orderlength];
			CheckoutService checkoutService = new CheckoutService();
			Order order = new Order();
			int total =0;
			List<Order> list = new ArrayList<Order>();
			for (int i = 0; i < orderlength; i++) {
				quantitylastarray[i] = Integer.parseInt(request.getParameter("quantitycheck" + i));
				if(quantitylastarray[i]!=0) 
				{
					productidarray[i] = Integer.parseInt(request.getParameter("productid" + i));
					order = new Order(productidarray[i], quantitylastarray[i],username);
					list.add(order);
				}
				total = total+quantitylastarray[i];

			}
			if(total!=0) {
			checkoutService.insertOrder(list);
			response.sendRedirect("orderfinish.jsp");
			}
			else {
				response.sendRedirect("home.jsp");
			}
		}

	}
}
