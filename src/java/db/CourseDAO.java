
package db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Course;

public class CourseDAO  extends BaseDAO{
    
    public Course getCourseById(int id){
        try {
            Course ob = new Course();
            String sql="SELECT * FROM dbo.courses\n" +
                    "WHERE id =?";
            PreparedStatement pstmt= conn.prepareStatement(sql);
            pstmt.setInt(1, id);
          ResultSet rs=  pstmt.executeQuery();
          if(rs.next()){
              ob.setId(id);
              ob.setName(rs.getString("course_name"));
              ob.setMark(rs.getInt("total_marks"));
              ob.setTime(rs.getString("time"));
              return ob;
          }
        } catch (SQLException ex) {
            Logger.getLogger(CourseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
        
    }
    public ArrayList<Course> allCourse(){
        try {
            ArrayList<Course> list= new ArrayList<>();
            String sql="SELECT * FROM dbo.courses";
            PreparedStatement pstmt= conn.prepareStatement(sql);
            ResultSet rs= pstmt.executeQuery();
            while(rs.next()){
                Course ob= new Course();
                ob.setId(rs.getInt("id"));
                ob.setName(rs.getString("course_name"));
                ob.setMark(rs.getInt("total_marks"));
                ob.setTime(rs.getString("time"));
                list.add(ob);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(CourseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public int insertCourse(String name, int mark, String time){
        try {
            String sql="    INSERT INTO dbo.courses\n" +
                    "            ( course_name, total_marks, time )\n" +
                    "    VALUES  ( ?,?,?  )  ";
            
            PreparedStatement pstmt= conn.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setInt(2, mark);
            pstmt.setString(3, time);
            int result =pstmt.executeUpdate();
            return result;
        } catch (SQLException ex) {
            Logger.getLogger(CourseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
       return 0;
    }
    
    public void deleteCourse(int id){
        try {
             ExamDAO edb= new ExamDAO();
             edb.deleteExambyCourseID(id);
             QuestionDAO qdb= new QuestionDAO();
             qdb.deleteQuestionbyCourseID(id);
            String sql="DELETE dbo.courses WHERE id=?";
            
            PreparedStatement pstmt= conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CourseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
