/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdminPackage;

import dao.CategoriesDao;
import dao.ProductDao;
import entity.Categories;
import entity.Product;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ehab
 */
@WebServlet(name = "AdminDeleteCategoryController", urlPatterns = {"/AdminDeleteCategoryController"})
public class AdminDeleteCategoryController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        CategoriesDao getCats = new CategoriesDao();
        ProductDao pro = new ProductDao();
        String id = request.getParameter("id_");
        int i = Integer.parseInt(id);
        if(i != 0){
        ArrayList<Product> arPro = pro.selectProductsByCategoryId(i);
        for(int j=0; j<arPro.size(); j++)
        {
            pro.delete(arPro.get(j));
        }
        Categories cat = getCats.selectById(i);
        getCats.delete(cat);}
        response.sendRedirect("AdminCategoryController");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        
    }
}