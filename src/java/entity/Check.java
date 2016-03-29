/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Aya Yasser
 */
public class Check {
   boolean checkMail;
   boolean checkName;
   boolean checkSsn;

    public Check() {
    }

    public boolean isCheckMail() {
        return checkMail;
    }

    public void setCheckMail(boolean checkMail) {
        this.checkMail = checkMail;
    }

    public boolean isCheckName() {
        return checkName;
    }

    public void setCheckName(boolean checkName) {
        this.checkName = checkName;
    }

    public boolean isCheckSsn() {
        return checkSsn;
    }

    public void setCheckSsn(boolean checkSsn) {
        this.checkSsn = checkSsn;
    }
   
}
