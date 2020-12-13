/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorymanagement;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author wasik
 */
public class userInsertModel {
     public void insert(JTable utable, JTextField warehouse, JTextField fname,JTextField lname, JTextField email, JTextField uname,JTextField pass,JTextField phone,JTextField type) {
        try {
            String query = "INSERT INTO userinfo(username,password,email,fname,lname,phone,warehouse,type) values (?,?,?,?,?,?,?,?) ";
            String ware = warehouse.getText();
            String ffname = fname.getText().trim();
            String llname = lname.getText().trim();
            String eemail = email.getText().trim();
            String uuname = uname.getText().trim();
            String ppass = pass.getText().trim();
            String pphone = phone.getText().trim();
            String ttype = type.getText().trim();
            System.out.println(ware + " before nuuilll");
            if (ware.isEmpty()) {
                ware = null;
                System.out.println(ware);
            }
            PreparedStatement ps = myConnection.getConnection().prepareStatement(query);
            ps.setString(1, uuname);
            ps.setString(2, ppass);
            ps.setString(3, eemail);
            ps.setString(4, ffname);
            ps.setString(5, llname);
            ps.setString(6, pphone);
            ps.setString(7, ware);
            ps.setString(8, ttype);

            System.out.println(ps + "this is ps");

            ps.executeUpdate();
            userInitialFetchModel u = new userInitialFetchModel();
            u.initialFetch(utable);
        } catch (SQLException e1) {
            System.out.println(e1);
        }
    }

    
}
