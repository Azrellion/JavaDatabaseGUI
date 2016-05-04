/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataGUI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

/**
 *
 * @author Connor Sidwell
 */
public class DBMnger {
    private Connection Connect;
    private ResultSet Result;
    private String dbServer;
    private String dbUser;
    private String dbPass;
    private String dbDriver;
    private Statement statement;
    
    /**
     * Constructor
     */
    
public DBMnger() {
    //Setting the Driver to the Service Driver
    dbDriver = "com.mysql.jdbc.Driver";
    //Setting the server to the Service Server - Change this to your Database IP and Name
    dbServer = "jdbc:mysql://localhost:3306/outdoorlife";
    //Setting the Database Username - Change this to your Database Username
    dbUser = "root";
    //Setting the Database Password - Change this to your Database Password
    dbPass = "";
    
    //Try Catch error handling for connecting to the database using the credentials above
    try {
        Class.forName(dbDriver);
    }
    catch (ClassNotFoundException CNFE){
        System.err.println(CNFE.getMessage());
    }
    try {
        Connect = DriverManager.getConnection(dbServer,dbUser,dbPass);
        
    }
    catch(SQLException SQLX)
            {
                System.err.println("Unable to Connect to the Database: " + SQLX.getMessage());
            }
}

/**
 * @param dbDriver
 * @param dbServer
 * @param dbUser
 * @param dbPass
 */
public DBMnger(String dbDriver, String dbServer, String dbUser, String dbPass){
   
    //Error handling for connecting to the database.
    this.dbDriver = dbDriver;
    this.dbServer = dbServer;
    this.dbUser = dbUser;
    this.dbPass = dbPass;
    
    try{
        Class.forName(dbDriver);
    }
    catch (ClassNotFoundException CNFE)
    {
        System.err.println(CNFE.getMessage());
    }
    try {
        Connect = DriverManager.getConnection(dbServer,dbUser,dbPass);
    }
    catch(SQLException SQLX){
        System.err.println("Unable to connect to the database" + SQLX.getMessage());
    }
    
}

/**
 * @param tblName
 * @return Result
 */
public ResultSet selectMessage(String tblName) {
    
        try {
            statement = Connect.createStatement();
            Result = statement
                    .executeQuery("SELECT * FROM " + tblName);
        } catch (SQLException sqlx) {
            System.err.println(sqlx.getMessage());
        }
        return Result;
    }

 /**
     *
     * @param cusName
     * @param cusContact
     * @param cusAddress
     * @param cusCity
     * @param cusPostcode
     * @param cusPhone
     */
    //The void expects the variables to retrieve data from the method
     public void addCust(String cusContact, String cusName, String cusAddress, String cusCity, String cusPostcode, String cusPhone) {
        //Add Customer code that inserts everything into customer from the GUI
         try {
             //Creating the query for the statement that inserts into the table
            String query = "INSERT INTO customer (`customerID`, "
                    + "`CompanyName`,`ContactName`,`CompanyAddress`, `CompanyCity`, "
                    + "`CompanyPostcode`, `CompanyPhone`)"
                    + "VALUES (default,?,?,?,?,?,?)";
            PreparedStatement preparedStmt = Connect.prepareStatement(query);
            //This uses the query to set all of the values inside the SQL to the corrisponding areas on the table database.
            preparedStmt.setString(1, cusContact);
            preparedStmt.setString(2, cusName);
            preparedStmt.setString(3, cusAddress);
            preparedStmt.setString(4, cusCity);
            preparedStmt.setString(5, cusPostcode);
            preparedStmt.setString(6, cusPhone);

            //Popup box that asks if the user is sure
            int result = JOptionPane.showConfirmDialog(null, "Are you sure you would like to add new customer?", "Confirmation",
                    JOptionPane.DEFAULT_OPTION);
            if (result == JOptionPane.OK_OPTION) {
                preparedStmt.execute();
            }

            //Error handling incase something goes wrong.
        } catch (SQLException sqlx) {
            System.err.println(sqlx.getMessage());
        }
    }
     
     /**
     *
     * @param ProName
     * @param SupID
     * @param CatID
     * @param Stk
     */
     //The void expects the variables to retrieve data from the method
     public void addProduct(String ProName, int SupID, int CatID, int Stk) {
        try {
            //Creating the query for the statement that inserts into the table
            String query = "INSERT INTO product (`productID`, "
                    + "`productName`,`supplierID`,`categoryID`, `Stock`)"
                    + "VALUES (default,?,?,?,?)";
            PreparedStatement preparedStmt = Connect.prepareStatement(query);
            //This uses the query to set all of the values inside the SQL to the corrisponding areas on the table database.
            preparedStmt.setString(1, ProName);
            preparedStmt.setInt(2, SupID);
            preparedStmt.setInt(3, CatID);
            preparedStmt.setInt(4, Stk);
         
            int result = JOptionPane.showConfirmDialog(null, "Are you sure you would like to add new Product?", "Confirmation",
                    JOptionPane.DEFAULT_OPTION);
            if (result == JOptionPane.OK_OPTION) {
                preparedStmt.execute();
            }

        } catch (SQLException sqlx) {
            System.err.println(sqlx.getMessage());
        }
    }
     
        /**
     *
     * @param SuppID
     * @param SuppName
     * @param SuppAddress
     * @param ContName
     * @param SuppCity
     * @param SuppPostcode
     * @param SuppPhone
     */
     //The void expects the variables to retrieve data from the method
     public void addSupplier(int SuppID, String SuppName, String SuppAddress, String ContName, String SuppCity, String SuppPostcode, String SuppPhone) {
        try {
            //Creating the query for the statement that Inserts data into the table
            String query = "INSERT INTO supplier ('supplierID', 'supplierName',"
                    + "'supplierAddress', 'contactName', 'supplierCity' "
                    + "'supplierPostcode', 'supplierPhone'";
                    
                    
            PreparedStatement preparedStmt = Connect.prepareStatement(query);
            //This uses the query to set all of the values inside the SQL to the corrisponding areas on the table database.
            preparedStmt.setString(1, SuppName);
            preparedStmt.setString(2, SuppAddress);
            preparedStmt.setString(3, ContName);
            preparedStmt.setString(4, SuppCity);
            preparedStmt.setString(5, SuppPostcode);
            preparedStmt.setString(6, SuppPhone);
            preparedStmt.setInt(7, SuppID);

            int result = JOptionPane.showConfirmDialog(null, "Are you sure you would like to add this Supplier?", "Confirmation",
                    JOptionPane.DEFAULT_OPTION);
            if (result == JOptionPane.OK_OPTION) {
                preparedStmt.execute();
            }

        } catch (SQLException sqlx) {
            System.err.println(sqlx.getMessage());
        }
    }
     
     /**
     *
     * @param cusID
     * @param cusName
     * @param cusContact
     * @param cusAddress
     * @param cusCity
     * @param cusPostcode
     * @param cusPhone
     */
     //The void expects the variables to retrieve data from the method
     public void EditCust(int cusID, String cusContact, String cusName, String cusAddress, String cusCity, String cusPostcode, String cusPhone) {
        try {
            //Creating the query for the statement that Updates data in the table
            String query = "UPDATE customer SET ContactName = ?,"
                    + "CompanyName = ?, CompanyAddress = ?, CompanyCity = ?, "
                    + "CompanyPostcode = ?, CompanyPhone = ? WHERE CustomerID = ?";
                    
            PreparedStatement preparedStmt = Connect.prepareStatement(query);
            //This uses the query to set all of the values inside the SQL to the corrisponding areas on the table database.
            preparedStmt.setString(1, cusContact);
            preparedStmt.setString(2, cusName);
            preparedStmt.setString(3, cusAddress);
            preparedStmt.setString(4, cusCity);
            preparedStmt.setString(5, cusPostcode);
            preparedStmt.setString(6, cusPhone);
            preparedStmt.setInt(7, cusID);

            int result = JOptionPane.showConfirmDialog(null, "Are you sure you would like to update the customer?", "Confirmation",
                    JOptionPane.DEFAULT_OPTION);
            if (result == JOptionPane.OK_OPTION) {
                preparedStmt.execute();
            }

        } catch (SQLException sqlx) {
            System.err.println(sqlx.getMessage());
        }
    }
     
     /**
     *
     * @param ProID
     * @param ProName
     * @param SupID
     * @param CatID
     * @param Stk
     */
     //The void expects the variables to retrieve data from the method
     public void EditProduct(int ProID, String ProName, int SupID, int CatID, int Stk) {
        try {
            //Creating the query for the statement that Updates data in the table
            String query = "UPDATE product SET productName = ?,"
                    + "supplierID = ?, categoryID = ?, unitsInStock = ? WHERE productID = ?";
                    
                    
            PreparedStatement preparedStmt = Connect.prepareStatement(query);
            //This uses the query to set all of the values inside the SQL to the corrisponding areas on the table database.
            preparedStmt.setString(1, ProName);
            preparedStmt.setInt(2, SupID);
            preparedStmt.setInt(3, CatID);
            preparedStmt.setInt(4, Stk);
            preparedStmt.setInt(5, ProID);

            int result = JOptionPane.showConfirmDialog(null, "Are you sure you would like to update the Product?", "Confirmation",
                    JOptionPane.DEFAULT_OPTION);
            if (result == JOptionPane.OK_OPTION) {
                preparedStmt.execute();
            }

        } catch (SQLException sqlx) {
            System.err.println(sqlx.getMessage());
        }
    }
     
        /**
     *
     * @param SuppID
     * @param SuppName
     * @param SuppAddress
     * @param ContName
     * @param SuppCity
     * @param SuppPostcode
     * @param SuppPhone
     */
     //The void expects the variables to retrieve data from the method
     public void EditSupplier(int SuppID, String SuppName, String SuppAddress, String ContName, String SuppCity, String SuppPostcode, String SuppPhone) {
        try {
            //Creating the query for the statement that Updates data in the table
            String query = "UPDATE supplier SET supplierName = ?,"
                    + "supplierAddress = ?, contactName = ?, supplierCity = ?, "
                    + "supplierPostcode = ?, supplierPhone = ? WHERE supplierID = ?";
                    
                    
            PreparedStatement preparedStmt = Connect.prepareStatement(query);
            //This uses the query to set all of the values inside the SQL to the corrisponding areas on the table database.
            preparedStmt.setString(1, SuppName);
            preparedStmt.setString(2, SuppAddress);
            preparedStmt.setString(3, ContName);
            preparedStmt.setString(4, SuppCity);
            preparedStmt.setString(5, SuppPostcode);
            preparedStmt.setString(6, SuppPhone);
            preparedStmt.setInt(7, SuppID);

            int result = JOptionPane.showConfirmDialog(null, "Are you sure you would like to update the Supplier?", "Confirmation",
                    JOptionPane.DEFAULT_OPTION);
            if (result == JOptionPane.OK_OPTION) {
                preparedStmt.execute();
            }

        } catch (SQLException sqlx) {
            System.err.println(sqlx.getMessage());
        }
    }
     
     /**
     *
     * @param tableName
     * @param id
     */
      //The void expects the variables to retrieve data from the method
    public void deleteAll(String tableName, int id) {
        /*If statements that check what the tablename is and do the if statements
        depending on which table is being selected*/
        if (tableName.equalsIgnoreCase("Customer")) {
            try {
                //String that deletes everything from customer where the id is equal too the id selected in the statement.
                String sql = "DELETE FROM customer WHERE customerID = ?";
                PreparedStatement preparedStmt = Connect.prepareStatement(sql);
                preparedStmt.setInt(1, id);

                int result = JOptionPane.showConfirmDialog(null, "Delete Customer", "Confirmation",
                        JOptionPane.OK_CANCEL_OPTION);
                if (result == JOptionPane.OK_OPTION) {
                    //execute query
                    preparedStmt.execute();
                }

            } catch (SQLException sqlx) {
                System.err.println(sqlx.getMessage());
            }
        }
        
        if (tableName.equalsIgnoreCase("Product")) {
            try {
                String sql = "DELETE FROM product WHERE productID = ?";
                PreparedStatement preparedStmt = Connect.prepareStatement(sql);
                preparedStmt.setInt(1, id);

                int result = JOptionPane.showConfirmDialog(null, "Delete Product", "Confirmation",
                        JOptionPane.OK_CANCEL_OPTION);
                if (result == JOptionPane.OK_OPTION) {
                    //execute query
                    preparedStmt.execute();
                    
                }

            } catch (SQLException sqlx) {
                System.err.println(sqlx.getMessage());
            }
        }
        
        if (tableName.equalsIgnoreCase("Supplier")) {
            try {
                String sql = "DELETE FROM supplier WHERE supplierID = ?";
                PreparedStatement preparedStmt = Connect.prepareStatement(sql);
                preparedStmt.setInt(1, id);

                int result = JOptionPane.showConfirmDialog(null, "Delete Supplier", "Confirmation",
                        JOptionPane.OK_CANCEL_OPTION);
                if (result == JOptionPane.OK_OPTION) {
                    //execute query
                    preparedStmt.execute();
                    
                }

            } catch (SQLException sqlx) {
                System.err.println(sqlx.getMessage());
            }
        }
    }
}
     

