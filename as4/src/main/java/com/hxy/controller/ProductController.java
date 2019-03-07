package com.hxy.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hxy.model.Product;
import com.hxy.services.ProductService;

public class ProductController extends HttpServlet {
	 public void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	 
		 int productlength=0;
		 ProductService productservice = new ProductService();
		 productlength = productservice.getProductNumber();
		 int[] quantityarray = new int[productlength];  
		 int[] checkarray = new int[productlength];
		 double[] totalarray = new double[productlength];
		 double totalmoney = 0;
		 List<Product> list = productservice.getListOfProducts();
		 int i = 0;
		 for (Product p : list) {
			 quantityarray[i] =  Integer.parseInt(request.getParameter("quantity"+i));
			
			 if(request.getParameter("checkbox"+i)!=null) {
				  checkarray[i] = 1;
			 }
			 else {
				 checkarray[i] = 0;
			 }
			 quantityarray[i] = quantityarray[i]*checkarray[i];
			 request.getSession().setAttribute("quantity"+i, quantityarray[i]);		 
			 request.getSession().setAttribute("checkbox"+i, checkarray[i]);
			 totalarray[i]= 0+checkarray[i]*quantityarray[i]* p.getPrice();
			 request.getSession().setAttribute("pricetotal"+i, totalarray[i]);
			 totalmoney = totalmoney + totalarray[i];
			 i++;
		 }
		 request.getSession().setAttribute("total", totalmoney);
	     response.sendRedirect("checkout.jsp");
	  
	}
}
