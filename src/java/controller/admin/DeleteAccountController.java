/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.admin;

import controller.BaseController;
import db.UserDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
public class DeleteAccountController  extends BaseController{

    @Override
    public void processGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    public void processPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }
    
    public void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDAO db = new UserDAO();
        int id= Integer.parseInt(req.getParameter("id"));
        db.deteleAccount(id);
        req.getRequestDispatcher("account?pgprt=1").forward(req, resp);
        
    }
    
}
