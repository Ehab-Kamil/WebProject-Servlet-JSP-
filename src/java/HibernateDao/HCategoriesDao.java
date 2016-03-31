/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HibernateDao;

import dao.DoaInterface;
import HibernateEntity.Categories;
import db.HDBconnect;
import java.util.List;
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
//        session.g
    return null ;
    }

    @Override
    public Categories selectByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Categories> selectAll() {
      
        session =HDBconnect.getInstance().getSession();
        
        
        return null;
    }
    
}
