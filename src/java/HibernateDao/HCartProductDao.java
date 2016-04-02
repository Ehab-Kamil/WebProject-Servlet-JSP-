
package HibernateDao;

import HibernateEntity.CartProduct;
import HibernateEntity.Payment;
import HibernateEntity.Users;
import dao.DoaInterface;
import db.HDBconnect;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.HibernateException;

/**
 *
 * @author Ehab
 */
public class HCartProductDao implements DoaInterface<CartProduct> {

    Session session;
    Transaction transaction = null;

    @Override
    public int insert(CartProduct cartProduct) {
        int ch = 0;
        session = HDBconnect.getInstance().getSession();
        try {

            transaction = session.beginTransaction();
            session.persist(cartProduct);
            session.beginTransaction().commit();
            ch = 1;
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            ch = 0;
            throw e;
        }
        return ch;
    }

    @Override
    public int update(CartProduct cartProduct) {
        int ch = 0;
        session = HDBconnect.getInstance().getSession();
        try {
            transaction = session.beginTransaction();
            session.update(cartProduct);
            session.beginTransaction().commit();
            ch = 1;
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            ch = 0;
            throw e;
        }
        return ch;
    }

    @Override
    public int delete(CartProduct cartProduct) {
        int ch = 0;
        session = HDBconnect.getInstance().getSession();
        try {
            transaction = session.beginTransaction();
            session.delete(cartProduct);
            session.beginTransaction().commit();
            ch = 1;
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            ch = 0;
            throw e;
        }
        return ch;
    }

    @Override
    public CartProduct selectById(int id) {
        session = HDBconnect.getInstance().getSession();
        session.beginTransaction();
        CartProduct cartProduct = (CartProduct) session.get(CartProduct.class, id);
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
        Query query = session.createQuery("from CartProduct");
        return query.list();
    }

    public int deleteAll(Users user) {
        session = HDBconnect.getInstance().getSession();
        Query query = session.createQuery("delete CartProduct c where c.Users=?").setEntity(0, user);
        return 1;
    }

    public List<CartProduct> selectByUser(Users user) {
        session = HDBconnect.getInstance().getSession();
        List<CartProduct> cpList = session.createQuery("from CartProduct c where c.Users=? and c.Payment is empty").setEntity(0, user).list();
        return cpList;
    }

    public List<CartProduct> selectByPayment(Payment payment) {
        session = HDBconnect.getInstance().getSession();
        List<CartProduct> cpList = session.createQuery("from CartProduct c where p.Payment=?").setEntity(0, payment).list();
        return cpList;
    }

    public int buy(CartProduct cartProduct) {
        session = HDBconnect.getInstance().getSession();
        session.beginTransaction();
        session.persist(cartProduct.getPayment());
        session.beginTransaction().commit();
        update(cartProduct);
        return 1;
    }
}
