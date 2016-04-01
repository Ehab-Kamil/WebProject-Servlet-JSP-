/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import db.DBconnect;
import entity.CartProduct;
import entity.Payment;
import entity.Product;
import entity.Users;
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
public class CartProductDao implements DoaInterface<CartProduct> {

    PreparedStatement statment;
    CartProduct cartProduct;

    @Override
    public int insert(CartProduct bean) {
        int check = 0;
        try {
            statment = DBconnect.getInstance().getconn().prepareStatement("insert into cart_product"
                    + "(cart_product_mount,cart_product_date,"
                    + "product_idproduct,users_idusers,"
                    + "product_color,product_size)"
                    + " values (?,?,?,?,?,?)");
            statment.setInt(1, bean.getCartProductMount());
            statment.setDate(2, Date.valueOf(LocalDate.now()));
            statment.setInt(3, bean.getProduct().getIdproduct());
            statment.setFloat(4, bean.getUsersIdusers().getIdusers());
            statment.setString(5, bean.getProductColor());
            statment.setString(6, bean.getProductsize());
            check = statment.executeUpdate();
           System.out.println("insert" + check);
        } catch (SQLException ex) {
            Logger.getLogger(UsersDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check;
    }

    @Override
    public int update(CartProduct bean) {
        int check = 0;
        try {
            statment = DBconnect.getInstance().getconn().prepareStatement("update cart_peoduct set cart_peoduct_mount=?"
                    + ",cart_peoduct_date=?"
                    + ",payment_idpayment=?,product_idproduct=?,users_idusers=?"
                    + ",producr_color=?,product_size=?"
                    + " where idcart_product=?");
            statment.setInt(1, bean.getCartProductMount());
            statment.setDate(2, Date.valueOf(LocalDate.now()));
            statment.setInt(3, bean.getPaymentIdpayment().getIdpayment());
            statment.setInt(4, bean.getProduct().getIdproduct());
            statment.setFloat(5, bean.getUsersIdusers().getIdusers());
            statment.setString(6, bean.getProductColor());
            statment.setString(7, bean.getProductsize());
            statment.setInt(8, bean.getIdcartProduct());
            check = statment.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UsersDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check;
    }

    @Override
    public int delete(CartProduct bean) {
        int check = 0;
        try {
            statment = DBconnect.getInstance().getconn().prepareStatement("delete from cart_product where idcart_product=?");
            statment.setInt(1, bean.getIdcartProduct());
            check = statment.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UsersDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check;
    }

    public int deleteAll(int idUser) {
        int check = 0;
        try {
            statment = DBconnect.getInstance().getconn().prepareStatement("delete from cart_product where users_idusers=?");
            statment.setInt(1, idUser);
            check = statment.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UsersDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check;
    }

    @Override
    public CartProduct selectById(int id) {
        DoaInterface doaInterface;

        CartProduct cartProduct = new CartProduct();
        try {
            statment = DBconnect.getInstance().getconn().prepareStatement("select * from cart_product where idcart_product=?");
            statment.setInt(1, id);
            ResultSet result = statment.executeQuery();
            if (result.next()) {
                cartProduct.setIdcartProduct(result.getInt("idcart_product"));
                cartProduct.setCartProductDate(result.getDate("cart_product_date"));
                cartProduct.setCartProductMount(result.getInt("cart_product_mount"));

                Payment payment = new Payment();
                doaInterface = new PaymentDao();
                payment = (Payment) doaInterface.selectById(result.getInt("payment_idpayment"));

                Product product = new Product();
                doaInterface = new ProductDao();
                product = (Product) doaInterface.selectById(result.getInt("product_idproduct"));

                cartProduct.setPaymentIdpayment(payment);
                cartProduct.setProduct(product);
                cartProduct.setProductColor(result.getString("product_color"));
                cartProduct.setProductsize(result.getString("product_color"));

                float total = product.getProductPrice() * cartProduct.getCartProductMount();

                cartProduct.setTotalProduct(total);

                UsersDao usersDao = new UsersDao();
                Users u = new Users();
                u = usersDao.selectById(result.getInt("users_idusers"));

                cartProduct.setUsersIdusers(u);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsersDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cartProduct;
    }

    @Override
    public CartProduct selectByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<CartProduct> selectAll() {
        ArrayList<CartProduct> cartProductList = new ArrayList<>();
        DoaInterface doaInterface;
        try {
            statment = DBconnect.getInstance().getconn().prepareStatement("select * from cart_peoduct");
            ResultSet result = statment.executeQuery();
            while (result.next()) {

                cartProduct = new CartProduct();
                cartProduct.setIdcartProduct(result.getInt("idcart_product"));
                cartProduct.setCartProductDate(result.getDate("cart_product_date"));
                cartProduct.setCartProductMount(result.getInt("cart_product_mount"));

                Payment payment = new Payment();
                doaInterface = new PaymentDao();
                payment = (Payment) doaInterface.selectById(result.getInt("payment_idpayment"));

                Product product = new Product();
                doaInterface = new ProductDao();
                product = (Product) doaInterface.selectById(result.getInt("product_idproduct"));

                cartProduct.setPaymentIdpayment(payment);
                cartProduct.setProduct(product);
                cartProduct.setProductColor(result.getString("product_color"));
                cartProduct.setProductsize(result.getString("product_color"));

                float total = product.getProductPrice() * cartProduct.getCartProductMount();

                cartProduct.setTotalProduct(total);

                doaInterface = new UsersDao();
                Users u = new Users();
                u = (Users) doaInterface.selectById(result.getInt("users_idusers"));

                cartProduct.setUsersIdusers(u);

                cartProductList.add(cartProduct);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsersDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cartProductList;
    }

    public ArrayList<CartProduct> selectByUser(Users user) {
        ArrayList<CartProduct> cartProductList = new ArrayList<>();
        DoaInterface doaInterface;
        try {
            statment = DBconnect.getInstance().getconn().prepareStatement("select * from cart_product"
                    + " where users_idusers=? and payment_idpayment is NULL");
            statment.setInt(1, user.getIdusers());
            ResultSet result = statment.executeQuery();
            while (result.next()) {
                cartProduct = new CartProduct();
                cartProduct.setIdcartProduct(result.getInt("idcart_product"));
                cartProduct.setCartProductDate(result.getDate("cart_product_date"));
                cartProduct.setCartProductMount(result.getInt("cart_product_mount"));

                /*    Payment payment = new Payment();
                 doaInterface = new PaymentDao();
                 payment = (Payment) doaInterface.selectById(result.getInt("payment_idpayment"));*/
             //   cartProduct.setPaymentIdpayment(payment);
                Product product = new Product();
                doaInterface = new ProductDao();
                product = (Product) doaInterface.selectById(result.getInt("product_idproduct"));

                cartProduct.setProduct(product);
                cartProduct.setProductColor(result.getString("product_color"));
                cartProduct.setProductsize(result.getString("product_color"));

                float total = product.getProductPrice() * cartProduct.getCartProductMount();

                cartProduct.setTotalProduct(total);
                /*
                 UsersDao usersDao = new UsersDao();
                 Users u = new Users();
                 u = usersDao.selectById(result.getInt("users_idusers"));
                 */
                cartProduct.setUsersIdusers(user);
                cartProductList.add(cartProduct);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsersDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cartProductList;
    }

    public ArrayList<CartProduct> selectByPayment(Payment payment) {
        ArrayList<CartProduct> cartProductList = new ArrayList<>();
        DoaInterface doaInterface;
        try {
            statment = DBconnect.getInstance().getconn().prepareStatement("select * from cart_peoduct"
                    + " where payment_idpayment");
            statment.setInt(1, payment.getIdpayment());
            ResultSet result = statment.executeQuery();
            while (result.next()) {
                cartProduct = new CartProduct();
                cartProduct.setIdcartProduct(result.getInt("idcart_product"));
                cartProduct.setCartProductDate(result.getDate("cart_product_date"));
                cartProduct.setCartProductMount(result.getInt("cart_product_mount"));
                /* Payment payment = new Payment();
                 doaInterface = new PaymentDao();
                 payment = (Payment) doaInterface.selectById(result.getInt("payment_idpayment"));*/
                Product product = new Product();
                doaInterface = new ProductDao();
                product = (Product) doaInterface.selectById(result.getInt("product_idproduct"));
                cartProduct.setPaymentIdpayment(payment);
                cartProduct.setProduct(product);
                cartProduct.setProductColor(result.getString("product_color"));
                cartProduct.setProductsize(result.getString("product_color"));
                float total = product.getProductPrice() * cartProduct.getCartProductMount();
                cartProduct.setTotalProduct(total);
                /* UsersDao usersDao = new UsersDao();
                 Users u = new Users();
                 u = usersDao.selectById(result.getInt("users_idusers"));*/
//                cartProduct.setUsersIdusers(user);
                cartProductList.add(cartProduct);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsersDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cartProductList;
    }

    public float sumCart(int idUser) {
        float sum = 0;
        try {
            statment = DBconnect.getInstance().getconn().prepareStatement("select sum(select product_price*cart_product_mount "
                    + "from product,cart_product"
                    + " where idproduct=product_idproduct) from cart_product"
                    + "where users_idusers=?");
            statment.setInt(1, idUser);
            ResultSet result = statment.executeQuery();
            if (result.next()) {
                sum = result.getFloat(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsersDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sum;
    }

    public int buyProduct(CartProduct cartProduct) {
        int check = 0;
        try {
            
            PaymentDao paymentDao = new PaymentDao();
            paymentDao.insertBuy(cartProduct.getPaymentIdpayment());
            
            Payment payment = paymentDao.selectLastByUser(cartProduct.getUsersIdusers());
            
            statment = DBconnect.getInstance().getconn().prepareStatement("UPDATE cart_product SET payment_idpayment=? where idcart_product=?");
            statment.setInt(1, payment.getIdpayment());
            statment.setInt(2, cartProduct.getIdcartProduct());
            
            check = statment.executeUpdate();
            
             ProductDao  productDao= new ProductDao();
             Product product=cartProduct.getProduct();
             product.setProductQuntityavailable(product.getProductQuntityavailable()-cartProduct.getCartProductMount());
             productDao.update(product);
            
             Users user=cartProduct.getUsersIdusers();
             System.out.println(user.getUserName());
             user.setUserCharge(user.getUserCharge() - cartProduct.getTotalProduct());
             UsersDao usersDao=new  UsersDao();
            check = usersDao.update(user);
             
        } catch (SQLException ex) {
            Logger.getLogger(UsersDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check;

    }

}
