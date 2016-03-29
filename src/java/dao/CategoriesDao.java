/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Categories;
import java.sql.PreparedStatement;
import java.util.List;
import db.DBconnect;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bakar M.M.R
 */
public class CategoriesDao implements DoaInterface<Categories> {

    PreparedStatement statement;
    Categories cat;

    @Override
    public int insert(Categories bean) {
        //cat = (Categories) bean;
        int check = 0;
        try {
            statement = DBconnect.getInstance().getconn().prepareStatement("insert into categories (idcategory, category_name) values(?,?)");
            statement.setInt(1, bean.getIdcategory());
            statement.setString(2, bean.getCategoryName());
            check = statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CategoriesDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("category inserted " + check);
        return check;
    }

    @Override
    public int update(Categories bean) {
        int check = 0;
        //cat = (Categories) bean;    
        try {
            statement = DBconnect.getInstance().getconn().prepareStatement("update categories set "
                    + "category_name = ? where idcategory = ?");
            statement.setString(1, bean.getCategoryName());
            statement.setInt(2, bean.getIdcategory());
            check = statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CategoriesDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check;
    }

    @Override
    public int delete(Categories bean) {
        int check = 0;
        //cat = (Categories) bean;
        try {
            statement = DBconnect.getInstance().getconn().prepareStatement("delete from categories where idcategory = ?");
            statement.setInt(1, bean.getIdcategory());
            check = statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CategoriesDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check;
    }

    @Override
    public Categories selectById(int id) {
        cat = new Categories();
        try {
            statement = DBconnect.getInstance().getconn().prepareStatement("select * from categories where idcategory = ?");
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                cat.setCategoryName(rs.getString("category_name"));
                cat.setIdcategory(rs.getInt("idcategory"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoriesDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cat;
    }

    @Override
    public Categories selectByName(String name) {
        cat = new Categories();
        try {
            statement = DBconnect.getInstance().getconn().prepareStatement("select * from categories where category_name = ?");
            statement.setString(1, name);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                cat.setCategoryName(rs.getString("category_name"));
                cat.setIdcategory(rs.getInt("idcategory"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoriesDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cat;
    }

    @Override
    public ArrayList<Categories> selectAll() {
        ArrayList<Categories> cats = new ArrayList<>();
        ProductDao dao;
        try {
            statement = DBconnect.getInstance().getconn().prepareStatement("select * from categories");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Categories cat = new Categories();
                cat.setIdcategory(rs.getInt("idcategory"));
                cat.setCategoryName(rs.getString("category_name"));
                dao = new ProductDao();
                cat.setProductCollection(dao.selectProductsByCategoryId(rs.getInt("idcategory")));
                cats.add(cat);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoriesDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cats;
    }
}
