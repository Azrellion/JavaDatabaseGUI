/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataGUI;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Connor
 */
@Entity
@Table(name = "product", catalog = "outdoorlife", schema = "")
@NamedQueries({
    @NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p"),
    @NamedQuery(name = "Product.findByProductID", query = "SELECT p FROM Product p WHERE p.productID = :productID"),
    @NamedQuery(name = "Product.findByProductName", query = "SELECT p FROM Product p WHERE p.productName = :productName"),
    @NamedQuery(name = "Product.findBySupplierID", query = "SELECT p FROM Product p WHERE p.supplierID = :supplierID"),
    @NamedQuery(name = "Product.findByCategoryID", query = "SELECT p FROM Product p WHERE p.categoryID = :categoryID"),
    @NamedQuery(name = "Product.findByUnitsInStock", query = "SELECT p FROM Product p WHERE p.unitsInStock = :unitsInStock")})
public class Product implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "productID")
    private Integer productID;
    @Basic(optional = false)
    @Column(name = "productName")
    private String productName;
    @Basic(optional = false)
    @Column(name = "supplierID")
    private int supplierID;
    @Basic(optional = false)
    @Column(name = "categoryID")
    private int categoryID;
    @Basic(optional = false)
    @Column(name = "unitsInStock")
    private int unitsInStock;

    public Product() {
    }

    public Product(Integer productID) {
        this.productID = productID;
    }

    public Product(Integer productID, String productName, int supplierID, int categoryID, int unitsInStock) {
        this.productID = productID;
        this.productName = productName;
        this.supplierID = supplierID;
        this.categoryID = categoryID;
        this.unitsInStock = unitsInStock;
    }

    public Integer getProductID() {
        return productID;
    }

    public void setProductID(Integer productID) {
        Integer oldProductID = this.productID;
        this.productID = productID;
        changeSupport.firePropertyChange("productID", oldProductID, productID);
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        String oldProductName = this.productName;
        this.productName = productName;
        changeSupport.firePropertyChange("productName", oldProductName, productName);
    }

    public int getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(int supplierID) {
        int oldSupplierID = this.supplierID;
        this.supplierID = supplierID;
        changeSupport.firePropertyChange("supplierID", oldSupplierID, supplierID);
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        int oldCategoryID = this.categoryID;
        this.categoryID = categoryID;
        changeSupport.firePropertyChange("categoryID", oldCategoryID, categoryID);
    }

    public int getUnitsInStock() {
        return unitsInStock;
    }

    public void setUnitsInStock(int unitsInStock) {
        int oldUnitsInStock = this.unitsInStock;
        this.unitsInStock = unitsInStock;
        changeSupport.firePropertyChange("unitsInStock", oldUnitsInStock, unitsInStock);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productID != null ? productID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Product)) {
            return false;
        }
        Product other = (Product) object;
        if ((this.productID == null && other.productID != null) || (this.productID != null && !this.productID.equals(other.productID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DataGUI.Product[ productID=" + productID + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
