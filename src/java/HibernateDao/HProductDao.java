/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HibernateDao;

import HibernateEntity.Product;
import dao.DoaInterface;
import db.HDBconnect;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Ehab
 */
public class HProductDao implements DoaInterface<Product> {

    Session session;
    Product product;

    @Override
    public int insert(Product bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int update(Product bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(Product bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Product selectById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Product selectByName(String name) {

        session = HDBconnect.getInstance().getSession();
        Query query = session.createQuery("from Product p where p.productName=:name");
        query.setParameter("name", name);
        product = (Product) query.uniqueResult();
        return product;
    }

    @Override
    public List<Product> selectAll() {

        session = HDBconnect.getInstance().getSession();
        Query query = session.createQuery("from Product p");
        ArrayList<Product> productList = (ArrayList) query.list();
        return productList;
    }

}
