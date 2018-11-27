/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.admin;

import controller.*;
import db.CourseDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
public class AddCourseController extends BaseController {

    @Override
    public void processGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      
    }

    @Override
    public void processPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String name= req.getParameter("coursename");
            int mark= Integer.parseInt(req.getParameter("totalmarks"));
            String time= req.getParameter("time");
            CourseDAO db= new CourseDAO();
            int result= db.insertCourse(name, mark, time);
             resp.sendRedirect("adminPage.jsp?pgprt=2&result="+result);
    }
    
}
