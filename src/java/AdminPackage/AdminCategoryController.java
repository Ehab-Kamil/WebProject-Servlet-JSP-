/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdminPackage;

import HibernateDao.HCategoriesDao;
import HibernateEntity.Categories;
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
@WebServlet(name = "AdminCategoryController", urlPatterns = {"/AdminCategoryController"})
public class AdminCategoryController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HCategoriesDao getCats = new HCategoriesDao();
        ArrayList<Categories> list = (ArrayList<Categories>) getCats.selectAll();
        request.setAttribute("catsName", list);
        RequestDispatcher rd = request.getRequestDispatcher("/AdminPages/AdminShowCategories.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        String name = request.getParameter("cat_name");
        Categories cat = new Categories();
        HCategoriesDao catDao = new HCategoriesDao();
        ArrayList<Categories> cats = catDao.selectAll();
        boolean exists=false;
        for(int i=0; i<cats.size(); i++)
        {
            if(cats.get(i).getCategoryName().equalsIgnoreCase(name))
            {
                System.out.println("same name");
                exists = false;
            }
            else{
                exists = true;
            }
        }
        if(exists) {
        cat.setCategoryName(name);
        catDao.insert(cat); 
        }
        response.sendRedirect("AdminCategoryController");
    }
}