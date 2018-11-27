/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.admin;

import controller.*;
import db.AccountDAO;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.UserModel;

/**
 *
 * @author Admin
 */
public class AccountsController  extends BaseController{

    @Override
    public void processGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    public void processPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }
    
      public void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
          AccountDAO db= new AccountDAO();
          ArrayList<UserModel> list= db.getAllStudent();
          System.out.println("size:"+list.size());
          req.setAttribute("student", list);
          req.getRequestDispatcher("accounts.jsp").forward(req, resp);
    }
    
}
