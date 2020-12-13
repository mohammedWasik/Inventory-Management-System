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
public class showHistoryModel
{
     public void showHistory(JTable jTable1) {
        try {
             loginPage l = new loginPage();
            String nname = loginPage.name;
            int utype = loginPage.uType;
            String query;

            if ( utype==1 || nname == null) {
                query = "select date,pname,qty,price,sby,invoiceno from history ";
            } else {
                query = "select date,pname,qty,price,sby,invoiceno from history where sby = '" + nname + "'";
            }

            PreparedStatement ps = myConnection.getConnection().prepareStatement(query);
            ResultSet rs = ps.executeQuery(query);
            
            jTable1.setModel(DbUtils.resultSetToTableModel(rs));
            jTable1.setAutoCreateRowSorter(true);
            jTable1.setDefaultEditor(Object.class, null);            

        } catch (Exception e) {

        }

    }

}
