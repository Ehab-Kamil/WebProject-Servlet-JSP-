/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HibernateDao;

import dao.DoaInterface;
import HibernateEntity.Categories;
import db.HDBconnect;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Ehab
 */
public class HCategoriesDao implements DoaInterface<Categories> {

    Session session;
    Categories cat;

    @Override
    public int insert(Categories bean) {
        session = HDBconnect.getInstance().getSession();
        session.beginTransaction();
        session.persist(bean);
        session.getTransaction().commit();
        return 0;
    }

    @Override
    public int update(Categories bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(Categories bean) {
        session = HDBconnect.getInstance().getSession();
        try {
            session.getTransaction().begin();
            session.delete(bean);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        finally{
          //  session.close();
        }
        
        return 0;
    }

    @Override
    public Categories selectById(int id) {
        session = HDBconnect.getInstance().getSession();
        session.beginTransaction();
        Categories category = (Categories) session.createQuery("from  Categories c where c.idcategory = :id").setParameter("id", id).uniqueResult();
        session.getTransaction().commit();
        return category;
    }

    @Override
    public Categories selectByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Categories> selectAll() {

       session = HDBconnect.getInstance().getSession();
        session.beginTransaction();
        Query query = session.createQuery("from Categories c");
        ArrayList<Categories> categoryList = (ArrayList) query.list();
        session.getTransaction().commit();
        return categoryList;
    }

}
