/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorymanagement.model;
import inventorymanagement.myConnection;
import inventorymanagement.view.loginPage;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author wasik
 */
public class saveModel {
    public void save(JTextField username, JTextField pass, JTextField email, JTextField phone, JTextField fname, JTextField lname) {
        try {

            int a = JOptionPane.showConfirmDialog(null, "Are you sure?");
            if (a == JOptionPane.YES_OPTION) {

                loginPage l = new loginPage();
                String nname = l.getname();
                String query = "UPDATE `userinfo` SET `password` = ?, `email` = ?, `fname` = ?, `lname` = ?, `phone` = ? WHERE `username`=? ";

                String ffname = fname.getText().trim();
                String llname = lname.getText().trim();
                String eemail = email.getText().trim();
                String uuname = username.getText().trim();
                String ppass = pass.getText().trim();
                String pphone = phone.getText().trim();

                PreparedStatement ps = myConnection.getConnection().prepareStatement(query);

                ps.setString(1, ppass);
                ps.setString(2, eemail);
                ps.setString(3, ffname);
                ps.setString(4, llname);
                ps.setString(5, pphone);
                ps.setString(6, nname);

                System.out.println(ps + "this is ps");

                ps.executeUpdate();

            }
        } catch (SQLException e1) {
            System.out.println(e1);
        }
    }
    
}
