/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.student;

import controller.BaseController;
import db.CourseDAO;
import db.ExamDAO;
import db.QuestionDAO;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Course;
import model.QuestionModel;

/**
 *
 * @author Admin
 */
public class TakeExamController extends BaseController  {

    @Override
    public void processGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            
            CourseDAO db = new CourseDAO();
            ArrayList<Course> list = db.allCourse();
           ExamDAO edb = new ExamDAO();
           
           req.setAttribute("course", list);
           req.getRequestDispatcher("examCourse.jsp").forward(req, resp);

       
    }

    @Override
    public void processPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         int courseID= Integer.parseInt(req.getParameter("coursename"));
         //userID
         int userID= Integer.parseInt(req.getSession().getAttribute("userID").toString());
        QuestionDAO db= new QuestionDAO();
        ArrayList<QuestionModel>  list= db.getAllQuestion(courseID);
        
        ExamDAO edb = new ExamDAO();
       int examId= edb.startExam(userID, courseID);
        
        int remainTime = edb.getRemainingTime(examId);
        req.setAttribute("question", list);
        req.setAttribute("examID", examId);
        req.setAttribute("remain", remainTime);
        req.setAttribute("courseID", courseID);
        req.getRequestDispatcher("exam.jsp").forward(req, resp);
    }
    
}
