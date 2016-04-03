/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HibernateDao;

import HibernateEntity.Users;
import dao.DoaInterface;
import db.HDBconnect;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Aya
 */
public class HUserDao implements DoaInterface<Users> {
Users user;
        Criteria criteria;
    Session session;

    @Override
    public int insert(Users bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int update(Users bean) {
       int result=0;
        String hql = "UPDATE Users set userAddress = :address ,userMobile= :mobile,userCharge= :charge,userJob= :job,userZip= :zip"
            +" WHERE userEmail = :email";
            Query query = HDBconnect.getInstance().getSession().createQuery(hql)
            .setString("address", bean.getUserAddress())
//            query.setParameter("address", bean.getUserAddress());
            .setString("mobile", bean.getUserMobile())
            .setFloat("charge", bean.getUserCharge())
            .setString("job", bean.getUserJob())
            .setInteger("zip", bean.getUserZip())
            .setString("email", bean.getUserEmail());

             result = query.executeUpdate();
            return result;
    }
      public int update2(Users bean) {
        Transaction transaction = null;
        Session session = HDBconnect.getInstance().getSession();
        try {
            transaction = session.beginTransaction();
            session.update(bean);
            session.getTransaction().commit();
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

    @Override
    public int delete(Users bean) {
        session = HDBconnect.getInstance().getSession();
        session.beginTransaction();
        session.delete(bean);
        int check = 1;
        session.getTransaction().commit(); 
        return check;
    }

    @Override
    public Users selectById(int id) {
        session = HDBconnect.getInstance().getSession();
        String hql = "From Users U where U.idusers=:id";
        Query query = session.createQuery(hql);
        query.setParameter("id", id);
        Users user = (Users) query.uniqueResult();
        return user;
    }

    @Override
    public Users selectByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Users> selectAll() {

        session = HDBconnect.getInstance().getSession();
        Query query = session.createQuery("from Users u");
        List<Users> users = query.list();
        return users;
    }
    public boolean chechMail(String mail) {
        criteria=HDBconnect.getInstance().getSession().createCriteria(Users.class).add(Restrictions.eq("userEmail", mail));
        List result=criteria.list();
        if(result.isEmpty())
            return false;
        return true;
    }
    
    public boolean checkName(String name) {
        criteria=HDBconnect.getInstance().getSession().createCriteria(Users.class).add(Restrictions.eq("userName", name));
        List result=criteria.list();
        if(result.isEmpty())
            return false;
        return true;
    }
   
    public boolean checkSSN(int ssn) {
        criteria=HDBconnect.getInstance().getSession().createCriteria(Users.class).add(Restrictions.eq("userSsn", ssn));
        List result=criteria.list();
        if(result.isEmpty())
            return false;
        return true;
    }
    public Users login(String email,String password)
    {
      //  user=new Users();
//        criteria=HDBconnect.getInstance().getSession().createCriteria(Users.class).
//                add(Restrictions.and(Restrictions.eq("userEmail", email),Restrictions.eq("userPassword", password)));
//        List<Users> result=criteria.list();
//        if(result!=null)
//            return result.get(0);
//        else
//            return null;
         String query="from Users u where u.userEmail=? and u.userPassword=?";
        Query q=HDBconnect.getInstance().getSession().createQuery(query).setEntity(0,email).setEntity(1,password);
//        Query q=session.createQuery(query).;
        List<Users> result=q.list();
        if(result.isEmpty())
            return null ;
        else
            return result.get(0);
    }
}
