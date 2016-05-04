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
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Connor
 */
@Entity
@Table(name = "customer", catalog = "outdoorlife", schema = "")
@NamedQueries({
    @NamedQuery(name = "Customer.findAll", query = "SELECT c FROM Customer c"),
    @NamedQuery(name = "Customer.findByCustomerID", query = "SELECT c FROM Customer c WHERE c.customerID = :customerID"),
    @NamedQuery(name = "Customer.findByCompanyName", query = "SELECT c FROM Customer c WHERE c.companyName = :companyName"),
    @NamedQuery(name = "Customer.findByContactName", query = "SELECT c FROM Customer c WHERE c.contactName = :contactName"),
    @NamedQuery(name = "Customer.findByCompanyAddress", query = "SELECT c FROM Customer c WHERE c.companyAddress = :companyAddress"),
    @NamedQuery(name = "Customer.findByCompanyCity", query = "SELECT c FROM Customer c WHERE c.companyCity = :companyCity"),
    @NamedQuery(name = "Customer.findByCompanyPostcode", query = "SELECT c FROM Customer c WHERE c.companyPostcode = :companyPostcode"),
    @NamedQuery(name = "Customer.findByCompanyPhone", query = "SELECT c FROM Customer c WHERE c.companyPhone = :companyPhone")})
    public class Customer extends AbstractTableModel implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "customerID")
    private Integer customerID;
    @Basic(optional = false)
    @Column(name = "companyName")
    private String companyName;
    @Basic(optional = false)
    @Column(name = "contactName")
    private String contactName;
    @Basic(optional = false)
    @Column(name = "companyAddress")
    private String companyAddress;
    @Basic(optional = false)
    @Column(name = "companyCity")
    private String companyCity;
    @Basic(optional = false)
    @Column(name = "companyPostcode")
    private String companyPostcode;
    @Basic(optional = false)
    @Column(name = "companyPhone")
    private String companyPhone;

    public Customer() {
    }

    public Customer(Integer customerID) {
        this.customerID = customerID;
    }

    public Customer(Integer customerID, String companyName, String contactName, String companyAddress, String companyCity, String companyPostcode, String companyPhone) {
        this.customerID = customerID;
        this.companyName = companyName;
        this.contactName = contactName;
        this.companyAddress = companyAddress;
        this.companyCity = companyCity;
        this.companyPostcode = companyPostcode;
        this.companyPhone = companyPhone;
    }

    public Integer getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Integer customerID) {
        Integer oldCustomerID = this.customerID;
        this.customerID = customerID;
        changeSupport.firePropertyChange("customerID", oldCustomerID, customerID);
        fireTableDataChanged();
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        String oldCompanyName = this.companyName;
        this.companyName = companyName;
        changeSupport.firePropertyChange("companyName", oldCompanyName, companyName);
        fireTableDataChanged();
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        String oldContactName = this.contactName;
        this.contactName = contactName;
        changeSupport.firePropertyChange("contactName", oldContactName, contactName);
        fireTableDataChanged();
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        String oldCompanyAddress = this.companyAddress;
        this.companyAddress = companyAddress;
        changeSupport.firePropertyChange("companyAddress", oldCompanyAddress, companyAddress);
        fireTableDataChanged();
    }

    public String getCompanyCity() {
        return companyCity;
    }

    public void setCompanyCity(String companyCity) {
        String oldCompanyCity = this.companyCity;
        this.companyCity = companyCity;
        changeSupport.firePropertyChange("companyCity", oldCompanyCity, companyCity);
        fireTableDataChanged();
    }

    public String getCompanyPostcode() {
        return companyPostcode;
    }

    public void setCompanyPostcode(String companyPostcode) {
        String oldCompanyPostcode = this.companyPostcode;
        this.companyPostcode = companyPostcode;
        changeSupport.firePropertyChange("companyPostcode", oldCompanyPostcode, companyPostcode);
        fireTableDataChanged();
    }

    public String getCompanyPhone() {
        return companyPhone;
    }

    public void setCompanyPhone(String companyPhone) {
        String oldCompanyPhone = this.companyPhone;
        this.companyPhone = companyPhone;
        changeSupport.firePropertyChange("companyPhone", oldCompanyPhone, companyPhone);
        fireTableDataChanged();
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (customerID != null ? customerID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Customer)) {
            return false;
        }
        Customer other = (Customer) object;
        if ((this.customerID == null && other.customerID != null) || (this.customerID != null && !this.customerID.equals(other.customerID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DataGUI.Customer[ customerID=" + customerID + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }

    @Override
    public int getRowCount() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getColumnCount() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
