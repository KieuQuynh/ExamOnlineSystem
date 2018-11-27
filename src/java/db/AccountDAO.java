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
public class AccountDAO extends BaseDAO {

    public ArrayList<UserModel> getAllStudent() {
        try {
            ArrayList<UserModel> list= new ArrayList<>();
            String sql = "SELECT * FROM dbo.users\n"
                    + "WHERE user_type='student'";
            
            PreparedStatement pstmt= conn.prepareStatement(sql);
            ResultSet rs= pstmt.executeQuery();
            while(rs.next()){
                UserModel ob= new UserModel();
                ob.setId(rs.getInt("user_id"));
                ob.setFirstName(rs.getString("first_name"));
                ob.setLastName(rs.getString("last_name"));
                ob.setUserName(rs.getString("user_name"));
                ob.setEmail(rs.getString("email"));
                ob.setPassword(rs.getString("password"));
                ob.setType(rs.getString("user_type"));
                ob.setContact(rs.getString("contact_no"));
                ob.setCity(rs.getString("city"));
                ob.setAddress(rs.getString("address"));
                list.add(ob);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
