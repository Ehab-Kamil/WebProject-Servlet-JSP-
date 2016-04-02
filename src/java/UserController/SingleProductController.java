/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserController;

import HibernateDao.HProductDao;
//import dao.ProductDao;
//import entity.Product;
//import entity.ProductPK;
import HibernateEntity.Product;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Aya Mahmoud
 */
/////////////////Added to handle passing product bean to single.jsp
public class SingleProductController extends HttpServlet{

    Product product;
    RequestDispatcher rd;
    HProductDao pd;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       
        //String str = req.getParameter("edit");//addedby Ehab
        String idpro = req.getParameter("id");
//        System.out.println("id for product: " + idpro);
        //int id = Integer.parseInt(idpro);
//        pd = new ProductDao();
       pd=new HProductDao();
       
        Product prod = pd.selectById(Integer.parseInt(idpro));
        req.setAttribute("product", prod);
        
        //if(str==null){
        rd = req.getRequestDispatcher("/UserPages/SingleProduct.jsp");
        rd.forward(req, resp);
           // }else{
        //rd = req.getRequestDispatcher("/editSingle.jsp");
         //rd.forward(req, resp);
        //}
    }
}