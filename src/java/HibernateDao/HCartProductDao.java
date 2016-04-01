/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HibernateDao;

import HibernateEntity.CartProduct;
import HibernateEntity.Users;
import dao.DoaInterface;
import db.HDBconnect;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Query;

/**
 *
 * @author Ehab
 */
public class HCartProductDao implements DoaInterface<CartProduct> {

    Session session;

    @Override
    public int insert(CartProduct bean) {
        session = HDBconnect.getInstance().getSession();
        session.beginTransaction();
        session.persist(bean);
        session.beginTransaction().commit();
        return 1;
    }

    @Override
    public int update(CartProduct bean) {
        session = HDBconnect.getInstance().getSession();
        session.beginTransaction();
        session.merge(bean);
        session.beginTransaction().commit();
        return 1;
    }

    @Override
    public int delete(CartProduct bean) {
        session = HDBconnect.getInstance().getSession();
        session.beginTransaction();
        session.delete(bean);
        session.beginTransaction().commit();
        return 1;
    }

    @Override
    public CartProduct selectById(int id) {
        session = HDBconnect.getInstance().getSession();
        session.beginTransaction();
        CartProduct cartProduct = (CartProduct) session.get(CartProduct.class,id);
        session.beginTransaction().commit();
        return cartProduct;
    }

    @Override
    public CartProduct selectByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<CartProduct> selectAll() {
        session = HDBconnect.getInstance().getSession();
           Query query=session.createQuery("from CartProduct");
           return query.list();
    }
    
    public int deleteAll(Users user){
    
        session = HDBconnect.getInstance().getSession();
           Query query=session.createQuery("delete CartProduct where");
           return 1;
    }
            
    public List<CartProduct> selectByUser(Users user){

        session = HDBconnect.getInstance().getSession();
        List<CartProduct> cpList= session.createQuery("from CartProduct p where ? member of p.Users").setEntity(0, user).list();
        return cpList;
    }
}
