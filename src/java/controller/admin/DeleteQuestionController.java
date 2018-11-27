/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.admin;

import controller.BaseController;
import db.QuestionDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
public class DeleteQuestionController  extends BaseController{

    @Override
    public void processGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processProcess(req, resp);
    }

    @Override
    public void processPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processProcess(req, resp);
    }
    
      public void processProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
          int id= Integer.parseInt(req.getParameter("qid"));
          QuestionDAO db= new QuestionDAO();
          db.deleteQuestionByQuestionID(id);
          resp.sendRedirect("showall?coursename="+req.getParameter("courseID"));
    }
    
    
     
}
