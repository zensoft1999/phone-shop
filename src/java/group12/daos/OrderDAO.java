/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package group12.daos;

import group12.dtos.OrdersDTO;
import group12.utils.DBUtil;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author ASUS-PC
 */
public class OrderDAO implements Serializable {

    public int insertOrder(OrdersDTO order) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        int orderID = -1;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                String sql = "INSERT INTO tbl_Orders(userID, date, total) "
                        + " VALUES(?, ?, ?)";
                stm = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                stm.setString(1, order.getUserID());
                stm.setString(2, order.getDate());
                stm.setFloat(3, order.getTotal());
                check = stm.executeUpdate() > 0 ? check : true;
                rs = stm.getGeneratedKeys();
                if (rs.next()) {
                    orderID = rs.getInt(1);
                }
            }
        } catch (Exception e) {
            System.out.println("Error at insertOrder: " + e.getMessage());
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
        return orderID;
    }

    public int countOrderID() throws SQLException {
        int count = 0;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                String sql = "SELECT COUNT (orderID) "
                        + " AS Number "
                        + " FROM tbl_Orders";
                stm = conn.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    count = rs.getInt("Number");
                }
            }
        } catch (Exception e) {
            System.out.println("Error at countOrderID: " + e.getMessage());
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

        return count;
    }

}
