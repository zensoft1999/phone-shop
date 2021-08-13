/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package group12.daos;

import group12.dtos.LoginDTO;
import group12.dtos.UserDTO;
import group12.utils.DBUtil;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author ASUS-PC
 */
public class UserDAO implements Serializable {
    public LoginDTO checkLogin(String userID, int password) throws Exception {
        LoginDTO user = null;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
           conn = DBUtil.getConnection();
           if (conn != null) {
               String sql = "SELECT fullName, roleID "
                       + " FROM tbl_Users "
                       + " WHERE userID = '"+ userID +"' AND password = '" + password + "'";
               stm = conn.prepareStatement(sql);
               rs = stm.executeQuery();
               
               if (rs.next()) {
                   String fullName = rs.getString("fullName");
                   String roleID = rs.getString("roleID");
                   user = new LoginDTO(userID, fullName, roleID, 0);
               }
           }     
        } catch (Exception e) {
            System.out.println("Error at Checklogin: " + e.getMessage());
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return user;
    }
}
