/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorymanagement;

import java.sql.*;

/**
 *
 * @author hopeless
 */
public class myConnection {

    public static Connection getConnection() {
        Connection con1 = null;

        try {
            Class.forName("com.mysql.jdbc.Driver"); 
        con1 = DriverManager.getConnection("jdbc:mysql://localhost/inventorymanagement","root","");

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
       //System.out.println(con1 + " ------------this is con1 ");
        return con1;
    }

}
