/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorymanagement.model;

import inventorymanagement.myConnection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author wasik
 */
public class insertModel {
    
     public void insert(JTable itemTable,JTextField name,JTextField price,JTextField quantity,JTextField category, JTextField wareid, JTextField active) {
        try {
            String query = "INSERT INTO product(id,name,price,qty,catid,wareid,prodactive) values (null,?,?,?,?,?,?) ";

            String prodNameString = name.getText().trim();
            String priceString = price.getText().trim();
            String qtyString = quantity.getText().trim();
            String wareString = wareid.getText().trim();
            String catString = category.getText().trim();
            String activeString = active.getText().trim();

            PreparedStatement ps = myConnection.getConnection().prepareStatement(query);
            ps.setString(1, prodNameString);
            ps.setString(2, priceString);
            ps.setString(3, qtyString);
            ps.setString(4, catString);
            ps.setString(5, wareString);
            ps.setString(6, activeString);

            System.out.println(ps + "this is ps");

            ps.executeUpdate();
            clearJTxtFld(name, price, quantity, category, wareid, active);
            fetchModel f = new fetchModel();
            f.fetch(itemTable);
        } catch (SQLIntegrityConstraintViolationException e) {
            clearJTxtFld(name, price, quantity, category, wareid, active);
            JOptionPane.showMessageDialog(null, "Already Exists");
            e.printStackTrace();
        } catch (SQLException e) {
            clearJTxtFld(name, price, quantity, category, wareid, active);
            JOptionPane.showMessageDialog(null, e);
            e.printStackTrace();
        }
    }
     
     
    public void clearJTxtFld(JTextField name,JTextField price,JTextField quantity,JTextField category, JTextField wareid, JTextField active) {
        name.setText("");
        quantity.setText("");
        price.setText("");
        active.setText("");
        wareid.setText("");
        category.setText("");

    }
}
