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
public class searchFetchModel {
    
    
    public void fetch(JTextField searchBox,JTable prodTable) {
        try {
            loginPage l = new loginPage();
            String nname = loginPage.name;
            int utype = loginPage.uType;
            String hint = "";
            hint = searchBox.getText();
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
                q = "SELECT * FROM `product` INNER JOIN category on product.catid=category.id where product.name LIKE '%" + hint + "%' ";
            }

            PreparedStatement ps;
            ResultSet rs;

            ps = myConnection.getConnection().prepareStatement(q);
            rs = ps.executeQuery();
            prodTable.setModel(DbUtils.resultSetToTableModel(rs));
            prodTable.setAutoCreateRowSorter(true);
            prodTable.setDefaultEditor(Object.class, null);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
