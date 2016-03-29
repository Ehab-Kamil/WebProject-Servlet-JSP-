/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import db.DBconnect;
import entity.Product;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bakar M.M.R
 */
public class ProductDao implements DoaInterface<Product>{

    PreparedStatement statment;
    Product product;

    
    @Override
    public int insert(Product bean) {
      int check = 0;
        try {
            
            statment = DBconnect.getInstance().getconn().prepareStatement("insert into product"
                    + "(categories_idcategory,idproduct,product_count,product_description,product_img,product_lastmodify,product_name,product_options,product_price,product_quntityavailable,product_quntitysold)"
                    + " values (?,?,?,?,?,?,?,?,?,?,?)");
            
            statment.setInt(1,bean.getCategoriesIdcategory());
            statment.setInt(2,bean.getIdproduct());
            statment.setInt(3,bean.getProductCount() );
            statment.setString(4,bean.getProductDescription());
            statment.setString(5,bean.getProductImg());
            statment.setDate(6,Date.valueOf(LocalDate.now()));
            statment.setString(7,bean.getProductName());
            statment.setString(8,bean.getProductOptions());
            statment.setFloat(9,bean.getProductPrice());
            statment.setInt(10,bean.getProductQuntityavailable());
            statment.setInt(11,bean.getProductQuntitysold());
            
            check = statment.executeUpdate();
            
            System.out.println("insert"+check);
        } catch (SQLException ex) {
            Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check;
    }

    @Override
    public int update(Product bean) {
        int check = 0;
        try {
            
          statment = DBconnect.getInstance().getconn().prepareStatement("update product set product_description=?,product_lastmodify=?,product_name=?,product_price=?,product_quntityavailable=?"
                    + " where idproduct=?");
            
            statment.setString(1,bean.getProductDescription());
            statment.setDate(2,Date.valueOf(LocalDate.now()));
            statment.setString(3,bean.getProductName());
            statment.setFloat(4,bean.getProductPrice());
            statment.setInt(5,bean.getProductQuntityavailable());
            statment.setInt(6,bean.getIdproduct());
            
           check= statment.executeUpdate();
            
            System.out.println("Update"+bean.getIdproduct());
        } catch (SQLException ex) {
            Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check;
    
             }

    @Override
    public int delete(Product bean) {
       int check = 0;
        
        try {
            statment = DBconnect.getInstance().getconn().prepareStatement("delete from product where idproduct=?");
            statment.setInt(1, bean.getIdproduct());
            
            check = statment.executeUpdate();
            
            System.out.println("Delete"+check);
        } catch (SQLException ex) {
            Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check;
    }

    @Override
    public Product selectById(int id) {
       product = new Product();
       
        try {
            statment = DBconnect.getInstance().getconn().prepareStatement("select * from product where idproduct=?");
            statment.setInt(1, id);
            ResultSet result = statment.executeQuery();
            if (result.next()) {
                    product.setIdproduct(id);
                    product.setCategoriesIdcategory(result.getInt("categories_idcategory"));
                    product.setProductCount(result.getInt("product_count"));
                    product.setProductDescription(result.getString("product_description"));
                    product.setProductImg(result.getString("product_img"));
                    product.setProductLastmodify(result.getDate("product_lastmodify"));
                    product.setProductName(result.getString("product_name"));
                    product.setProductOptions(result.getString("product_options"));
                    product.setProductPrice(result.getFloat("product_price"));
                    product.setProductQuntityavailable(result.getInt("product_quntityavailable"));
                    product.setProductQuntitysold(result.getInt("product_quntitysold"));
                    
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return product; 
    }

    @Override
    public Product selectByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    @Override
    public List selectAll() {
        ArrayList<Product> productList = new ArrayList<>();
        try {
            statment = DBconnect.getInstance().getconn().prepareStatement("select * from product ");
           // statment.setInt(1, id);
            ResultSet result = statment.executeQuery();
            while(result.next()) {
                    product = new Product(); 
                   
                    product.setCategoriesIdcategory(result.getInt("categories_idcategory"));
                    product.setIdproduct(result.getInt("idproduct"));
                    product.setProductCount(result.getInt("product_count"));
                    product.setProductDescription(result.getString("product_description"));
                    product.setProductImg(result.getString("product_img"));
                    product.setProductLastmodify(result.getDate("product_lastmodify"));
                    product.setProductName(result.getString("product_name"));
                    product.setProductOptions(result.getString("product_options"));
                    product.setProductPrice(result.getFloat("product_price"));
                    product.setProductQuntityavailable(result.getInt("product_quntityavailable"));
                    product.setProductQuntitysold(result.getInt("product_quntitysold"));
                    productList.add(product);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    return productList;
    }
    
    public ArrayList selectProductsByCategoryId(int id){
        ArrayList<Product> productList = new ArrayList<>();
        try {
            statment = DBconnect.getInstance().getconn().prepareStatement("select * from product where categories_idcategory=?");
            statment.setInt(1, id);
            ResultSet result = statment.executeQuery();
            while(result.next()) {
                    product = new Product(); 
                    
                    product.setCategoriesIdcategory(result.getInt("categories_idcategory"));
                    product.setIdproduct(result.getInt("idproduct"));
                    product.setProductCount(result.getInt("product_count"));
                    product.setProductDescription(result.getString("product_description"));
                    product.setProductImg(result.getString("product_img"));
                    product.setProductLastmodify(result.getDate("product_lastmodify"));
                    product.setProductName(result.getString("product_name"));
                    product.setProductOptions(result.getString("product_options"));
                    product.setProductPrice(result.getFloat("product_price"));
                    product.setProductQuntityavailable(result.getInt("product_quntityavailable"));
                    product.setProductQuntitysold(result.getInt("product_quntitysold"));
                    productList.add(product);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    return productList;
    
    }
    
     public List searchByName(String name) {
        ArrayList<Product> productList = new ArrayList<>();
        try {
            statment = DBconnect.getInstance().getconn().prepareStatement("select * from product where product_name like '%"+name+"%'");
         //   statment.setString(1, name);
            ResultSet result = statment.executeQuery();
            while(result.next()) {
                    product = new Product(); 
                    product.setCategoriesIdcategory(result.getInt("categories_idcategory"));
                    product.setIdproduct(result.getInt("idproduct"));
                   product.setProductCount(result.getInt("product_count"));
                    product.setProductDescription(result.getString("product_description"));
                    product.setProductImg(result.getString("product_img"));
                    product.setProductLastmodify(result.getDate("product_lastmodify"));
                    product.setProductName(result.getString("product_name"));
                    product.setProductOptions(result.getString("product_options"));
                    product.setProductPrice(result.getFloat("product_price"));
                    product.setProductQuntityavailable(result.getInt("product_quntityavailable"));
                    product.setProductQuntitysold(result.getInt("product_quntitysold"));
                    productList.add(product);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
        }
   
        return productList;
    }
    
}
