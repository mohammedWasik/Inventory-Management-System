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
import net.proteanit.sql.DbUtils;

/**
 *
 * @author wasik
 */
public class catFetchModel {
       public void catFetch(int i,JTable inTable) {
        try {
            loginPage l = new loginPage();
            String nname = loginPage.name;
            int utype = loginPage.uType;
            String q;

            //System.out.println(name);
            if (utype == 1 || nname == null) {
                q = "select * from `product` INNER JOIN category on product.catid=category.id where catid = ? ";
            } else {
                q = "SELECT * FROM `product` INNER JOIN category on product.catid=category.id where product.wareid in (SELECT warehouse FROM `userinfo` WHERE `username` = '" + nname + "' ) and catid = ?";
            }

            PreparedStatement ps;
            ResultSet rs;

            ps = myConnection.getConnection().prepareStatement(q);
            ps.setInt(1, i);
            rs = ps.executeQuery();
            inTable.setModel(DbUtils.resultSetToTableModel(rs));
            inTable.setAutoCreateRowSorter(true);
            inTable.setDefaultEditor(Object.class, null);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
