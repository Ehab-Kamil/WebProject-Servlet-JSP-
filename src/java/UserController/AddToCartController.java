/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserController;

import HibernateDao.HCartProductDao;
import HibernateDao.HUserDao;
import HibernateEntity.*;
import java.io.IOException;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "AddToCartController", urlPatterns = {"/AddToCartController"})
public class AddToCartController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        Users user = (Users) session.getAttribute("user");
        if (user == null) {
            response.sendRedirect("UserPages/Login.jsp");
        } else {
            CartProduct cartProduct = new CartProduct();
            cartProduct.setCartProductDate(new Date());
            cartProduct.setCartProductMount(Integer.parseInt(request.getParameter("productMount")));
            Product p = new Product();
            p.setIdproduct(Integer.parseInt(request.getParameter("idproduct")));
            cartProduct.setProduct(p);
            cartProduct.setUsers(user);
            HCartProductDao cartProductDao = new HCartProductDao();
            int insert = cartProductDao.insert(cartProduct);

            //user.getCartProducts().add(cartProduct);
            /*  user.addCartProduct(cartProduct);
             HUserDao userDao=new HUserDao();
             userDao.update(user);
             */
            session.setAttribute("user", user);
            response.sendRedirect("/WebProjectServletJsp/IndexController");

        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
