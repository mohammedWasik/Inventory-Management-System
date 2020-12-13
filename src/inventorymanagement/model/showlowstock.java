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
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author wasik
 */
public class showlowstock {
    
    
    
     public void showLowStock(JTable jTable1) {
        try {
             loginPage l = new loginPage();
            String nname =loginPage.name;
            int utype = loginPage.uType;
            String q;

            //System.out.println(name);
            if (utype == 1 || nname == null) {
                q = "select name,qty,wareid from `product` INNER JOIN category on product.catid=category.id where qty < '15' order by wareid";
            } else {
                q = "SELECT name,qty,wareid FROM `product` INNER JOIN category on product.catid=category.id where product.wareid in (SELECT warehouse FROM `userinfo` WHERE `username` = '" + nname + "' ) and qty < '15'";
            }

            PreparedStatement ps;
            ResultSet rs;

            ps = myConnection.getConnection().prepareStatement(q);
            rs = ps.executeQuery();
            jTable1.setModel(DbUtils.resultSetToTableModel(rs));
            jTable1.setAutoCreateRowSorter(true);
            jTable1.setDefaultEditor(Object.class, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
