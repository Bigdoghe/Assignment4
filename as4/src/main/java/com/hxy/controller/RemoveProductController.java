package com.hxy.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hxy.model.Product;
import com.hxy.services.ProductService;

public class RemoveProductController extends HttpServlet {
	 public void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	 
		 int i =  Integer.parseInt(request.getParameter("RemoveId"));
		 double curmoney = Double.parseDouble(request.getParameter("Removepricetotal"));
		 double tomoney = Double.parseDouble(request.getParameter("totalmoney"));
		 tomoney = tomoney-curmoney;
		 request.getSession().setAttribute("quantity"+i, 0);
	

		 request.getSession().setAttribute("total", tomoney);
		 request.getSession().setAttribute("pricetotal"+i, 0);
	     response.sendRedirect("checkout.jsp");
	  
	}
}
