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
import javax.swing.ListSelectionModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author wasik
 */
public class saleFetchModel {
    
        public void fetch(JTable saleTable,JTable billTable) {
        try {
            loginPage l = new loginPage();
            String nname = loginPage.name;
            //System.out.println("this is sale nname " + nname + ".");
            int utype = loginPage.uType;
            String q;

            //System.out.println(name);
            if (utype == 1 || nname == null) {
                q = "select * from `product` INNER JOIN category on product.catid=category.id where qty > '0' order by wareid";
            } else {
                q = "SELECT * FROM `product` INNER JOIN category on product.catid=category.id where product.wareid in (SELECT warehouse FROM `userinfo` WHERE `username` = '" + nname + "' ) and qty > '0' ";
            }

            PreparedStatement ps;
            ResultSet rs;

            ps = myConnection.getConnection().prepareStatement(q);
            rs = ps.executeQuery();
            saleTable.setModel(DbUtils.resultSetToTableModel(rs));
            saleTable.setDefaultEditor(Object.class, null);
            billTable.setDefaultEditor(Object.class, null);
            saleTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
