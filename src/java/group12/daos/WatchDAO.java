/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package group12.daos;

import group12.dtos.ShowInfoDTO;
import group12.dtos.UpdateProductDTO;
import group12.dtos.UpdateQuantityDTO;
import group12.dtos.WatchDTO;
import group12.utils.DBUtil;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS-PC
 */
public class WatchDAO implements Serializable {

    public List<ShowInfoDTO> getListWatches() throws SQLException {
        List<ShowInfoDTO> list = null;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        ShowInfoDTO dto = null;

        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                String sql = "SELECT productID, productName, price, image "
                        + " FROM tbl_Products";
                stm = conn.prepareStatement(sql);
                rs = stm.executeQuery();

                while (rs.next()) {
                    String productID = rs.getString("productID");
                    String productName = rs.getString("productName");
                    String image = rs.getString("image");
                    float price = rs.getFloat("price");

                    if (list == null) {
                        list = new ArrayList<>();
                    }
                    dto = new ShowInfoDTO( productID, productName, image, price);
                    list.add(dto);
                }
            }
        } catch (Exception e) {
            System.out.println("Error at getListWatches: " + e.getMessage());
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

        return list;
    }

    public List<ShowInfoDTO> getListWatchesByName(String txtSearch) throws SQLException {
        List<ShowInfoDTO> list = null;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        ShowInfoDTO dto = null;

        try {

            conn = DBUtil.getConnection();
            if (conn != null) {
                String sql = "SELECT productID, productName, price, image "
                        + " FROM tbl_Products "
                        + " WHERE productName LIKE ?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, "%" + txtSearch + "%");
                rs = stm.executeQuery();
                while (rs.next()) {
                    String productID = rs.getString("productID");
                    String productName = rs.getString("productName");
                    String image = rs.getString("image");
                    float price = rs.getFloat("price");

                    if (list == null) {
                        list = new ArrayList<>();
                    }
                    dto = new ShowInfoDTO(productID, productName, image, price);
                    list.add(dto);
                }
            }

        } catch (Exception e) {
            System.out.println("ERROR at getListWatchesByName: " + e.getMessage());
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
        return list;
    }

    public List<WatchDTO> getListWatchesByNameOrID(String txtSearch) throws SQLException {
        List<WatchDTO> list = null;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        WatchDTO dto = null;

        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                String sql = "SELECT productID, productName, price, quantity, categoryID, brand, image "
                        + " FROM tbl_Products "
                        + " WHERE productID like ? "
                        + " OR productName like ? ";
                stm = conn.prepareStatement(sql);
                stm.setString(1, "%" + txtSearch + "%");
                stm.setString(2, "%" + txtSearch + "%");
                rs = stm.executeQuery();
                while (rs.next()) {
                    String productID = rs.getString("productID");
                    String productName = rs.getString("productName");
                    float price = rs.getFloat("price");
                    int quantity = rs.getInt("quantity");
                    String categoryID = rs.getString("categoryID");
                    String brand = rs.getString("brand");
                    String image = rs.getString("image");

                    if (list == null) {
                        list = new ArrayList<>();
                    }
                    dto = new WatchDTO(productID, productName, price, quantity, categoryID, brand, image);
                    list.add(dto);
                }
            }
        } catch (Exception e) {
            System.out.println("Error at getListWatchesByNameOrID: " + e.getMessage());
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
        return list;
    }

    public boolean deleteProduct(String productID) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                String sql = "DELETE tbl_Products "
                        + " WHERE productID = ?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, productID);
                check = stm.executeUpdate() > 0 ? true : check;
            }
        } catch (Exception e) {
            System.out.println("Error at deleteProducts: " + e.getMessage());
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

        return check;
    }

    public boolean updateProduct(UpdateProductDTO product) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                String sql = "UPDATE tbl_Products "
                        + " SET productName = ?, price = ?, quantity = ?, brand = ?, image = ? "
                        + " WHERE productID = ?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, product.getProductName());
                stm.setFloat(2, product.getPrice());
                stm.setInt(3, product.getQuantity());
                stm.setString(4, product.getBrand());
                stm.setString(5, product.getImage());
                stm.setString(6, product.getProductID());
                check = stm.executeUpdate() > 0 ? true : check;
            }

        } catch (Exception e) {
            System.out.println("Error at updateProduct: " + e.toString());
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
        return check;
    }

    public boolean checkDuplicate(String productID) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {

            conn = DBUtil.getConnection();
            if (conn != null) {
                String sql = "SELECT productID "
                        + " FROM tbl_Products "
                        + " WHERE productID = ?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, productID);
                rs = stm.executeQuery();
                
                if (rs.next()) {
                    check = true;
                }
            }
        } catch (Exception e) {
            System.out.println("Error at updateProduct: " + e.toString());
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
        return check;
    }

    public boolean insert(WatchDTO product) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {

            conn = DBUtil.getConnection();
            if (conn != null) {
                String sql = "INSERT INTO tbl_Products(productID, productName, price, quantity, categoryID, brand, image) "
                        + " VALUES(?, ?, ?, ?, ?, ?, ?)";
                stm = conn.prepareStatement(sql);
                stm.setString(1, product.getProductID());
                stm.setString(2, product.getProductName());
                stm.setFloat(3, product.getPrice());
                stm.setInt(4, product.getQuantity());
                stm.setString(5, product.getCategoryID());
                stm.setString(6, product.getBrand());
                stm.setString(7, product.getImage());
                check = stm.executeUpdate() > 0 ? true : check;
            }

        } catch (Exception e) {
            System.out.println("Error at updateProduct: " + e.toString());
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
        return check;
    }

    public WatchDTO getProductByID(String productID) throws SQLException {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        WatchDTO dto = null;

        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                String sql = "SELECT productID, productName, price, quantity, categoryID, brand, image "
                        + " FROM tbl_Products "
                        + " WHERE productID = ? ";
                stm = conn.prepareStatement(sql);
                stm.setString(1,productID);
                rs = stm.executeQuery();
                if(rs.next()) {
                    String productName = rs.getString("productName");
                    float price = rs.getFloat("price");
                    int quantity = rs.getInt("quantity");
                    String categoryID = rs.getString("categoryID");
                    String brand = rs.getString("brand");
                    String image = rs.getString("image");

                    dto = new WatchDTO(productID, productName, price, quantity, categoryID, brand, image);               
                }
            }
        } catch (Exception e) {
            System.out.println("Error at getListWatchesByNameOrID: " + e.getMessage());
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
        return dto;
    }
    
        public boolean updateQuantity(UpdateQuantityDTO quantity) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                String sql = "UPDATE tbl_Products "
                        + " SET quantity = quantity - ? "
                        + "WHERE productID = ?";
                stm = conn.prepareStatement(sql);
                stm.setInt(1, quantity.getQuantity());
                stm.setString(2, quantity.getProductID());
                check = stm.executeUpdate() > 0 ? true : check;
            }
        } catch (Exception e) {
            System.out.println("Error at updateQuantity: " + e.getMessage());
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
        return check;
    }

}
