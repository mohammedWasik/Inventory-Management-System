/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorymanagement;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author wasik
 */
public class userInitialFetchModel {
    
     public void initialFetch(JTable utable) {
        try {
            String query = "Select * from `userinfo` order by id";

            PreparedStatement ps;
            ResultSet rs;

            ps = myConnection.getConnection().prepareStatement(query);
            rs = ps.executeQuery();
            utable.setModel(DbUtils.resultSetToTableModel(rs));
            utable.setDefaultEditor(Object.class, null);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    
}
