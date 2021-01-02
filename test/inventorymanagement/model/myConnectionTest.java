/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorymanagement.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author wasik
 */
public class myConnectionTest {

    public Connection c;
    public Statement s;

    @Before
    public void setUp() {
    }

    @Test
    public void testGetConnection() throws ClassNotFoundException, SQLException {
       Class.forName("com.mysql.cj.jdbc.Driver");
           c = DriverManager.getConnection("jdbc:mysql://localhost/inventorymanagement", "root", "");
           s = c.createStatement();
           System.out.println(c);
           assertEquals(c!=null,true);
    }

}
