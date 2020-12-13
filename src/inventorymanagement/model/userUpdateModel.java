/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorymanagement;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author wasik
 */
public class userUpdateModel {
    
     public void update(JTable utable, JTextField warehouse, JTextField fname,JTextField lname, JTextField email, JTextField uname,JTextField pass,JTextField phone,JTextField type) {
        try {
            int a = JOptionPane.showConfirmDialog(null, "Are you sure?");
            if (a == JOptionPane.YES_OPTION ) {
                int col = 0;
                int row = utable.getSelectedRow();
                String value = utable.getModel().getValueAt(row, col).toString();
                String query = "UPDATE `userinfo` SET `password` = ?, `email` = ?, `fname` = ?, `lname` = ?, `phone` = ?, `warehouse` = ? ,`type` = ? WHERE `id`=? ";
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
                
                ps.setString(1, ppass);
                ps.setString(2, eemail);
                ps.setString(3, ffname);
                ps.setString(4, llname);
                ps.setString(5, pphone);
                ps.setString(6, ware);
                ps.setString(7, ttype);
                ps.setString(8, value);

                System.out.println(ps + "this is ps");

                ps.executeUpdate();
                clearJTxtFld(warehouse, fname, lname, email, uname, pass, phone, type);
                userInitialFetchModel u = new userInitialFetchModel();
        u.initialFetch(utable);

            }
        } catch (SQLException e1) {
            System.out.println(e1);
        }
    }
     
     public void clearJTxtFld(JTextField warehouse, JTextField fname,JTextField lname, JTextField email, JTextField uname,JTextField pass,JTextField phone,JTextField type) {
        fname.setText("");
        lname.setText("");
        uname.setText("");
        pass.setText("");
        email.setText("");
        phone.setText("");
        warehouse.setText("");
        type.setText("");
    }
    
}
