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
import com.hxy.services.ProductService;
import com.hxy.services.RegisterService;

public class ProductController extends HttpServlet {
	 public void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	 if(request.getParameter("delete") != null) {
		 ProductService productservice = new ProductService();
		 int productid = Integer.parseInt(request.getParameter("deletenum"));
		 System.out.println(productid);
		 productservice.deleteproduct(productid);
		 response.sendRedirect("adminhome.jsp");
	 }else if(request.getParameter("idupdate")!=null) {
		 String productid = request.getParameter("productid");
		 request.getSession().setAttribute("productid", productid);  
		 response.sendRedirect("updateproduct.jsp");
	 }
	 else if(request.getParameter("addition") != null){
		 
           response.setContentType("text/html;charset=UTF-8");
           PrintWriter out = response.getWriter();
		   String productname = request.getParameter("productname");
		   double price = Double.parseDouble(request.getParameter("price"));
		   String description = request.getParameter("description");
		   Product product = new Product(productname, price,description);
		   
		   try { 
			   	 ProductService productservice = new ProductService();
		         boolean result = productservice.register(product);      
		         out.println("<html>");
		         out.println("<head>");      
		         out.println("<title>Add Successful</title>");    
		         out.println("</head>");
		         out.println("<body>");
		         out.println("<center>");
		         if(result){
		             out.println("<h1>Succesfully added :</h1>");
		             out.println("To go back to home page<a href=adminhome.jsp>Click here</a>");
		         }else{
		             out.println("<h1>Adding Failed</h1>");
		             out.println("To try again<a href=addproduct.jsp>Click here</a>");
		         }
		         out.println("</center>");
		         out.println("</body>");
		         out.println("</html>");
		     } finally {       
		         out.close();
		     }
		   }
	
	  else if(request.getParameter("update") != null){ 
		  response.setContentType("text/html;charset=UTF-8");
          PrintWriter out = response.getWriter();
          int productid = Integer.parseInt(request.getParameter("productid"));
		  String productname = request.getParameter("productname");
		  double price = Double.parseDouble(request.getParameter("price"));
		  String description = request.getParameter("description");
		  Product product = new Product(productname, price,description);
	      ProductService productservice = new ProductService();
		  productservice.updateproduct(productid, product);;      
		  response.sendRedirect("adminhome.jsp");
		  
		  
		  
		  
		  
	 }else {
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
}
