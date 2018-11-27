/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import db.CourseDAO;
import java.sql.Date;

/**
 *
 * @author Admin
 */
public class ExamModel  extends BaseModel{
    
    private int stuID;
    private int courseID;
    private int totalMark;
    private int obtMark;
    private Date date;
    private String startTime;
    private String endTime;
    private String examTime;
    private String status;

    public int getStuID() {
        return stuID;
    }

    public void setStuID(int stuID) {
        this.stuID = stuID;
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public int getTotalMark() {
        return totalMark;
    }

    public void setTotalMark(int totalMark) {
        this.totalMark = totalMark;
    }

    public int getObtMark() {
        return obtMark;
    }

    public void setObtMark(int obtMark) {
        this.obtMark = obtMark;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getExamTime() {
        return examTime;
    }

    public void setExamTime(String examTime) {
        this.examTime = examTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
    
            
    public Course getCourseByExamId(){
        return new CourseDAO().getCourseById(courseID);
    }
    
}
