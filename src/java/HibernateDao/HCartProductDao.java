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
            session.getTransaction().commit();
            ch = 1;
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            ch = 0;
            throw e;
        } finally {
        //    session.close();
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
        } finally {
        //    session.close();
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
        } finally {
        //    session.close();
        }
        return ch;
    }

    @Override
    public CartProduct selectById(int id) {
        session = HDBconnect.getInstance().getSession();
        CartProduct cartProduct = null;
        try {
            session.beginTransaction();
            cartProduct = (CartProduct) session.get(CartProduct.class, id);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }

            throw e;
        } finally {
        //    session.close();
        }
        return cartProduct;
    }

    @Override
    public CartProduct selectByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<CartProduct> selectAll() {
        session = HDBconnect.getInstance().getSession();
        Query query = null;
        try {
            query = session.createQuery("from CartProduct");
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }

            throw e;
        } finally {
        //    session.close();
        }
        return query.list();
    }

    public int deleteAll(Users user) {
        session = HDBconnect.getInstance().getSession();
        Query query = null;
        try {
            query = session.createQuery("delete CartProduct c where c.Users=?").setEntity(0, user);
            query.executeUpdate();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }

            throw e;
        } finally {
        //    session.close();
        }
        return 1;
    }

    public List<CartProduct> selectByUser(Users user) {
        session = HDBconnect.getInstance().getSession();
        List<CartProduct> cpList = null;
        try {
            session.beginTransaction();
            cpList = session.createQuery("from CartProduct c where c.users=? and c.payment is null").setEntity(0, user).list();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }

            throw e;
        } finally {
        //    session.close();
        }
        return cpList;
    }

    public List<CartProduct> selectByPayment(Payment payment) {
        session = HDBconnect.getInstance().getSession();
        List<CartProduct> cpList = null;
        try {
            cpList = session.createQuery("from CartProduct c where p.Payment=?").setEntity(0, payment).list();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }

            throw e;
        } finally {
        //    session.close();
        }
        return cpList;
    }

    public int buy(CartProduct cartProduct) {
        session = HDBconnect.getInstance().getSession();
        session.beginTransaction();
        session.persist(cartProduct.getPayment());
        session.getTransaction().commit();
        update(cartProduct);
        return 1;
    }
}
