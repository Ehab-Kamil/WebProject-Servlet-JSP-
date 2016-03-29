/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.sql.Date;
//import java.util.Date;

import java.util.List;

/**
 *
 * @author Bakar M.M.R
 */

public class Users {

    private int idusers;

    private String userName;

    private String userPassword;

    private String userEmail;

    private String userAddress;

    private String userMobile;

    private long userSsn;
 
    private Float userCharge;
  
    private Date userRegdate;

    private String userJob;

    private int userZip;

    private List<Payment> paymentCollection;

    private List<CartProduct> cartProductCollection;

    public Users() {
    }

    public int getIdusers() {
        return idusers;
    }

    public void setIdusers(int idusers) {
        this.idusers = idusers;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }

      public long getUserSsn() {
        return userSsn;
    }

    public void setUserSsn(long userSsn) {
        this.userSsn = userSsn;
    }

    public Float getUserCharge() {
        return userCharge;
    }

    public void setUserCharge(Float userCharge) {
        this.userCharge = userCharge;
    }

    public Date getUserRegdate() {
        return userRegdate;
    }

    public void setUserRegdate(Date userRegdate) {
        this.userRegdate = userRegdate;
    }

    public String getUserJob() {
        return userJob;
    }

    public void setUserJob(String userJob) {
        this.userJob = userJob;
    }

    public int getUserZip() {
        return userZip;
    }

    public void setUserZip(int userZip) {
        this.userZip = userZip;
    }

    public List<Payment> getPaymentCollection() {
        return paymentCollection;
    }

    public void setPaymentCollection(List<Payment> paymentCollection) {
        this.paymentCollection = paymentCollection;
    }

    public List<CartProduct> getCartProductCollection() {
        return cartProductCollection;
    }

    public void setCartProductCollection(List<CartProduct> cartProductCollection) {
        this.cartProductCollection = cartProductCollection;
    }

}
