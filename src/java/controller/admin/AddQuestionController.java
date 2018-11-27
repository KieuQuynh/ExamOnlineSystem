/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.admin;

import controller.*;
import db.QuestionDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
public class AddQuestionController  extends BaseController{

    @Override
    public void processGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      
    }

    @Override
    public void processPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req.getParameter("courseID"));
          int courseID= Integer.parseInt(req.getParameter("courseID"));
          String question =req.getParameter("question");
          String  option1=req.getParameter("opt1");
          String option2= req.getParameter("opt2");
          String option3=req.getParameter("opt3");
          String option4= req.getParameter("opt4");
          String ans = req.getParameter("correct");
          
          QuestionDAO db= new QuestionDAO();
          db.addQuestion(courseID,question, option1, option2, option3, option4, ans);
          resp.sendRedirect("adminPage.jsp?pgprt=3");
    }
     
      public void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       
          
    }
    
    
}
