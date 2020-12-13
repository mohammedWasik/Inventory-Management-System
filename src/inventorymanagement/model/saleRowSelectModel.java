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
public class saleRowSelectModel {
    
        public void rowSelect(JTable saleTable, JTextField name, JTextField price, JTextField cat, JTextField qty) {
        try {

            int row = saleTable.getSelectedRow();
            String tblClick = (saleTable.getModel().getValueAt(row, 0).toString());
            String q = "select * from `product` INNER JOIN category on product.catid=category.id where product.id =" + tblClick + " ";
            PreparedStatement ps;
            ResultSet rs;
            ps = myConnection.getConnection().prepareStatement(q);
            rs = ps.executeQuery(q);
            if (rs.next()) {
                name.setText(rs.getString("name"));
                cat.setText(rs.getString("catname"));
                qty.setText(null);
                price.setText(String.valueOf(rs.getInt("price")));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
