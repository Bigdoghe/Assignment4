package com.hxy.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hxy.model.Product;
import com.hxy.model.User;
import com.hxy.services.CheckoutService;
import com.hxy.services.RegisterService;
;

public class CheckoutController extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
	 int orderlength=0;
	 orderlength = Integer.parseInt(request.getParameter("length"));
	 int[] quantitylastarray = new int[orderlength];  
	 int[] productidarray = new int[orderlength];
	 CheckoutService checkoutService = new CheckoutService();
	 for (int i =0;i<orderlength;i++) {
		 quantitylastarray[i] = Integer.parseInt(request.getParameter("Quantity"+i));
		 productidarray[i] = Integer.parseInt(request.getParameter("productid"+i));
		 checkoutService.insertOrder(productidarray[i],quantitylastarray[i]);	 
	 }
     response.sendRedirect("error.jsp");
  
}
}
	 
