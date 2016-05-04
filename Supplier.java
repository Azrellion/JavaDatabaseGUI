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
@Table(name = "supplier", catalog = "outdoorlife", schema = "")
@NamedQueries({
    @NamedQuery(name = "Supplier.findAll", query = "SELECT s FROM Supplier s"),
    @NamedQuery(name = "Supplier.findBySupplierID", query = "SELECT s FROM Supplier s WHERE s.supplierID = :supplierID"),
    @NamedQuery(name = "Supplier.findBySupplierName", query = "SELECT s FROM Supplier s WHERE s.supplierName = :supplierName"),
    @NamedQuery(name = "Supplier.findBySupplierAddress", query = "SELECT s FROM Supplier s WHERE s.supplierAddress = :supplierAddress"),
    @NamedQuery(name = "Supplier.findByContactName", query = "SELECT s FROM Supplier s WHERE s.contactName = :contactName"),
    @NamedQuery(name = "Supplier.findBySupplierCity", query = "SELECT s FROM Supplier s WHERE s.supplierCity = :supplierCity"),
    @NamedQuery(name = "Supplier.findBySupplierPostcode", query = "SELECT s FROM Supplier s WHERE s.supplierPostcode = :supplierPostcode"),
    @NamedQuery(name = "Supplier.findBySupplierPhone", query = "SELECT s FROM Supplier s WHERE s.supplierPhone = :supplierPhone")})
public class Supplier implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "supplierID")
    private Integer supplierID;
    @Basic(optional = false)
    @Column(name = "supplierName")
    private String supplierName;
    @Basic(optional = false)
    @Column(name = "supplierAddress")
    private String supplierAddress;
    @Basic(optional = false)
    @Column(name = "contactName")
    private String contactName;
    @Basic(optional = false)
    @Column(name = "supplierCity")
    private String supplierCity;
    @Basic(optional = false)
    @Column(name = "supplierPostcode")
    private String supplierPostcode;
    @Basic(optional = false)
    @Column(name = "supplierPhone")
    private String supplierPhone;

    public Supplier() {
    }

    public Supplier(Integer supplierID) {
        this.supplierID = supplierID;
    }

    public Supplier(Integer supplierID, String supplierName, String supplierAddress, String contactName, String supplierCity, String supplierPostcode, String supplierPhone) {
        this.supplierID = supplierID;
        this.supplierName = supplierName;
        this.supplierAddress = supplierAddress;
        this.contactName = contactName;
        this.supplierCity = supplierCity;
        this.supplierPostcode = supplierPostcode;
        this.supplierPhone = supplierPhone;
    }

    public Integer getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(Integer supplierID) {
        Integer oldSupplierID = this.supplierID;
        this.supplierID = supplierID;
        changeSupport.firePropertyChange("supplierID", oldSupplierID, supplierID);
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        String oldSupplierName = this.supplierName;
        this.supplierName = supplierName;
        changeSupport.firePropertyChange("supplierName", oldSupplierName, supplierName);
    }

    public String getSupplierAddress() {
        return supplierAddress;
    }

    public void setSupplierAddress(String supplierAddress) {
        String oldSupplierAddress = this.supplierAddress;
        this.supplierAddress = supplierAddress;
        changeSupport.firePropertyChange("supplierAddress", oldSupplierAddress, supplierAddress);
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        String oldContactName = this.contactName;
        this.contactName = contactName;
        changeSupport.firePropertyChange("contactName", oldContactName, contactName);
    }

    public String getSupplierCity() {
        return supplierCity;
    }

    public void setSupplierCity(String supplierCity) {
        String oldSupplierCity = this.supplierCity;
        this.supplierCity = supplierCity;
        changeSupport.firePropertyChange("supplierCity", oldSupplierCity, supplierCity);
    }

    public String getSupplierPostcode() {
        return supplierPostcode;
    }

    public void setSupplierPostcode(String supplierPostcode) {
        String oldSupplierPostcode = this.supplierPostcode;
        this.supplierPostcode = supplierPostcode;
        changeSupport.firePropertyChange("supplierPostcode", oldSupplierPostcode, supplierPostcode);
    }

    public String getSupplierPhone() {
        return supplierPhone;
    }

    public void setSupplierPhone(String supplierPhone) {
        String oldSupplierPhone = this.supplierPhone;
        this.supplierPhone = supplierPhone;
        changeSupport.firePropertyChange("supplierPhone", oldSupplierPhone, supplierPhone);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (supplierID != null ? supplierID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Supplier)) {
            return false;
        }
        Supplier other = (Supplier) object;
        if ((this.supplierID == null && other.supplierID != null) || (this.supplierID != null && !this.supplierID.equals(other.supplierID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DataGUI.Supplier[ supplierID=" + supplierID + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
