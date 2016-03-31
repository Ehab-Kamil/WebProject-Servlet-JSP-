package HibernateEntity;
// Generated Mar 31, 2016 9:53:58 AM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 * Users generated by hbm2java
 */
@Entity
@Table(name="users"
    ,catalog="web_project"
    , uniqueConstraints = {@UniqueConstraint(columnNames="user_name"), @UniqueConstraint(columnNames="user_email"), @UniqueConstraint(columnNames="user_ssn")} 
)
public class Users  implements java.io.Serializable {


     private Integer idusers;
     private String userName;
     private String userPassword;
     private String userEmail;
     private String userAddress;
     private String userMobile;
     private int userSsn;
     private Float userCharge;
     private Date userRegdate;
     private String userJob;
     private Integer userZip;
     private Set payments = new HashSet(0);
     private Set categorieses = new HashSet(0);
     private Set cartProducts = new HashSet(0);

    public Users() {
    }

	
    public Users(String userName, String userPassword, String userEmail, int userSsn, Date userRegdate) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.userEmail = userEmail;
        this.userSsn = userSsn;
        this.userRegdate = userRegdate;
    }
    public Users(String userName, String userPassword, String userEmail, String userAddress, String userMobile, int userSsn, Float userCharge, Date userRegdate, String userJob, Integer userZip, Set payments, Set categorieses, Set cartProducts) {
       this.userName = userName;
       this.userPassword = userPassword;
       this.userEmail = userEmail;
       this.userAddress = userAddress;
       this.userMobile = userMobile;
       this.userSsn = userSsn;
       this.userCharge = userCharge;
       this.userRegdate = userRegdate;
       this.userJob = userJob;
       this.userZip = userZip;
       this.payments = payments;
       this.categorieses = categorieses;
       this.cartProducts = cartProducts;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="idusers", unique=true, nullable=false)
    public Integer getIdusers() {
        return this.idusers;
    }
    
    public void setIdusers(Integer idusers) {
        this.idusers = idusers;
    }

    
    @Column(name="user_name", unique=true, nullable=false, length=45)
    public String getUserName() {
        return this.userName;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }

    
    @Column(name="user_password", nullable=false, length=45)
    public String getUserPassword() {
        return this.userPassword;
    }
    
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    
    @Column(name="user_email", unique=true, nullable=false, length=45)
    public String getUserEmail() {
        return this.userEmail;
    }
    
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    
    @Column(name="user_address", length=45)
    public String getUserAddress() {
        return this.userAddress;
    }
    
    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    
    @Column(name="user_mobile", length=45)
    public String getUserMobile() {
        return this.userMobile;
    }
    
    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }

    
    @Column(name="user_ssn", unique=true, nullable=false)
    public int getUserSsn() {
        return this.userSsn;
    }
    
    public void setUserSsn(int userSsn) {
        this.userSsn = userSsn;
    }

    
    @Column(name="user_charge", precision=12, scale=0)
    public Float getUserCharge() {
        return this.userCharge;
    }
    
    public void setUserCharge(Float userCharge) {
        this.userCharge = userCharge;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="user_regdate", nullable=false, length=10)
    public Date getUserRegdate() {
        return this.userRegdate;
    }
    
    public void setUserRegdate(Date userRegdate) {
        this.userRegdate = userRegdate;
    }

    
    @Column(name="user_job", length=45)
    public String getUserJob() {
        return this.userJob;
    }
    
    public void setUserJob(String userJob) {
        this.userJob = userJob;
    }

    
    @Column(name="user_zip")
    public Integer getUserZip() {
        return this.userZip;
    }
    
    public void setUserZip(Integer userZip) {
        this.userZip = userZip;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="users")
    public Set<Payment> getPayments() {
        return this.payments;
    }
    
    public void setPayments(Set payments) {
        this.payments = payments;
    }

@ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name="users_interest_categories", catalog="web_project", joinColumns = { 
        @JoinColumn(name="users_idusers", nullable=false, updatable=false) }, inverseJoinColumns = { 
        @JoinColumn(name="categories_idcategory", nullable=false, updatable=false) })
    public Set<Categories> getCategorieses() {
        return this.categorieses;
    }
    
    public void setCategorieses(Set categorieses) {
        this.categorieses = categorieses;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="users")
    public Set<CartProduct> getCartProducts() {
        return this.cartProducts;
    }
    
    public void setCartProducts(Set cartProducts) {
        this.cartProducts = cartProducts;
    }




}


