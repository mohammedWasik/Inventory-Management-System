/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorymanagement.model;

import inventorymanagement.myConnection;
import inventorymanagement.view.loginPage;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JTextField;

/**
 *
 * @author wasik
 */
public class pfetchModel {
    
        public void pfetch(JTextField username, JTextField pass, JTextField email, JTextField phone, JTextField fname, JTextField lname  ) {
        try {
            loginPage l = new loginPage();
            String nname = loginPage.name;
            System.out.println("profule " + nname);
            String query = "select * from userinfo where `username`='" + nname + "'";
            PreparedStatement ps = myConnection.getConnection().prepareStatement(query);
            System.out.println("this is  save ps --- " + ps);
            ResultSet rs = ps.executeQuery(query);
            if (rs.next()) {
                username.setText(rs.getString("username"));
                pass.setText(rs.getString("password"));
                email.setText(rs.getString("email"));
                phone.setText(String.valueOf(rs.getString("phone")));
                fname.setText(rs.getString("fname"));
                lname.setText(rs.getString("lname"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
