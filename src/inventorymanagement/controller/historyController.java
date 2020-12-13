/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorymanagement.controller;

import inventorymanagement.view.Index;
import inventorymanagement.view.indexAdmin;
import inventorymanagement.view.loginPage;
import inventorymanagement.model.showHistoryModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author wasik
 */
public class historyController {

    public void showHistory(JTable jTable1) {
        showHistoryModel s = new showHistoryModel();
        s.showHistory(jTable1);

    }

    public void logOut() {
        int a = JOptionPane.showConfirmDialog(null, "Are you sure ?");
        if (a == JOptionPane.YES_OPTION) {

            loginPage login = new loginPage();
            login.setVisible(true);
        }
    }

    public void back() {
        int i = loginPage.uType;
        if (i == 0) {
            Index index = new Index();
            index.setVisible(true);
        } else {
            indexAdmin in = new indexAdmin();
            in.setVisible(true);
            in.setLocationRelativeTo(null);

        }
    }

}
