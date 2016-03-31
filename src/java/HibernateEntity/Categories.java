package HibernateEntity;
// Generated Mar 31, 2016 9:53:58 AM by Hibernate Tools 4.3.1


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

/**
 * Categories generated by hbm2java
 */
@Entity
@Table(name="categories"
    ,catalog="web_project"
)
public class Categories  implements java.io.Serializable {


     private Integer idcategory;
     private String categoryName;
     private Set userses = new HashSet(0);
     private Set products = new HashSet(0);

    public Categories() {
    }

	
    public Categories(String categoryName) {
        this.categoryName = categoryName;
    }
    public Categories(String categoryName, Set userses, Set products) {
       this.categoryName = categoryName;
       this.userses = userses;
       this.products = products;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="idcategory", unique=true, nullable=false)
    public Integer getIdcategory() {
        return this.idcategory;
    }
    
    public void setIdcategory(Integer idcategory) {
        this.idcategory = idcategory;
    }

    
    @Column(name="category_name", nullable=false, length=45)
    public String getCategoryName() {
        return this.categoryName;
    }
    
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

@ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name="users_interest_categories", catalog="web_project", joinColumns = { 
        @JoinColumn(name="categories_idcategory", nullable=false, updatable=false) }, inverseJoinColumns = { 
        @JoinColumn(name="users_idusers", nullable=false, updatable=false) })
    public Set<Users> getUserses() {
        return this.userses;
    }
    
    public void setUserses(Set userses) {
        this.userses = userses;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="categories")
    public Set<Product> getProducts() {
        return this.products;
    }
    
    public void setProducts(Set products) {
        this.products = products;
    }




}

