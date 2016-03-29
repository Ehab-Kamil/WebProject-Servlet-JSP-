/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import db.DBconnect;
import entity.Check;
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
public class UsersDao implements DoaInterface<Users> {

    PreparedStatement statment;
    Users user;

    @Override
    public int insert(Users bean) {
        int check = 0;
        boolean chMail = chechMail(bean.getUserEmail());// true if found
        boolean chName = checkName(bean.getUserName());
        boolean chSSN = checkSSN(bean.getUserSsn());
        if (!chName && !chMail && !chSSN) {
            try {
                statment = DBconnect.getInstance().getconn().prepareStatement("insert into Users"
                        + "(user_name,user_password,user_email,user_ssn,user_charge,user_regdate)"
                        + " values (?,?,?,?,?,?)");
                statment.setString(1, bean.getUserName());
                statment.setString(2, bean.getUserPassword());
                statment.setString(3, bean.getUserEmail());
                statment.setLong(4, bean.getUserSsn());
                statment.setFloat(5, bean.getUserCharge());
                statment.setDate(6, Date.valueOf(LocalDate.now()));
                check = statment.executeUpdate();

                System.out.println("insert" + check);
            } catch (SQLException ex) {
                Logger.getLogger(UsersDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            check = 1;
        } else {
            check = 0;

        }

        return check;
    }

    @Override
    public int update(Users bean) {
        int check = 0;
        try {
            statment = DBconnect.getInstance().getconn().prepareStatement("UPDATE users SET user_address=?,user_mobile=?,user_charge=?,user_job=?,user_zip=? WHERE user_email=?");

            statment.setString(1, bean.getUserAddress());
            statment.setString(2, bean.getUserMobile());
            statment.setDouble(3, bean.getUserCharge());
            statment.setString(4, bean.getUserJob());

            statment.setInt(5, bean.getUserZip());

            // statment.setDate(6, (Date) bean.getUserRegdate());
            statment.setString(6, bean.getUserEmail());

            check = statment.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UsersDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check;
    }

    @Override
    public int delete(Users bean) {
        int check = 0;
        try {
            statment = DBconnect.getInstance().getconn().prepareStatement("delete from users where idusers=?");
            statment.setInt(1, bean.getIdusers());
            check = statment.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UsersDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check;
    }

    @Override
    public Users selectById(int id) {
        user = new Users();
        try {
            statment = DBconnect.getInstance().getconn().prepareStatement("select * from users where idusers=?");
            statment.setInt(1, id);
            ResultSet result = statment.executeQuery();
            if (result.next()) {
                user = new Users();
                user.setIdusers(result.getInt("idusers"));
                user.setUserEmail(result.getString("user_email"));
                user.setUserPassword(result.getString("user_password"));
                user.setUserName(result.getString("user_name"));
                user.setUserSsn(result.getLong("user_ssn"));
                user.setUserCharge(result.getFloat("user_charge"));
                user.setUserAddress(result.getString("user_address"));
                user.setUserMobile((result.getString("user_mobile")));
                user.setUserJob(result.getString("user_job"));
                user.setUserZip(result.getInt("user_zip"));
                user.setUserRegdate(result.getDate("user_regdate"));
                CartProductDao cartProductDao = new CartProductDao();                
                user.setCartProductCollection(cartProductDao.selectByUser(user));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsersDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }

    @Override
    public Users selectByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Users> selectAll() {
        ArrayList<Users> userList = new ArrayList<>();
        try {
            statment = DBconnect.getInstance().getconn().prepareStatement("select * from users");
            ResultSet result = statment.executeQuery();
            while (result.next()) {
                user = new Users();
                user.setIdusers(result.getInt("idusers"));
                user.setUserName(result.getString("user_name"));
                user.setUserPassword(result.getString("user_password"));
                user.setUserEmail(result.getString("user_email"));
                user.setUserAddress(result.getString("user_address"));
                user.setUserMobile(result.getString("user_mobile"));
                user.setUserCharge(result.getFloat("user_charge"));
                user.setUserRegdate(result.getDate("user_regdate"));
                user.setUserJob(result.getString("user_job"));
                user.setUserZip(result.getInt("user_zip"));
                user.setUserSsn(result.getInt("user_ssn"));
                
                CartProductDao cartProductDao = new CartProductDao();                
                user.setCartProductCollection(cartProductDao.selectByUser(user));
                
                userList.add(user);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsersDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return userList;
    }

    public boolean chechMail(String mail) {
        boolean ch = false;
        user = new Users();
        try {
            statment = DBconnect.getInstance().getconn().prepareStatement("select * from users where user_email=?");
            statment.setString(1, mail);
            ResultSet result = statment.executeQuery();
            if (result.next()) {
                user.setIdusers(result.getInt("idusers"));
                user.setUserName(result.getString("user_name"));
                user.setUserPassword(result.getString("user_password"));
                user.setUserEmail(result.getString("user_email"));
                user.setUserAddress(result.getString("user_address"));
                user.setUserMobile(result.getString("user_mobile"));
                user.setUserCharge(result.getFloat("user_charge"));
                user.setUserRegdate(result.getDate("user_regdate"));
                user.setUserJob(result.getString("user_job"));
                user.setUserZip(result.getInt("user_zip"));
                user.setUserSsn(result.getInt("user_ssn"));

                ch = true;
            } else {
                ch = false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsersDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ch;
    }

    public boolean checkName(String name) {

        boolean ch = false;
        user = new Users();
        try {
            statment = DBconnect.getInstance().getconn().prepareStatement("select * from users where user_name=?");
            statment.setString(1, name);

            ResultSet result = statment.executeQuery();
            if (result.next()) {

                user.setIdusers(result.getInt("idusers"));
                user.setUserName(result.getString("user_name"));
                user.setUserPassword(result.getString("user_password"));
                user.setUserEmail(result.getString("user_email"));
                user.setUserAddress(result.getString("user_address"));
                user.setUserMobile(result.getString("user_mobile"));
                user.setUserCharge(result.getFloat("user_charge"));
                user.setUserRegdate(result.getDate("user_regdate"));
                user.setUserJob(result.getString("user_job"));
                user.setUserZip(result.getInt("user_zip"));
                user.setUserSsn(result.getInt("user_ssn"));

                ch = true;
            } else {
                ch = false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsersDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ch;
    }

    public Users login(Users obj) {
        Users user = null;
        try {

            statment = DBconnect.getInstance().getconn().prepareStatement("SELECT * FROM users WHERE user_email=? AND user_password=?");
            statment.setString(1, obj.getUserEmail());
            statment.setString(2, obj.getUserPassword());
            ResultSet rs;
            rs = statment.executeQuery();
            if (rs.next()) {
                user = new Users();
                user.setIdusers(rs.getInt("idusers"));
                user.setUserEmail(rs.getString("user_email"));
                user.setUserPassword(rs.getString("user_password"));
                user.setUserName(rs.getString("user_name"));
                user.setUserSsn(rs.getLong("user_ssn"));
                user.setUserCharge(rs.getFloat("user_charge"));
                user.setUserAddress(rs.getString("user_address"));
                user.setUserMobile((rs.getString("user_mobile")));
                user.setUserJob(rs.getString("user_job"));
                user.setUserZip(rs.getInt("user_zip"));
                user.setUserRegdate(rs.getDate("user_regdate"));
                CartProductDao cartProductDao = new CartProductDao();
                
                user.setCartProductCollection(cartProductDao.selectByUser(user));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsersDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }

    public boolean checkSSN(long userSsn) {
        boolean ch = false;
        user = new Users();
        try {
            statment = DBconnect.getInstance().getconn().prepareStatement("select * from users where user_ssn=?");
            statment.setLong(1, userSsn);
            ResultSet result = statment.executeQuery();
            if (result.next()) {
                user.setIdusers(result.getInt("idusers"));
                user.setUserName(result.getString("user_name"));
                user.setUserPassword(result.getString("user_password"));
                user.setUserEmail(result.getString("user_email"));
                user.setUserAddress(result.getString("user_address"));
                user.setUserMobile(result.getString("user_mobile"));
                user.setUserCharge(result.getFloat("user_charge"));
                user.setUserRegdate(result.getDate("user_regdate"));
                user.setUserJob(result.getString("user_job"));
                user.setUserZip(result.getInt("user_zip"));
                user.setUserSsn(result.getLong("user_ssn"));

                ch = true;
            } else {
                ch = false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsersDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ch;
    }

    public Check checkUser(Users bean) {
        Check check = new Check();
        check.setCheckMail(chechMail(bean.getUserEmail()));
        check.setCheckName(checkName(bean.getUserName()));
        check.setCheckSsn(checkSSN(bean.getUserSsn()));
        return check;
    }
}
