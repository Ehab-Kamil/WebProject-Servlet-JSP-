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
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Ehab
 */
public class HCategoriesDao implements DoaInterface<Categories>{

    Session session;
    Categories cat;
    
    
    @Override
    public int insert(Categories bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int update(Categories bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(Categories bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Categories selectById(int id) {
      
        session =HDBconnect.getInstance().getSession();
//        Query query =session.createQuery("from  p wher");
        
    return null ;
    }

    @Override
    public Categories selectByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Categories> selectAll() {
      
        session =HDBconnect.getInstance().getSession();
        Query query =session.createQuery("from Categories c");
        ArrayList<Categories> categoryList = (ArrayList) query.list();
        
        return categoryList;
    }
    
}
