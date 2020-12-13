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
import javax.swing.*;

/**
 *
 * @author wasik
 */
public class rowSelectModel {
    
    public void rowSelect(JTable itemTable, JTextField name,JTextField price,JTextField quantity,JTextField category, JTextField wareid, JTextField active) {
        try {
            int utype = loginPage.uType;
            String nname = loginPage.name;
            int row = itemTable.getSelectedRow();
            String tblClick = (itemTable.getModel().getValueAt(row, 0).toString());
            String q;
            //System.out.println(name);
            if (utype == 1 || nname == null || nname.isEmpty()) {
                q = "select * from `product` INNER JOIN category on product.catid=category.id where product.id =" + tblClick + " order by wareid";
            } else {
                q = "SELECT * FROM `product` INNER JOIN category on product.catid=category.id where product.wareid in (SELECT warehouse FROM `userinfo` WHERE `username` = '" + nname + "' ) and product.id =" + tblClick + "";
            }
            PreparedStatement ps;
            ResultSet rs;
            ps = myConnection.getConnection().prepareStatement(q);
            rs = ps.executeQuery();
            if (rs.next()) {
                name.setText(rs.getString("name"));
                price.setText(rs.getString("price"));
                quantity.setText(rs.getString("qty"));
                category.setText(rs.getString("catid"));
                wareid.setText(String.valueOf(rs.getInt("wareid")));
                active.setText(String.valueOf(rs.getInt("active")));

            }

        } catch (Exception e) {

        }
    }
    
}
