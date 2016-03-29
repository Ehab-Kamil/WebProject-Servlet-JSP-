/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author Bakar M.M.R
 */

public class Payment implements Serializable {
  
    private int idpayment;
    
    private float paymentTotal;
   
    private float paymentDiscount;
   
    private Date paymentDate;
    
    private Users usersIdusers;
    
    private List<CartProduct> cartProductCollection;

    public Payment() {
        paymentTotal=0;
        paymentDiscount=0;
    }

    public Payment(int idpayment) {
        this.idpayment = idpayment;
    }

    public Payment(int idpayment, float paymentTotal, Date paymentDate) {
        this.idpayment = idpayment;
        this.paymentTotal = paymentTotal;
        this.paymentDate = paymentDate;
    }

    public int getIdpayment() {
        return idpayment;
    }

    public void setIdpayment(int idpayment) {
        this.idpayment = idpayment;
    }

    public float getPaymentTotal() {
        return paymentTotal;
    }

    public void setPaymentTotal(float paymentTotal) {
        this.paymentTotal = paymentTotal;
    }

    public Float getPaymentDiscount() {
        return paymentDiscount;
    }

    public void setPaymentDiscount(Float paymentDiscount) {
        this.paymentDiscount = paymentDiscount;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Users getUsersIdusers() {
        return usersIdusers;
    }

    public List<CartProduct> getCartProductCollection() {
        return cartProductCollection;
    }

    public void setCartProductCollection(List<CartProduct> cartProductCollection) {
        this.cartProductCollection = cartProductCollection;
    }

    public void setUsersIdusers(Users usersIdusers) {
        this.usersIdusers = usersIdusers;
    }

}
