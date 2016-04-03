/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserController;

import HibernateEntity.CartProduct;
import HibernateEntity.Users;
import java.io.IOException;
import java.util.Set;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "CartController", urlPatterns = {"/CartController"})
public class CartController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        Users user = (Users) session.getAttribute("user");
        /*  Session session = HDBconnect.getInstance().getSession();
         Users user = (Users) session.get(Users.class, 1);*/

        if (user == null) {
            response.sendRedirect("UserPages/Login.jsp");
        } else {
            Set<CartProduct> cartProducts = user.getCartProducts();
            for (CartProduct cartProduct : cartProducts) {
                System.out.println(cartProduct.getCartProductMount() + "/" + cartProduct.getUsers().getIdusers());
            }
            request.setAttribute("cartProducts", cartProducts);
            RequestDispatcher rd = request.getRequestDispatcher("/UserPages/Cart.jsp");
            rd.forward(request, response);
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
