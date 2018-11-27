/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.admin;

import controller.*;
import db.QuestionDAO;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.QuestionModel;

/**
 *
 * @author Admin
 */
public class ListQuestionController extends BaseController {

    @Override
    public void processGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        //load dữ liệu  
          int id= Integer.parseInt(req.getParameter("coursename"));
        QuestionDAO db= new QuestionDAO();
//        ArrayList<QuestionModel> list= db.getAllQuestion(id);
//        
//        req.setAttribute("question", list);
//        req.getRequestDispatcher("showQuestion.jsp").forward(req, resp);

String page_raw =req.getParameter("page");
          page_raw = ( page_raw== null) ? "1": page_raw;
          int pageIndex = Integer.parseInt(page_raw);
      //    DummyDAO db = new DummyDAO();
          int pageSize=2;
          ArrayList<QuestionModel> list= db.pagging(pageSize,pageIndex,id);
          System.out.println("size:"+list.size());
          int rowCount= db.RowCount(id);
          System.out.println("rowCount: "+rowCount);
          int maxPage= rowCount/pageSize + ((rowCount%pageSize==0)? 0 : 1);
          System.out.println("max:"+maxPage);
          System.out.println("index:"+pageIndex);
          req.setAttribute("maxPage", maxPage);
          req.setAttribute("pageIndex", pageIndex);
          req.setAttribute("question", list);
          req.setAttribute("courseID", id);
        req.getRequestDispatcher("showQuestion.jsp").forward(req, resp);
        
    
    }

    @Override
    public void processPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
  
    }
    
}
