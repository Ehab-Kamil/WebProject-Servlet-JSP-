/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Ehab
 */
public class HDBconnect {
    
    private static HDBconnect hdb;
    private Session session;
    
    private HDBconnect(){
    
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        session = sessionFactory.openSession();
    }
    
    public static HDBconnect getInstance(){
    
        if(hdb==null){
            hdb = new HDBconnect();
        }
        return hdb;
    }
    
    public Session getSession(){
        
        return session;
    }
    
}
