/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package group12.controllers;

import group12.daos.AddProductErrorDAO;
import group12.daos.WatchDAO;
import group12.dtos.AddProductErrorDTO;
import group12.dtos.WatchDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ASUS-PC
 */
public class AddNewProductController extends HttpServlet {

    private static final String ERROR = "error.jsp";
    private static final String SUCCESS = "SearchByADController";
    private static final String ERROR_CHECK = "addproduct.jsp";

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
        AddProductErrorDTO error = new AddProductErrorDTO("", "", "", "", "");
        try {
            String productID = request.getParameter("productID");
            String productName = request.getParameter("productName");
            float price = Float.parseFloat(request.getParameter("price"));
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            String categoryID = request.getParameter("categoryID");
            String brand = request.getParameter("brand");
            String image = request.getParameter("inputImage");

            //Validate
            AddProductErrorDAO errordao = new AddProductErrorDAO();
            boolean flag = true;
            boolean checkInputID = errordao.checkInput(productID);
            boolean checkInputName = errordao.checkInput(productName);
            boolean checkInputBrand = errordao.checkInput(brand);
            

            if (!checkInputID) {
                flag = false;
                error.setProductIDError("Invalid Product ID!");
            }

            if (!checkInputName) {
                flag = false;
                error.setProductNameError("Invalid Product Name!");
            }

            if (!checkInputBrand) {
                flag = false;
                error.setBrandError("Invalid Brand!");
            }

            if (price <= 0) {
                flag = false;
                error.setPriceError("Price must be greater than 0!");
            }

            if (quantity <= 0) {
                flag = false;
                error.setQuantityError("Quantity must be greater than 0!");
            }

            if (flag) {
                WatchDAO dao = new WatchDAO();
                boolean check = dao.checkDuplicate(productID);
                if (check) {
                    error.setProductIDError("Duplicate Product ID!!!!");
                    request.setAttribute("ERROR", error);
                    url = ERROR_CHECK;
                } else {
                    WatchDTO watch = new WatchDTO(productID, productName, price, quantity, categoryID, brand, image);
                    dao.insert(watch);
                    url = SUCCESS;
                }
            } else {
                request.setAttribute("ERROR", error);
                url = ERROR_CHECK;
            }
        } catch (Exception e) {
            log("Error at AddNewProductController: " + e.toString());
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
