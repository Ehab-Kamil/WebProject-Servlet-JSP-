/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserController;

import dao.CartProductDao;
import dao.ProductDao;
import dao.UsersDao;
import entity.CartProduct;
import entity.Product;
import entity.Users;
import java.io.IOException;
import java.io.PrintWriter;
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

            //  user=(Users) session.getAttribute("user");            
            //  cartProduct.setProduct(request.getParameter("idproduct"));            
            Product p = new Product();
            ProductDao productDao = new ProductDao();
            p = productDao.selectById(Integer.parseInt(request.getParameter("idproduct")));
            cartProduct.setProduct(p);
            cartProduct.setCartProductMount(Integer.parseInt(request.getParameter("productMount")));
            cartProduct.setUsersIdusers(user);
            cartProduct.setProductColor(request.getParameter("productColor"));
            cartProduct.setProductsize(request.getParameter("productSize"));
            int insert = cpd.insert(cartProduct);
            if (insert == 0) {
                response.sendRedirect("IndexController");
                System.out.println("error in insert cartproduct");
            } else {
                UsersDao usersDao = new UsersDao();
                user = usersDao.selectById(user.getIdusers());
//                HttpSession session = request.getSession(true);
                session.setAttribute("user", user);

                response.sendRedirect("IndexController");
            }
            // request.setAttribute("cartProduct", cpd.selectByUser(user));
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
