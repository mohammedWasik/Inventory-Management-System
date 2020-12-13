/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorymanagement.model;

import inventorymanagement.myConnection;
import inventorymanagement.view.Index;
import inventorymanagement.view.indexAdmin;
import java.awt.HeadlessException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author wasik
 */
public class loginModel {
    
    public void loggin(String name, JTextField username,JPasswordField password, int uType) {
        name = username.getText();
        System.out.println("this is loggin() name "+name);
        String pass = new String(password.getPassword());
        PreparedStatement ps, pst;
        ResultSet rs, rst;
        Statement st;
        String type = "SELECT type FROM `userinfo` WHERE `username` =? AND `password` =?";
        String query = "SELECT * FROM `userinfo` WHERE `username` =? AND `password` =?";
        //System.out.println(name + "   1");

        try {
            // System.out.println(name + "   2");
            ps = (PreparedStatement) myConnection.getConnection().prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, pass);

            pst = (PreparedStatement) myConnection.getConnection().prepareStatement(type);
            pst.setString(1, name);
            pst.setString(2, pass);

            //System.out.println(name + "   3");
            rs = ps.executeQuery();
            rst = pst.executeQuery();
            uType = 0;
            if (rst.next()) {
                uType = rst.getInt(1);
                //System.out.println("type is --" + i);
            }
            if (rs.next()) {
                if (uType == 0) {

                    Index index = new Index();
                    index.setVisible(true);
                    index.setLocationRelativeTo(null);

                } else {
                    indexAdmin in = new indexAdmin();
                    in.setVisible(true);
                    in.setLocationRelativeTo(null);

                }
            } else {
                username.setText(null);
                password.setText(null);
                username.requestFocus();
                JOptionPane.showMessageDialog(null, "Incorret Username or Password");

            }
        } catch (HeadlessException | SQLException e) {
            e.printStackTrace();
        }

    }

}
