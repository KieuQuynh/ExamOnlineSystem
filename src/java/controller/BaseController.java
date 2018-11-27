/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author Admin
 */
public abstract class BaseController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
           if(checkAuthentication(req,resp) && !req.getRequestURI().endsWith("login"))
               processGet(req, resp);
         else {
               System.out.println("haha");
              resp.sendRedirect("../login");
             }
        
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            if(checkAuthentication(req,resp))
                    processPost(req, resp);
       else {
                System.out.println("hahah");
            resp.sendRedirect("../login");
        }
   
    }
    
     public boolean checkAuthentication(HttpServletRequest req,HttpServletResponse resp){
      
        if(req.getSession() !=null && req.getSession().getAttribute("userID")!=null ) return true;
        else return false;
   
    }
    
    public abstract void processGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException ;
    public abstract void processPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException ;
    
}
