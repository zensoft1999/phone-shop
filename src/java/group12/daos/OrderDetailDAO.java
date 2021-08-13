/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package group12.daos;

import group12.dtos.OrderdetailsDTO;
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
public class OrderDetailDAO implements Serializable {

    public int insertOrderDetail(OrderdetailsDTO dto) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        int orderDetailID = -1;

        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                String sql = "INSERT INTO tbl_OrderDetails( orderID, productID, price, quantity) "
                        + " VALUES(?, ?, ?, ?)";

                stm = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                stm.setInt(1, dto.getOrderID());
                stm.setString(2, dto.getProductID());
                stm.setFloat(3, dto.getPrice());
                stm.setInt(4, dto.getQuantity());
                check = stm.executeUpdate() > 0 ? true : check;
                rs = stm.getGeneratedKeys();
                if (rs.next()) {
                    orderDetailID = rs.getInt(1);
                }
            }
        } catch (Exception e) {
            System.out.println("Error at insertOrderDetail: " + e.getMessage());
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
        return orderDetailID;
    }

    public int countOrderDetailID() throws SQLException {
        int count = 0;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                String sql = "SELECT COUNT (orderdetailID) "
                        + " AS Number "
                        + " FROM tbl_OrderDetails";
                stm = conn.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    count = rs.getInt("Number");
                }
            }
        } catch (Exception e) {
            System.out.println("Error at countOrderDetailID: " + e.getMessage());
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
