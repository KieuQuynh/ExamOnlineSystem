/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.*;
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
public class EditProfileController extends BaseController {

  

    @Override
    public void processGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
    }

    @Override
    public void processPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("fname");
        String lastName = req.getParameter("lname");
        String userName = req.getParameter("uname");
        String email = req.getParameter("email");
        String password = req.getParameter("pass");
        String contact = req.getParameter("contactno");
        String city = req.getParameter("city");
        String address = req.getParameter("address");
        System.out.println(req.getParameter("userID"));
        int id= Integer.parseInt(req.getParameter("userID"));
       
       UserDAO db = new UserDAO();
       UserModel ob= db.getById(id);
       db.update(id, firstName, lastName, userName, email, password, contact, city, address);
       if(ob.getType().equals("admin"))
       resp.sendRedirect("admin/adminPage.jsp?userID="+id);
       else     resp.sendRedirect("student/studentPage.jsp?userID="+id);
    }

}
