/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import db.UserDAO;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.UserModel;

/**
 *
 * @author Admin
 */
public class LoginController  extends HttpServlet{

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

            req.getRequestDispatcher("login.jsp").forward(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      
         UserDAO db= new UserDAO();
         ArrayList<UserModel> list=db.allUser();
         String username= req.getParameter("username");
         String pass= req.getParameter("password");
        int mark=0;
         for(UserModel e: list){
             if(e.getUserName().equals(username) && e.getPassword().equals(pass)){
                 mark=1;
                 req.getSession().setAttribute("userID", e.getId());
                 req.getSession().setAttribute("username", e.getFirstName() +" " + e.getLastName());
                
                 if(e.getType().equals("admin")) resp.sendRedirect("./admin/adminPage.jsp?userID="+e.getId());
                 else resp.sendRedirect("./student/studentPage.jsp?userID="+e.getId());
             } 
         }
         if(mark==0) {
             req.setAttribute("error", "Username or Password Wrong!!");
             req.getRequestDispatcher("login.jsp").forward(req, resp);
         }

        }
     
    
    
}
