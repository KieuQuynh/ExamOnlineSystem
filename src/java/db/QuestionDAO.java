/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.QuestionModel;

/**
 *
 * @author Admin
 */
public class QuestionDAO extends BaseDAO {

    public void addQuestion(int courseID, String question, String opt1, String opt2, String opt3, String opt4, String correct) {
        try {
            String sql = "           \n"
                    + "      INSERT INTO dbo.questions\n"
                    + "       (    question ,  opt1 ,  opt2 ,  opt3 , opt4 ,  correct, courseID  )\n"
                    + "      VALUES  (  ? ,  ? ,  ? ,  ? ,  ? ,  ?   ,? )   ";

            PreparedStatement pstmt = conn.prepareStatement(sql);
          
            pstmt.setString(1, question);
            pstmt.setString(2, opt1);
            pstmt.setString(3, opt2);
            pstmt.setString(4, opt3);
            pstmt.setString(5, opt4);
            pstmt.setString(6, correct);
            pstmt.setInt(7, courseID);
            
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<QuestionModel> getAllQuestion(int id) {
        try {
            ArrayList<QuestionModel> list= new ArrayList<>();
            String sql = "SELECT * FROM dbo.questions\n"
                    + "WHERE  courseID=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                QuestionModel ob = new QuestionModel();
                ob.setId(rs.getInt("question_id"));
                ob.setCourseID(rs.getInt("courseID"));
                ob.setQuestion(rs.getString("question"));
                ob.setOpt1(rs.getString("opt1"));
                ob.setOpt2(rs.getString("opt2"));
                ob.setOpt3(rs.getString("opt3"));
                ob.setOpt4(rs.getString("opt4"));
                ob.setCorrect(rs.getString("correct"));
                list.add(ob);
            }
            
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
     public ArrayList pagging(int pageSize, int pageIndex, int id) {
        try {
            ArrayList<QuestionModel> list= new ArrayList<>();
            System.out.println("before");
            String sql = "select * FROM ( select ROW_NUMBER() over (order by question_id ASC) as rn,*\n" +
"                FROM ( SELECT * FROM  dbo.questions  WHERE courseID =? ) AS m ) AS x\n" +
"                where  rn  BETWEEN (? * (?-1) + 1)   and  (? * ?)    ";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            System.out.println("haha");
            pstmt.setInt(1, id);
            pstmt.setInt(2, pageSize);
            pstmt.setInt(3, pageIndex);
            pstmt.setInt(4, pageSize);
            pstmt.setInt(5, pageIndex); 
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                QuestionModel ob = new QuestionModel();
                ob.setId(rs.getInt("question_id"));
                ob.setCourseID(rs.getInt("courseID"));
                ob.setQuestion(rs.getString("question"));
                ob.setOpt1(rs.getString("opt1"));
                ob.setOpt2(rs.getString("opt2"));
                ob.setOpt3(rs.getString("opt3"));
                ob.setOpt4(rs.getString("opt4"));
                ob.setCorrect(rs.getString("correct"));
                list.add(ob);            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

      public int RowCount(int id){
        try {
            String sql="SELECT COUNT(*) as Total FROM dbo.questions where courseID=? ";
            PreparedStatement pstmt= conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs= pstmt.executeQuery();
            if(rs.next()){
                int totalRow= rs.getInt("Total");
                return totalRow;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
        
    }
      
      public void deleteQuestionbyCourseID(int id){
            try {
          
            String sql="DELETE dbo.questions WHERE courseID= ? ";
            
            PreparedStatement pstmt= conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CourseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
      }
      
      public void deleteQuestionByQuestionID(int id){
             try {
          
            String sql="DELETE dbo.questions WHERE question_id =? ";
            
            PreparedStatement pstmt= conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CourseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
}
