/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package group12.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ASUS-PC
 */
public class MainController extends HttpServlet {

    private static final String ERROR = "error.jsp";
    private static final String LOGIN = "LoginController";
    private static final String LOGOUT = "LogoutController";
    private static final String SEARCH = "SearchController";
    private static final String SEARCH_BY_ADMIN = "SearchByADController";
    private static final String DELETE = "DeleteController";
    private static final String DETAIL = "DirectToUpdateController";
    private static final String UPDATE = "UpdateController";
    private static final String ADD_NEW_PRODUCT = "AddNewProductController";
    private static final String ADD_ITEMS_TO_CART = "AddItemsToCartController";
    private static final String REMOVE_ITEMS_IN_CART = "RemoveItemsInCartController";
    private static final String CHECK_OUT = "CheckoutController";

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
        try {
            String action = request.getParameter("action");
            switch (action) {
                case "Login":
                    url = LOGIN;
                    break;

                case "Logout":
                    url = LOGOUT;
                    break;

                case "Search":
                    url = SEARCH;
                    break;

                case "Search By AD":
                    url = SEARCH_BY_ADMIN;
                    break;

                case "Delete":
                    url = DELETE;
                    break;

                case "Detail":
                    url = DETAIL;
                    break;

                case "Update":
                    url = UPDATE;
                    break;

                case "Add":
                    url = ADD_NEW_PRODUCT;
                    break;

                case "Add to Cart":
                    url = ADD_ITEMS_TO_CART;
                    break;
                 
                case "Remove Selected Item":
                    url = REMOVE_ITEMS_IN_CART;
                    break;
                 
                case "Check out":
                    url = CHECK_OUT;
                    break;
            }
        } catch (Exception e) {
            log("ERROR at MainController: " + e.toString());
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
