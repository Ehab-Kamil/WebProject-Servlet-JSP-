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
        ////// still have a lots of problem m7adesh ye copy menha heya bayza aslan :D 
        int flag = 0;
        session = HDBconnect.getInstance().getSession();
        try {
            session.beginTransaction();
            session.persist(bean);
            session.getTransaction().commit();
            flag = 1;
        } catch (Exception e) {
            flag = 0;
        }
        return flag;
    }

    @Override
    public int update(Product bean) {

        int flag = 0;
        session = HDBconnect.getInstance().getSession();
        try {
            session.beginTransaction();
            session.update(bean);
            session.getTransaction().commit();
            flag = 1;
        } catch (Exception e) {
            flag = 0;
        }
        return flag;

    }

    @Override
    public int delete(Product bean) {
        int flag = 0;
        session = HDBconnect.getInstance().getSession();
        try {
            session.beginTransaction();
            session.delete(bean);
            session.getTransaction().commit();
            flag = 1;
        } catch (Exception e) {
            flag = 0;
        }
        return flag;
    }

    @Override
    public Product selectById(int id) {

        session = HDBconnect.getInstance().getSession();
        Query query = session.createQuery("from Product p where p.idproduct=:id");
        query.setParameter("id", id);
        product = (Product) query.uniqueResult();
        return product;
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

    public List<Product> search(String keyword) {

        session = HDBconnect.getInstance().getSession();

        String hql = "from Product p where productName like :keyword";
//        String keyword = "test";
        Query query = session.createQuery(hql);
        query.setParameter("keyword", "%" + keyword + "%");
        List<Product> productList = (List) query.list();

        return productList;
    }
}
