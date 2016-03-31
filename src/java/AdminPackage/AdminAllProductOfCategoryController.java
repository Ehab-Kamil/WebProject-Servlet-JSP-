/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdminPackage;

import dao.ProductDao;
import entity.Product;
import java.io.IOException;
import java.util.ArrayList;
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
@WebServlet(name = "AdminAllProductOfCategoryController", urlPatterns = {"/AdminAllProductOfCategoryController"})
public class AdminAllProductOfCategoryController extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //String catID = request.getParameter("id");
       // int id = Integer.parseInt(catID);
        ProductDao pd = new ProductDao();
        //ArrayList<Product> arPro = pd.selectProductsByCategoryId(id);
        Product pro1 = pd.selectById(1);
        Product pro2 = pd.selectById(2);
        Product pro3 = pd.selectById(3);
        Product pro4 = pd.selectById(4);
        ArrayList<Product> arPro = new ArrayList();
        arPro.add(pro1);
        arPro.add(pro2);
        arPro.add(pro3);
        arPro.add(pro4);
        //request.setAttribute("productList", arPro);
        request.setAttribute("productList", arPro);
        RequestDispatcher rd = request.getRequestDispatcher("/Adminpages/AdminShowProducts.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    }
}