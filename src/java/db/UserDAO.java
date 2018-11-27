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

import model.UserModel;

/**
 *
 * @author Admin
 */
public class UserDAO extends BaseDAO {

    public ArrayList<UserModel> allUser() {
        try {
            ArrayList<UserModel> list = new ArrayList<>();
            String sql = "SELECT * FROM dbo.users";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                UserModel ob = new UserModel();
                ob.setId(rs.getInt("user_id"));
                ob.setFirstName(rs.getString("first_name"));
                ob.setLastName(rs.getString("last_name"));
                ob.setUserName(rs.getString("user_name"));
                ob.setEmail(rs.getString("email"));
                ob.setPassword(rs.getString("password"));
                ob.setAddress(rs.getString("address"));
                ob.setCity(rs.getString("city"));
                ob.setContact(rs.getString("contact_no"));
                ob.setType(rs.getString("user_type"));
                list.add(ob);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public UserModel getById(int id) {
        try {
            UserModel ob = new UserModel();
            String sql = " \n"
                    + "        SELECT * FROM dbo.users WHERE user_id=" + id;
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                ob.setId(rs.getInt("user_id"));
                ob.setFirstName(rs.getString("first_name"));
                ob.setLastName(rs.getString("last_name"));
                ob.setUserName(rs.getString("user_name"));
                ob.setEmail(rs.getString("email"));
                ob.setPassword(rs.getString("password"));
                ob.setAddress(rs.getString("address"));
                ob.setCity(rs.getString("city"));
                ob.setContact(rs.getString("contact_no"));
                ob.setType(rs.getString("user_type"));

            }
            return ob;
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    public void update(int userID, String firstName, String lastName, String userName, String email, String password, String contact,
            String city, String address) {
        try {
            String sql = "       UPDATE dbo.users SET first_name= ? , last_name=?, user_name=?, \n"
                    + "       email=?, password=?, contact_no=?,city=?, address=? \n"
                    + "       WHERE user_id=?";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, firstName);
            pstmt.setString(2, lastName);
            pstmt.setString(3, userName);
            pstmt.setString(4, email);
            pstmt.setString(5, password);
            pstmt.setString(6, contact);
            pstmt.setString(7, city);
            pstmt.setString(8, address);
            pstmt.setInt(9, userID);
            pstmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void deteleAccount(int userId){
        try {
            
            String sql="DELETE dbo.users  WHERE  user_id=?";
            PreparedStatement pstmt= conn.prepareStatement(sql);
            pstmt.setInt(1, userId);
            pstmt.executeUpdate();
          
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void insertUser(UserModel ob){
        try {
            String sql="INSERT INTO dbo.users\n" +
                    " ( first_name ,last_name , user_name , email , password , user_type , contact_no , city ,address  )\n" +
                    "VALUES  ( ? ,  ?,  ? ,  ? ,? ,  'student' ,? ,   ? ,   ? )";
            PreparedStatement pstmt= conn.prepareStatement(sql);
            pstmt.setString(1, ob.getFirstName());
            pstmt.setString(2, ob.getLastName());
            pstmt.setString(3, ob.getUserName());
            pstmt.setString(4, ob.getEmail());
            pstmt.setString(5, ob.getPassword());
            pstmt.setString(6, ob.getContact());
            pstmt.setString(7, ob.getCity());
            pstmt.setString(8, ob.getAddress());
            
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
