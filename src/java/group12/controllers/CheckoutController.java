/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package group12.controllers;

import group12.carts.CartObject;
import group12.daos.OrderDAO;
import group12.daos.OrderDetailDAO;
import group12.daos.WatchDAO;
import group12.dtos.OrderdetailsDTO;
import group12.dtos.OrdersDTO;
import group12.dtos.UpdateQuantityDTO;
import group12.dtos.WatchDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ASUS-PC
 */
public class CheckoutController extends HttpServlet {
    private static final String ERROR = "error.jsp";
    private static final String SUCCESS = "checkout.jsp";
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        WatchDAO dao = new WatchDAO();
        WatchDTO product = new WatchDTO();
        UpdateQuantityDTO quantity = new UpdateQuantityDTO();
        float total = 0;
        
        try  {
            HttpSession session = request.getSession();
            CartObject cart = (CartObject) session.getAttribute("USER_CART");
            
            //Tao Order
            for (Map.Entry<String, Integer> entry : cart.getItems().entrySet()) {
                String productID = entry.getKey();
                product = dao.getProductByID(productID);
                
                if (product != null) {
                    total += product.getPrice() * entry.getValue();
                    quantity.setProductID(productID);
                    quantity.setQuantity(entry.getValue());
                    dao.updateQuantity(quantity);
                }
            }
            
            OrdersDTO order = new OrdersDTO();
            OrderDAO orderdao = new OrderDAO();
            LocalDateTime now = LocalDateTime.now();
            
            order.setUserID(cart.getUserID());
            order.setTotal(total);
            order.setDate(now.toString());
            
            int orderID = orderdao.insertOrder(order);
            order.setOrderID(orderID);
            request.setAttribute("ORDER", order);
            
            //Tao Order Detail
            
            List<OrderdetailsDTO> orderDetail = new ArrayList<>();
            for (Map.Entry<String, Integer> entry : cart.getItems().entrySet()) {
                String productID = entry.getKey();
                product = dao.getProductByID(productID);
                
                if (product != null) {
                    OrderdetailsDTO orderdetail = new OrderdetailsDTO();
                    OrderDetailDAO orderdetaildao = new OrderDetailDAO();
                    
                    orderdetail.setOrderID(orderID);
                    System.out.println(orderID);
                    orderdetail.setProductID(productID);
                    orderdetail.setPrice(product.getPrice());
                    orderdetail.setQuantity(entry.getValue());
                    
                    int orderDetailID = orderdetaildao.insertOrderDetail(orderdetail);
                    orderdetail.setOrderDetailID(orderDetailID);
                    orderDetail.add(orderdetail);
                }
            }
            
            request.setAttribute("LIST_ORDERDETAIL", orderDetail);
            session.setAttribute("USER_CART", null);
            url = SUCCESS;
        } catch (Exception e) {
            log("ERROR at CheckoutController: " + e.getMessage());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
