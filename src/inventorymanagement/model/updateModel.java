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
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author wasik
 */
public class updateModel {
    
     public void update(JTable itemTable,JTextField name,JTextField price,JTextField quantity,JTextField category, JTextField wareid, JTextField active) {
        try {
            int a = JOptionPane.showConfirmDialog(null, "Are you sure?");
            if (a == JOptionPane.YES_OPTION) {
                int col = 0;
                int row = itemTable.getSelectedRow();
                String val = itemTable.getModel().getValueAt(row, 1).toString();
                String query = "UPDATE `product` SET `price` = ?, `qty` = ?, `prodactive` = ? WHERE `name`=? ";

                String prodNameString = name.getText().trim();
                String priceString = price.getText().trim();
                String qtyString = quantity.getText().trim();
                String wareString = wareid.getText().trim();
                String catString = category.getText().trim();
                String activeString = active.getText().trim();

                PreparedStatement ps = myConnection.getConnection().prepareStatement(query);

                ps.setString(1, priceString);
                ps.setString(2, qtyString);
                ps.setString(3, activeString);
                ps.setString(4, val);

                System.out.println(ps + "this is ps");

                ps.executeUpdate();
                clearJTxtFld(name, price, quantity, category, wareid, active);

                fetchModel f = new fetchModel();
                f.fetch(itemTable);

            }
        } catch (SQLException e1) {
            JOptionPane.showMessageDialog(null, e1);
            System.out.println(e1);
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
