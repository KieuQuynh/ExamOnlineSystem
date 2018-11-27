/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.AnswerModel;
import model.ExamModel;

/**
 *
 * @author Admin
 */
public class ExamDAO extends BaseDAO {

    public int startExam(int userID, int courseID) {
        int examID = 0;
        try {
            String sql = "INSERT INTO dbo.exams\n"
                    + "        (  std_id , course_id , total_marks , \n"
                    + "          date , start_time ,  exam_time )\n"
                    + "VALUES  ( ? ,? , ? , ?,  ? , ?  )";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, userID);
            pstmt.setInt(2, courseID);
            pstmt.setInt(3, getTotalMarksByID(courseID));
            pstmt.setDate(4, (Date.valueOf(LocalDate.now())));
            pstmt.setString(5, LocalTime.now().toString());
            pstmt.setString(6, getCourseTimeByID(courseID));

            pstmt.executeUpdate();
            examID = getLastExam();
        } catch (SQLException ex) {
            Logger.getLogger(ExamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return examID;

    }

    private String getFormatedDate(String date) {
        LocalDate localDate = LocalDate.parse(date);
        return localDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }

    public int getLastExam() {
        int id = 0;
        try {
            String sql = " SELECT * FROM dbo.exams";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                id = rs.getInt("exam_id");
            }

        } catch (SQLException ex) {
            Logger.getLogger(ExamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }

    public int getTotalMarksByID(int courseID) {
        int marks = 0;
        try {
            PreparedStatement pstm = conn.prepareStatement("Select total_marks from courses where id=?");
            pstm.setInt(1, courseID);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                marks = rs.getInt("total_marks");

            }
            pstm.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return marks;
    }

    public String getCourseTimeByID(int courseID) {
        String c = null;
        try {
            PreparedStatement pstm = conn.prepareStatement("Select time from courses where id=?");
            pstm.setInt(1, courseID);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                c = rs.getString("time");
            }
            pstm.close();
        } catch (Exception ex) {
            Logger.getLogger(ExamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return c;
    }

    public int getRemainingTime(int examId) {
        int time = 0;
        try {

            String sql = "Select start_time,exam_time from exams where exam_id=?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, examId);
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                //totalTime-(Math.abs(currentTime-examStartTime))
                //Duration.between(first,sec) returns difference between 2 dates or 2 times
                time = Integer.parseInt(rs.getString(2)) - (int) Math.abs((Duration.between(LocalTime.now(), LocalTime.parse(rs.getString(1))).getSeconds() / 60));
            }
            pstm.close();
        } catch (SQLException ex) {
            Logger.getLogger(ExamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(time);
        return time;
    }

    public void insertAnswer(int eId, int qid, String question, String ans) {
        try {
            PreparedStatement pstm = conn.prepareStatement("insert into answers(exam_id,question,answer,correct_answer,status) "
                    + "Values(?,?,?,?,?)");
            pstm.setInt(1, eId);
            pstm.setString(2, question);
            pstm.setString(3, ans);
            String correct = getCorrectAnswer(qid);
            pstm.setString(4, correct);
            pstm.setString(5, getAnswerStatus(ans, correct));
            pstm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ExamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private String getCorrectAnswer(int qid) {
        String ans = "";

        try {
            PreparedStatement pstm = conn.prepareStatement("Select correct from questions where question_id=?");
            pstm.setInt(1, qid);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                ans = rs.getString(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ExamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ans;
    }

    private String getAnswerStatus(String ans, String correct) {
        if(ans==null) ans="";
        String resp = "";
        if (ans.equals(correct)) {
            resp = "correct";
        } else {
            resp = "incorrect";
        }
        return resp;

    }

    public void calculateResult(int eid, int tMarks, String endTime, int size) {

        try {
            String sql = "update exams "
                    + "set obt_marks=?, end_time=?,status=? "
                    + "where exam_id=?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            int obt = getObtMarks(eid, tMarks, size);
            pstm.setInt(1, obt);
            pstm.setString(2, endTime);
            float percent = ((obt * 100) / tMarks);
            if (percent >= 45.0) {
                pstm.setString(3, "Pass");
            } else {
                pstm.setString(3, "Fail");
            }
            pstm.setInt(4, eid);
            pstm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ExamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private int getObtMarks(int examId, int tMarks, int size) {
        int m = 0;

        try {
            PreparedStatement pstm = conn.prepareStatement("select count(answer_id) from answers "
                    + "where exam_id=? and status='correct'");
            pstm.setInt(1, examId);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                m = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ExamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        float rat = (float) tMarks / size;
    //    System.out.println(rat);
        rat = m * rat;
    //    System.out.println(rat);
        return m = (int) rat;
    }
    
     public ExamModel getResultByExamId(int examId){
        ExamModel exam=null;
        try {
            PreparedStatement pstm=conn.prepareStatement("select * from exams where exam_id=?");
            pstm.setInt(1, examId);
            ResultSet rs=pstm.executeQuery();
            while(rs.next()){
                exam=new ExamModel();
                exam.setId( rs.getInt(1));
                exam.setStuID(rs.getInt(2));
                exam.setCourseID(rs.getInt(3));
                exam.setTotalMark(rs.getInt(4));
                exam.setObtMark(rs.getInt(5));
                exam.setDate(rs.getDate(6));
                exam.setStartTime(getFormatedTime(rs.getString(7)));
                exam.setEndTime(getFormatedTime(rs.getString(8)));
                exam.setExamTime( rs.getString(9));
                exam.setStatus(rs.getString(10));
               
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ExamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return exam;
        
    }
     
    private String getFormatedTime(String time){
        if(!time.equals("")){
            LocalTime localTime=LocalTime.parse(time);
        return  localTime.format(DateTimeFormatter.ofPattern("hh:mm a"));
        }else{
            
        return  "-";
        }
    }
    
    
     public ArrayList<ExamModel> getAllResultsFromExams(int stdId){
        ArrayList<ExamModel> list=new ArrayList();
        ExamModel exam=null;
        try {
            PreparedStatement pstm=conn.prepareStatement("select * from exams where std_id=? order by date desc");
            pstm.setInt(1, stdId);
            ResultSet rs=pstm.executeQuery();
            while(rs.next()){  
                exam=new ExamModel();
                exam.setId( rs.getInt(1));
                exam.setStuID(rs.getInt(2));
                exam.setCourseID(rs.getInt(3));
                exam.setTotalMark(rs.getInt(4));
                exam.setObtMark(rs.getInt(5));
                exam.setDate(rs.getDate(6));
                exam.setStartTime(getFormatedTime(rs.getString(7)));
                exam.setEndTime(getFormatedTime(rs.getString(8)));
                exam.setExamTime( rs.getString(9));
                exam.setStatus(rs.getString(10));
                list.add(exam);
              
            }
        } catch (SQLException ex) {
            Logger.getLogger(ExamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
        
    }

      public ArrayList<AnswerModel> getAllAnswersByExamId(int examId){
        ArrayList<AnswerModel> list=new ArrayList();
        try {
            
            String sql="Select * from answers where exam_id=?";
            PreparedStatement pstm=conn.prepareStatement(sql);
            pstm.setInt(1,examId);
            ResultSet rs=pstm.executeQuery();
            AnswerModel a;
            while(rs.next()){
               a = new AnswerModel();
                       
               a.setId(rs.getInt("answer_id"));
               a.setExam_id(examId);
               a.setAnswer(rs.getString("answer"));
               a.setCorrect_answer(rs.getString("correct_answer"));
               a.setQuestion(rs.getString("question"));
               a.setStatus(rs.getString("status"));
               
               list.add(a);
            }
            pstm.close();
        } catch (SQLException ex) {
            Logger.getLogger(ExamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
      
      public void deleteExambyCourseID(int id){
            try {
          
            String sql="DELETE dbo.exams WHERE course_id = ?";
            
            PreparedStatement pstmt= conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CourseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
      }
}
