/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HibernateDao;

import HibernateEntity.Payment;
import dao.DoaInterface;
import db.HDBconnect;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Ehab
 */
public class HPaymentDao implements DoaInterface<Payment> {

    Session session;

    @Override
    public int insert(Payment bean) {
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
    public int update(Payment bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(Payment bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Payment selectById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Payment selectByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Payment> selectAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Payment> selectAllByID(int id) {
        session = HDBconnect.getInstance().getSession();

        Criteria criteria = session.createCriteria(Payment.class);
        criteria.add(Restrictions.eq("users.idusers", 4));
        List<Payment> result = criteria.list();
        
        if (result.size() > 0) {
            return result;
        } else {
            return null;
        }
    }

    public Payment selectLastPaymentByUserId(int id) {
        session = HDBconnect.getInstance().getSession();

        Criteria criteria = session.createCriteria(Payment.class);
        criteria.add(Restrictions.eq("users.idusers", id));
        criteria.addOrder(Order.desc("paymentDate"));
        criteria.setMaxResults(1);
        Payment result = (Payment) criteria.uniqueResult();
        return result;
    }

}
