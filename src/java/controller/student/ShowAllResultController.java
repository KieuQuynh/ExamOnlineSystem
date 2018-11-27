/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.student;

import controller.BaseController;
import db.ExamDAO;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.AnswerModel;
import model.ExamModel;

/**
 *
 * @author Admin
 */
public class ShowAllResultController  extends BaseController{
  

    @Override
    public void processGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    public void processPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }
    
      public void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
          ExamDAO db= new ExamDAO();
            int userID= Integer.parseInt(req.getSession().getAttribute("userID").toString());
          ArrayList<ExamModel> list =db.getAllResultsFromExams(userID);
         String eid =req.getParameter("eid");
         int examID;
         if(eid !=null) {
               examID= Integer.parseInt(eid);
               ArrayList<AnswerModel> ans= db.getAllAnswersByExamId(examID);
               
               req.setAttribute("answer", ans);
         }
        
          req.setAttribute("exam", list);
          req.getRequestDispatcher("showAll.jsp").forward(req, resp);
  
    }
    
}
