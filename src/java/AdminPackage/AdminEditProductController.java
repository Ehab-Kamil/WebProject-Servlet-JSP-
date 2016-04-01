/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdminPackage;

import HibernateDao.HProductDao;
import dao.ProductDao;
//import entity.Product;
import HibernateEntity.Product;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ehab
 */
@WebServlet(name = "AdminEditProductController", urlPatterns = {"/AdminEditProductController"})
public class AdminEditProductController extends HttpServlet {

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
            out.println("<title>Servlet AdminEditProductController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AdminEditProductController at " + request.getContextPath() + "</h1>");
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

        int id = Integer.parseInt(request.getParameter("pid"));
//        ProductDao pDao = new ProductDao();
//        Product product = pDao.selectById(id);
        HProductDao pDao = new HProductDao();
        Product product = pDao.selectById(id);
        request.setAttribute("product", product);
        RequestDispatcher rd = request.getRequestDispatcher("/AdminPages/AdminEditProduct.jsp");
        rd.forward(request, response);

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

        ProductDao pDao = new ProductDao();
        entity.Product product = new entity.Product();

        product.setIdproduct(Integer.parseInt(request.getParameter("hiddenID")));
        product.setProductName(request.getParameter("productName"));
        product.setProductDescription(request.getParameter("productDesc"));
        product.setProductPrice(Float.parseFloat(request.getParameter("productPrice")));
        product.setProductQuntityavailable(Integer.parseInt(request.getParameter("productQuantityAvailable")));

        pDao.update(product);
        response.sendRedirect("AdminProductController");
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
