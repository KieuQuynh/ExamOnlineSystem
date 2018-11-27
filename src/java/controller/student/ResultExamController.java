/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.student;

import controller.BaseController;
import db.CourseDAO;
import db.ExamDAO;
import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Course;
import model.ExamModel;

/**
 *
 * @author Admin
 */
public class ResultExamController extends BaseController{

    @Override
    public void processGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
              resp.sendRedirect("startExam");

             
             
         
    }

    @Override
    public void processPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
             int size = Integer.parseInt(req.getParameter("size"));
             int courseID = Integer.parseInt(req.getParameter("courseID"));
             int examID = Integer.parseInt(req.getParameter("examID"));
            
             ExamDAO db = new ExamDAO();
             
             int tMark = db.getTotalMarksByID(courseID);
             //get time
             String time= LocalTime.now().toString();
             for( int i=0;i < size ;i++){
                   String question= req.getParameter("question"+i);
                   String ans = req.getParameter("ans"+i);
                   int questionID = Integer.parseInt(req.getParameter("qid"+i));
                    db.insertAnswer(examID, questionID, question, ans);
             }
             
             db.calculateResult(examID, tMark, time, size);
             ExamModel  ob = db.getResultByExamId(examID);
             
             CourseDAO cdb= new CourseDAO();
             Course course= cdb.getCourseById(ob.getCourseID());
             
             req.setAttribute("course", course);
             req.setAttribute("result", ob);
             req.getRequestDispatcher("resultOfAnExam.jsp").forward(req, resp);
             
    }
    
    
    
}
