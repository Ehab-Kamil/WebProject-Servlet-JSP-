/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserController;

import HibernateDao.HCartProductDao;
import HibernateDao.HUserDao;
import HibernateEntity.CartProduct;
import HibernateEntity.Product;
import HibernateEntity.Users;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.DispatcherType;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.*;  
import javax.servlet.http.*;  

/**
 *
 * @author Ehab
 */
@WebServlet(name = "EditCartController", urlPatterns = {"/EditCartController"})
public class EditCartController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession(false);
        Users user = (Users) session.getAttribute("user");
        if (user == null) {
            response.sendRedirect("UserPages/Login.jsp");
        } else {
            int idcartProduct =Integer.parseInt(request.getParameter("idcartProduct"));
            HCartProductDao cartProductDao=new HCartProductDao();
            CartProduct cartProduct = cartProductDao.selectById(idcartProduct);
            
            request.setAttribute("cartProduct", cartProduct);
           RequestDispatcher rd=request.getRequestDispatcher("");
           rd.forward(request, response);
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

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
