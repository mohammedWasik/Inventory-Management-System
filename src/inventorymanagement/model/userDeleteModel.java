/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorymanagement;

import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author wasik
 */
public class userDeleteModel {
    
      public void delete(JTable utable, JTextField warehouse, JTextField fname,JTextField lname, JTextField email, JTextField uname,JTextField pass,JTextField phone,JTextField type) {
        try {
            int a = JOptionPane.showConfirmDialog(null, "Are you sure ?");
            if (a == JOptionPane.YES_OPTION) {
                System.out.println("in if of pane");

                String usename = uname.getText();
                String query = "delete from userinfo where username = '" + usename + "' ";
                PreparedStatement ps = myConnection.getConnection().prepareStatement(query);

                ps.executeUpdate();
                userInitialFetchModel u = new userInitialFetchModel();
                u.initialFetch(utable);
                userUpdateModel uu = new userUpdateModel();
                uu.clearJTxtFld(warehouse, fname, lname, email, uname, pass, phone, type);
            }

        } catch (Exception e) {

        }
    }
    
}
