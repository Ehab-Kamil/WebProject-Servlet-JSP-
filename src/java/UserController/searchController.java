/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserController;

import HibernateDao.HProductDao;
import HibernateEntity.Product;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Amira Anis
 */
public class searchController extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet searchController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet searchController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
       // processRequest(request, response);
        String key = request.getParameter("search");
        System.out.println("------>>> " + key);
        HProductDao productDao = new HProductDao();
        List<Product> productList = productDao.search(key);
        if (productList.size()> 0){
        for (Product product : productList) {
            System.out.println("------------<<>>--------------");
            System.out.println("id : " + product.getIdproduct());
            System.out.println("name : " + product.getProductName());
            System.out.println("dis : " + product.getProductDescription());
            System.out.println("dis : " + product.getProductPrice());
            
        }
//#8CE78A
        //request.getServletContext().setAttribute("productList", productList);
        request.setAttribute("productList", productList);
        }
        else 
        {
            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
            
            
            out.println("There is no matching result");
            
        }
        }
        RequestDispatcher rd = request.getRequestDispatcher("/UserPages/products.jsp");
        rd.forward(request, response);
        
//        HttpSession session = request.getSession(true);
//        session.setAttribute("productList", productList);
//        RequestDispatcher rd3 = request.getRequestDispatcher("/UserPages/products.jsp");
//        rd3.forward(request, response);
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
        //processRequest(request, response);
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
