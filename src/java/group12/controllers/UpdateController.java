/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package group12.controllers;

import group12.daos.AddProductErrorDAO;
import group12.daos.WatchDAO;
import group12.dtos.AddProductErrorDTO;
import group12.dtos.UpdateProductDTO;
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
public class UpdateController extends HttpServlet {

    private static final String ERROR = "error.jsp";
    private static final String SUCCESS = "SearchByADController";
    private static final String ERROR_CHECK = "DirectToUpdateController";

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
            Float price = Float.parseFloat(request.getParameter("price"));
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            String brand = request.getParameter("brand");
            String image = request.getParameter("image");
            String inputImage = request.getParameter("inputImage");

            //Validate
            AddProductErrorDAO errordao = new AddProductErrorDAO();
            boolean flag = true;
            boolean checkInputName = errordao.checkInput(productName);
            boolean checkInputBrand = errordao.checkInput(brand);

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
                if (inputImage != null && inputImage.length() > 0) {
                    image = inputImage;
                }

                UpdateProductDTO product = new UpdateProductDTO(productID, productName, price, quantity, brand, image);
                WatchDAO dao = new WatchDAO();
                boolean check = dao.updateProduct(product);

                if (check) {
                    url = SUCCESS;
                }
            } else {
                request.setAttribute("ERROR", error);
                url = ERROR_CHECK;
            }

        } catch (Exception e) {
            log("ERROR at UpdateController: " + e.toString());
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
