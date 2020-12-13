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
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.JTextField;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author wasik
 */
public class sFetchModel {
    
    public void seaFetch(JTable saleTable,JTextField searchbox, JTextField name) {
        try {
            loginPage l = new loginPage();
            String nname = l.getname();
            System.out.println("this is sale nname" + nname);
            int utype = loginPage.uType;
            String hint = "";
            hint = searchbox.getText();
            System.out.println(hint + "   this is hint");
            //System.out.println(name);
            String q;
            if (utype == 1 || nname == null) {
                if (hint.isEmpty()) {
                    q = "select * from `product` INNER JOIN category on product.catid=category.id ";
                } else {
                    q = "SELECT * FROM `product` INNER JOIN category on product.catid=category.id where product.name LIKE '%" + hint + "%' ";
                }
            } else {
                q = "SELECT * FROM `product` INNER JOIN category on product.catid=category.id where product.wareid in (SELECT warehouse FROM `userinfo` WHERE `username` = '" + name + "' ) AND product.name LIKE '%" + hint + "%' ";
            }

            PreparedStatement ps;
            ResultSet rs;

            ps = myConnection.getConnection().prepareStatement(q);
            rs = ps.executeQuery();
            saleTable.setModel(DbUtils.resultSetToTableModel(rs));
            saleTable.setAutoCreateRowSorter(true);
            saleTable.setDefaultEditor(Object.class, null);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
