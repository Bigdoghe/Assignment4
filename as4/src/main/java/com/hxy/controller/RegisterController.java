package com.hxy.controller;


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import com.hxy.model.User;
import com.hxy.services.RegisterService;
 
 
public class RegisterController extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     response.setContentType("text/html;charset=UTF-8");
     PrintWriter out = response.getWriter();
     String username = request.getParameter("username");
     String password = request.getParameter("password");
     User user = new User(username, password);
             
     try { 
         RegisterService registerService = new RegisterService();
         boolean result = registerService.register(user);      
         out.println("<html>");
         out.println("<head>");      
         out.println("<title>Registration Successful</title>");    
         out.println("</head>");
         out.println("<body>");
         out.println("<center>");
         if(result){
             out.println("<h1>Thanks for Registering with us :</h1>");
             out.println("To login with new UserId and Password<a href=login.jsp>Click here</a> Redirect to login page in 5 seconds"  );
             request.getSession().removeAttribute("username");
             request.getSession().removeAttribute("password");
             request.getSession().invalidate(); 
             response.setHeader("Refresh", "5;url=login.jsp"); 
             
         }else{
             out.println("<h1>Registration Failed</h1>");
             out.println("To try again<a href=register.jsp>Click here</a>");
         }
         out.println("</center>");
         out.println("</body>");
         out.println("</html>");
     } finally {       
         out.close();
     }
}
 
}