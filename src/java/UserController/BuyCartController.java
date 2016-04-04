/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserController;

import HibernateEntity.*;
import HibernateDao.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.time.LocalDate;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Ehab
 */
@WebServlet(name = "BuyCartController", urlPatterns = {"/BuyCartController"})
public class BuyCartController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Users user = (Users) request.getSession().getAttribute("user");
        int idcartProduct = Integer.parseInt(request.getParameter("idcartProduct"));

        HCartProductDao cartProductDao = new HCartProductDao();
        CartProduct cartProduct = cartProductDao.selectById(idcartProduct);
        
        boolean ch = true;
        if (user.getUserCharge() < (cartProduct.getProduct().getProductPrice()*cartProduct.getCartProductMount()))
        {
            response.sendRedirect("/WebProjectServletJsp/UserPages/balance.jsp");
            ch = false;
        }
        if (cartProduct.getProduct().getProductQuntityavailable() < cartProduct.getCartProductMount()) {
            response.sendRedirect("/WebProjectServletJsp/UserPages/carterror.jsp");
            System.out.println("product not available");
            ch = false;
        }
        if (ch == true) {
            Payment payment = new Payment();
            payment.setPaymentDate(new java.util.Date());
            payment.setPaymentDiscount(0.0F);
            payment.setPaymentTotal(cartProduct.getProduct().getProductPrice()*cartProduct.getCartProductMount());
            payment.setUsers(user);
           
            cartProduct.getProduct().setProductQuntityavailable(cartProduct.getProduct().getProductQuntityavailable()-cartProduct.getCartProductMount());
            payment.addCartProduct(cartProduct);
            
            HPaymentDao hPaymentDao=new HPaymentDao();
            hPaymentDao.insert(payment);
            
            user.addPayment(payment);
            user.setUserCharge(user.getUserCharge()-(cartProduct.getProduct().getProductPrice()*cartProduct.getCartProductMount()));
            
            
           /* HPaymentDao paymentDao=new HPaymentDao();
            paymentDao.insert(payment);*/
            
            /*UsersDao usersDao = new UsersDao();
            user = usersDao.selectById(user.getIdusers());*/
            
            HUserDao usersDao = new HUserDao();
            usersDao.update(user);

            HttpSession session = request.getSession(true);
            session.setAttribute("user", user);
            response.sendRedirect("/WebProjectServletJsp/CartController");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
