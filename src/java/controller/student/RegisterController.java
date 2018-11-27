/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.student;

import controller.BaseController;
import db.UserDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.UserModel;

/**
 *
 * @author Admin
 */
public class RegisterController  extends BaseController{

    @Override
    public void processGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       req.getRequestDispatcher("register.jsp").forward(req, resp);
    }

    @Override
    public void processPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String fname= req.getParameter("fname");
       String lname= req.getParameter("lname");
       String uname = req.getParameter("uname");
       String email   = req.getParameter("email");
       String pass  = req.getParameter("pass");
       String contactno = req.getParameter("contactno");
       String city = req.getParameter("city");
       String address= req.getParameter("address");
       UserModel ob= new UserModel();
       ob.setFirstName(fname);
       ob.setLastName(lname);
       ob.setUserName(uname);
       ob.setEmail(email);
       ob.setPassword(pass);
       ob.setContact(contactno);
       ob.setCity(city);
       ob.setAddress(address);
       UserDAO db= new UserDAO();
       db.insertUser(ob);
       resp.sendRedirect("../login");
    }
    
}
