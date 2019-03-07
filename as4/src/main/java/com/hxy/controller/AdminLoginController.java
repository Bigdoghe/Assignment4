package com.hxy.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import com.hxy.model.AdminUser;
import com.hxy.services.AdminLoginService;
 
 
public class AdminLoginController extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
     String username = request.getParameter("username");   
     String password = request.getParameter("password");
     AdminLoginService loginService = new AdminLoginService();
     boolean result = loginService.authenticateUser(username, password);
     AdminUser user = loginService.getUserByUserName(username);
     if(result == true){
         request.getSession().setAttribute("user", user);      
         response.sendRedirect("adminhome.jsp");
     }
     else{
         response.sendRedirect("error.jsp");
     }
}
 
}