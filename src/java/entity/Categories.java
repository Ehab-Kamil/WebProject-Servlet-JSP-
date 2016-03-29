/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Collection;
import java.util.List;

/**
 *
 * @author Bakar M.M.R
 */

public class Categories {

    public List<Product> getProductCollection() {
        return productCollection;
    }

    public void setProductCollection(List<Product> productCollection) {
        this.productCollection = productCollection;
    }
   
    private int idcategory;
   
    private String categoryName;
  
    private List<Product> productCollection;

    public Categories() {
    }

    public Categories(int idcategory) {
        this.idcategory = idcategory;
    }

    public Categories(int idcategory, String categoryName) {
        this.idcategory = idcategory;
        this.categoryName = categoryName;
    }

    public int getIdcategory() {
        return idcategory;
    }

    public void setIdcategory(int idcategory) {
        this.idcategory = idcategory;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }


}
