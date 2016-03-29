/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import db.DBconnect;
import entity.Payment;
import entity.*;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bakar M.M.R
 */
public class PaymentDao implements DoaInterface<Payment> {

    PreparedStatement statment;
    Payment payment;
//SELECT * FROM `payment` WHERe users_idusers=1 ORDER BY payment_date DESC

    @Override
    public int insert(Payment bean) {
        int check = 0;
        try {
            statment = DBconnect.getInstance().getconn().prepareStatement("INSERT INTO payment"
                    + "(payment_total, payment_discount, payment_date,users_idusers)"
                    + " values (?,?,?,?)");
            statment.setFloat(1, bean.getPaymentTotal());
            statment.setFloat(2, bean.getPaymentDiscount());
            statment.setDate(3, bean.getPaymentDate());
            statment.setInt(4, bean.getUsersIdusers().getIdusers());
            check = statment.executeUpdate();
            System.out.println("insert" + check);
            CartProductDao cartProductDao = new CartProductDao();
            for (int i = 0; i < bean.getCartProductCollection().size(); i++) {
                check = cartProductDao.insert(bean.getCartProductCollection().get(i));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PaymentDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check;
    }

    @Override
    public int update(Payment bean) {
        int check = 0;
        try {
            statment = DBconnect.getInstance().getconn().prepareStatement("UPDATE `payment` SET `idpayment`=?,"
                    + "`payment_total`=?,`payment_discount`=?,"
                    + "`payment_date`=? WHERE idpayment =?");

            statment.setInt(1, bean.getIdpayment());
            statment.setFloat(2, bean.getPaymentTotal());
            statment.setFloat(3, bean.getPaymentDiscount());
            statment.setDate(4, bean.getPaymentDate());
            statment.setInt(5, bean.getIdpayment());
            check = statment.executeUpdate();

            CartProductDao cartProductDao = new CartProductDao();
            for (int i = 0; i < bean.getCartProductCollection().size(); i++) {
                check = cartProductDao.update(bean.getCartProductCollection().get(i));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsersDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check;
    }

    @Override
    public int delete(Payment bean) {
        int check = 0;
        try {
            statment = DBconnect.getInstance().getconn().prepareStatement("delete from payment where idusers=?");
            statment.setInt(1, bean.getIdpayment());
            check = statment.executeUpdate();
            CartProductDao cartProductDao = new CartProductDao();
            for (int i = 0; i < bean.getCartProductCollection().size(); i++) {
                check = cartProductDao.delete(bean.getCartProductCollection().get(i));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PaymentDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check;
    }

    public Payment selectLastPaymentByUserId(int id) {

        List<CartProduct> cartProductList = new ArrayList<>();
        payment = new Payment();
        Product product;
        CartProduct cartProduct;
        Date lastPaymentDate = null;
        int count = 0;

        String stat = "SELECT product.product_name , "
                + "product.product_price , "
                + "cart_product.cart_product_mount, payment.payment_total,"
                + " payment.payment_discount,payment.payment_date,"
                + " payment.idpayment from product, cart_product, payment "
                + "where cart_product.product_idproduct = product.idproduct "
                + "and cart_product.payment_idpayment=payment.idpayment"
                + " and payment.users_idusers=? ORDER BY payment_date DESC";
        try {
            statment = DBconnect.getInstance().getconn().prepareStatement(stat);
            statment.setInt(1, id);
            ResultSet result = statment.executeQuery();
            while (result.next()) {
                if (count == 0) {
                    //payment = new Payment();
                    payment.setIdpayment(result.getInt("idpayment"));
                    System.out.println("#################  ## " + result.getFloat("payment_discount"));
                    payment.setPaymentTotal(result.getInt("payment_total"));
                    payment.setPaymentDiscount(result.getFloat("payment_discount"));
                    payment.setPaymentDate(result.getDate("payment_date"));
                    lastPaymentDate = result.getDate("payment_date");
                    //paymentList.add(payment);
                }
                if (lastPaymentDate.equals(result.getDate("payment_date"))) {
                    product = new Product();
                    product.setProductName(result.getString("product_name"));
                    product.setProductPrice(result.getFloat("product_price"));
                    cartProduct = new CartProduct();
                    cartProduct.setProduct(product);
                    cartProduct.setCartProductMount(result.getInt("cart_product_mount"));
                    cartProductList.add(cartProduct);
                    count++;
                } else {
                    break;
                }
            }
            payment.setCartProductCollection(cartProductList);
        } catch (SQLException ex) {
            Logger.getLogger(PaymentDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return payment;
    }

    @Override
    public Payment selectById(int id) {
        return null;
    }

    @Override
    public Payment selectByName(String name) {
        return null;
    }

    @Override
    public List<Payment> selectAll() {
        return null;
    }
    /* @Override
    public Payment selectById(int id) {
        payment = new Payment();
        try {

            statment = DBconnect.getInstance().getconn().prepareStatement("SELECT * FROM `payment` WHERE idpayment=?");
            statment.setInt(1, id);
            ResultSet result = statment.executeQuery();
            if (result.next()) {

                payment.setIdpayment(result.getInt("idpayment"));
                payment.setPaymentTotal(result.getInt("payment_total"));
                payment.setPaymentDiscount(result.getFloat("payment_discount"));
                payment.setPaymentDate(result.getDate("payment_date"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(PaymentDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return payment;
    }

    @Override
    public Payment selectByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Payment> selectAll() {
        List<Payment> paymentList = new ArrayList<>();
        try {
            statment = DBconnect.getInstance().getconn().prepareStatement("select * from payment");
            ResultSet result = statment.executeQuery();
            while (result.next()) {
                payment = new Payment();
                payment.setIdpayment(result.getInt("idpayment"));
                payment.setPaymentTotal(result.getInt("payment_total"));
                payment.setPaymentDiscount(result.getFloat("payment_discount"));
                payment.setPaymentDate(result.getDate("payment_date"));
                paymentList.add(payment);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PaymentDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return paymentList;
    }
    public List<Payment> selectByUserId(int id) {
        List<Payment> paymentList = new ArrayList<>();
        try {
            statment = DBconnect.getInstance().getconn().prepareStatement("SELECT * FROM `payment` WHERE users_idusers=?");
            statment.setInt(1, id);
            ResultSet result = statment.executeQuery();
            while (result.next()) {
                payment = new Payment();
                payment.setIdpayment(result.getInt("idpayment"));
                payment.setPaymentTotal(result.getInt("payment_total"));
                payment.setPaymentDiscount(result.getFloat("payment_discount"));
                payment.setPaymentDate(result.getDate("payment_date"));
                paymentList.add(payment);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PaymentDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return paymentList;
    }
    
   
     */

    Payment selectLastByUser(Users usersIdusers) {
                payment = new Payment();
        try {
            statment = DBconnect.getInstance().getconn().prepareStatement("SELECT * FROM payment"
                    + " WHERE idpayment="
                    + "(select max(idpayment) from  web_project.payment where users_idusers=?)");
            statment.setInt(1, usersIdusers.getIdusers());
            ResultSet result = statment.executeQuery();
            if (result.next()) {
                payment.setIdpayment(result.getInt("idpayment"));
                payment.setPaymentTotal(result.getInt("payment_total"));
                payment.setPaymentDiscount(result.getFloat("payment_discount"));
                payment.setPaymentDate(result.getDate("payment_date"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(PaymentDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return payment;

    }

  public int insertBuy(Payment paymentIdpayment) {
        int check = 0;
        try {
            statment = DBconnect.getInstance().getconn().prepareStatement("INSERT INTO payment"
                    + "(payment_total, payment_discount, payment_date,users_idusers)"
                    + " values (?,?,?,?)");
            statment.setFloat(1, paymentIdpayment.getPaymentTotal());
            statment.setFloat(2, paymentIdpayment.getPaymentDiscount());
            statment.setDate(3, paymentIdpayment.getPaymentDate());
            statment.setInt(4, paymentIdpayment.getUsersIdusers().getIdusers());
            check = statment.executeUpdate();
            System.out.println("insert" + check);            
        } catch (SQLException ex) {
            Logger.getLogger(PaymentDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check;
    }
}
