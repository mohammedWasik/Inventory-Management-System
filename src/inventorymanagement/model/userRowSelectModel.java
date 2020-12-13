/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorymanagement;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author wasik
 */
public class userRowSelectModel {
     public void rowSelect(JTable utable, JTextField warehouse, JTextField fname,JTextField lname, JTextField email, JTextField uname,JTextField pass,JTextField phone,JTextField type) {
        try {
            int row = utable.getSelectedRow();
            String tblClick = (utable.getModel().getValueAt(row, 0).toString());
            String q = "select * from userinfo where id =" + tblClick + " ";
            PreparedStatement ps;
            ResultSet rs;
            ps = myConnection.getConnection().prepareStatement(q);
            rs = ps.executeQuery();
            if (rs.next()) {
                fname.setText(rs.getString("fname"));
                lname.setText(rs.getString("lname"));
                email.setText(rs.getString("email"));
                uname.setText(rs.getString("username"));
                pass.setText(rs.getString("password"));
                phone.setText(rs.getString("phone"));
                warehouse.setText(String.valueOf(rs.getInt("warehouse")));
                type.setText(String.valueOf(rs.getInt("type")));
            }

        } catch (Exception e) {

        }
    }
    
}
