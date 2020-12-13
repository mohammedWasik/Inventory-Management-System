/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorymanagement.model;

import inventorymanagement.myConnection;
import inventorymanagement.view.loginPage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JTable;

/**
 *
 * @author wasik
 */
public class checkoutModel {
    
    public void checkout(JTable billTable) {
        try {
            String userName = loginPage.name;
            int aNumber = (int) ((Math.random() * 9000000) + 1000000);
            System.out.println(aNumber);
            int row = billTable.getRowCount();
            System.out.println("row is = " + row);
            Connection s = myConnection.getConnection();
            //System.out.println(s);
            s.setAutoCommit(false);
            String q = "UPDATE product set `qty` = qty -? where name = ? ";
            String h = "INSERT INTO `history` (`id`, `date`, `pname`, `qty`, `price`, `sby`,`invoiceno`) VALUES (NULL, current_timestamp(), ?,?,?,?,?) ";
            PreparedStatement pst, pht;
            pst = s.prepareStatement(q);
            pht = s.prepareStatement(h);
            for (int i = 0; i < row; i++) {
                String prname = (String) billTable.getValueAt(i, 1);
                //System.out.println(prname);
                String quantity = (String) billTable.getValueAt(i, 3);
                String priceprod = String.valueOf(billTable.getValueAt(i, 2));
                String soldBy = userName;
                String invoice = String.valueOf(aNumber);
                //int pr = Integer.parseInt(priceprod);
                pst.setString(1, quantity);
                pst.setString(2, prname);

                pht.setString(1, prname);
                pht.setString(2, quantity);
                pht.setString(3, priceprod);
                pht.setString(4, soldBy);
                pht.setString(5, invoice);

                System.out.println(pst);
                System.out.println(pht);

                pst.addBatch();
                pht.addBatch();

            }
            pst.executeBatch();
            pht.executeBatch();
            s.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
}
